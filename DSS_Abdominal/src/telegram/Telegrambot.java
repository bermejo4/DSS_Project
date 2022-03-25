package telegram;

import dss_abdominal.Patient;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Telegrambot extends TelegramLongPollingBot {

    private String token;

    private ArrayList<String> sessions;
    private ArrayList<Patient> patients;
    private ArrayList<Long> times;
    private Set<String> acceptable_answers_set;

    private boolean askingAge;

    protected static final long TIMEOUT = 600000; // in ms
    
    public static float ibsPorcentage = -1;
    public static float chronPorcentage = -1;
    public static float ulcerativeColitisPorcentage=-1;
    public static float diverticulosisPorcentage = -1;
    public static float herniaPorcentage=-1;
    public static float appendicitisPorcentage=-1;
    public static float enterocolitisPorcentage=-1;
    public static float celiacPorcentage=-1;
    public static float colorectalCancerPorcentage=-1;
    
    Patient ibs = new Patient("Irritable Bowel Syndrom",Patient.Gender.FEMALE,Patient.AgeRange.YOUNG,1f,1f,1f,1f,true,false,false,true,1f,0f,0f,0f,true,1f,false,0f,0f,false,0f,0f,0f,0f,0f);    
    Patient chron = new Patient("Chron",Patient.Gender.FEMALE,Patient.AgeRange.YOUNGADULT,1f,2f,1f,1f,true,true,true,true,0f,1f,2f,0f,true,0f,false,1f,0f,false,1f,0f,0f,0f,0f);        
    Patient ulcerative_colitis = new Patient("Ulcerative Colitis",Patient.Gender.MALE,Patient.AgeRange.YOUNGADULT,2f,1f,0f,0f,true,true,false,true,2f,1f,2f,0f,true,0f,false,0f,0f,false,0f,0f,1f,1f,0f);
    Patient diverticulosis = new Patient("Diverticulosis",Patient.Gender.FEMALE,Patient.AgeRange.ADULT,2f,0f,2f,0f,false,false,true,true,2f,0f,0f,0f,false,2f,false,1f,0f,false,0f,1f,1f,0f,0f);
    Patient hernia = new Patient("Inguinal or Abdominal Hernia",Patient.Gender.MALE,Patient.AgeRange.CHILD,2f,0f,2f,2f,false,false,false,false,2f,0f,0f,0f,true,0f,true,2f,0f,false,0f,0f,0f,0f,0f);
    Patient appendicitis = new Patient("Appendicitis",Patient.Gender.MALE,Patient.AgeRange.YOUNGADULT,2f,2f,2f,2f,false,false,true,true,0f,0f,0f,2f,false,0f,false,2f,0f,false,0f,0f,0f,0f,0f);
    Patient enterocolitis = new Patient("Infectious Enterocolitis",null,Patient.AgeRange.CHILD,2f,0f,1f,1f,false,false,false,true,2f,1f,0f,0f,false,0f,false,1f,2f,true,0f,0f,0f,0f,0f);
    Patient celiac_Disease = new Patient("Celiac Disease",Patient.Gender.FEMALE,Patient.AgeRange.ADULT,1f,2f,1f,1f,true,true,false,true,0f,1f,0f,0f,true,0f,false,0f,0f,false,0f,0f,0f,0f,0f);
    Patient colorectal_cancer = new Patient("Colorectal Cancer",Patient.Gender.MALE,Patient.AgeRange.ADULT,2f,1f,2f,2f,true,true,true,false,2f,2f,2f,0f,true,0f,false,0f,0f,false,0f,0f,0f,0f,0f);
         

    public Telegrambot(String token) {
        super();
        this.token = token;
        sessions = new ArrayList<>();
        patients = new ArrayList<>();
        times = new ArrayList<>();

        acceptable_answers_set = new HashSet<String>();
        acceptable_answers_set.add("yes");
        acceptable_answers_set.add("y");
        acceptable_answers_set.add("no");
        acceptable_answers_set.add("n");
        acceptable_answers_set.add("1");
        acceptable_answers_set.add("2");
        acceptable_answers_set.add("3");
        acceptable_answers_set.add("female");
        acceptable_answers_set.add("f");
        acceptable_answers_set.add("male");
        acceptable_answers_set.add("m");
    }

    public String getBotUsername() {
        return "Abdominal Pain DSS";
    }


    public String getBotToken() {
        return token;
    }


    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text

        if (update.hasMessage() && update.getMessage().hasText()) {

            String chatId = update.getMessage().getChatId().toString();
            // First we check if this chat has a session:
            int pos = sessions.indexOf(chatId);
            if (pos != -1) {
                processMessage(update);
            } else {
                // This is either the case they have contacted us for the first time or that they have been removed due to inactivity

                SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields

                message.setChatId(update.getMessage().getChatId().toString()); // Answer to the same chat.
                message.setText("Welcome to the DSS for Abdominal Pain. Type /start to start your analysis or /help to see a list of commands.");

                System.out.println("Adding chatId: " + chatId);
                // We add this new Client to the list of clients.
                sessions.add(chatId);
                patients.add(null);
                times.add(System.currentTimeMillis());

                sendMessage(message);

            }


        }
    }

    private void processMessage(Update update) {
        // We update the last time we saw a client.
        String chatId = update.getMessage().getChatId().toString();
        int pos = sessions.indexOf(chatId);
        times.set(pos, System.currentTimeMillis());

        String message_received = update.getMessage().getText();
        if (message_received.startsWith("/")) {
            // It's a command
            processCommand(message_received, update);
        } else if (acceptable_answers_set.contains(message_received.toLowerCase()) || askingAge) {
            // It's an acceptable answer, but we still have to check for each symptom if it makes sense.
            addAnswer(pos, message_received);

        } else {

            String answer = "I'm sorry, I couldn't understand you. Please introduce one of the available answers or type /help to see the commands.";
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields

            message.setChatId(update.getMessage().getChatId().toString());

            message.setText(answer);

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void processCommand(String msg, Update update) {
        String command;

        String chatId = update.getMessage().getChatId().toString();
        int session_pos = sessions.indexOf(chatId);

        String[] data = msg.split(" ");
        command = data[0].toLowerCase();
        System.out.println("ChatId: "+chatId+" -> Command: "+command);

        if (command.equals("/start")) {
            // Initiate the patient and start asking questions.
            patients.set(session_pos, new Patient());
            SendMessage answer = new SendMessage();
            answer.setChatId(chatId);
            answer.setText("We are going to start asking you questions now. Please answer with the numbers at the left " +
                    "of the options. If no number is provided you can answer freely\n\nWere you born male(m) or female(f)?");

            sendMessage(answer);


        } else if (command.equals("/help")) {
            SendMessage answer = new SendMessage();
            answer.setChatId(chatId);
            answer.setText("This is a list of the current available commands:" +
                    "\n/help: displays this message" +
                    "\n/start: Initiates the symptom questionnaire" +
                    "\n/stop: Ends the connection" +
                    "\n/back [back_num]: Goes back one question or more if specified." +
                    "\n/hellothere: easter egg");
            sendMessage(answer);

        } else if (command.equals("/stop")) {
            sessions.remove(session_pos);
            patients.remove(session_pos);
            times.remove(session_pos);

            SendMessage answer = new SendMessage();
            answer.setText("Goodbye!");
            answer.setChatId(chatId);
            sendMessage(answer);

        } else if (command.equals("/back")) {
            int back_num = 1;
            if ( data.length > 1 ){
                try {
                    back_num = Integer.parseInt(data[1]);
                } catch ( NumberFormatException e ) {
                    SendMessage m = new SendMessage();
                    m.setChatId(chatId);
                    m.setText("Please enter a number as the parameter to the /back command or nothing. EG: /back 3");
                    sendMessage(m);
                }
            }

            for(; back_num > 0; back_num--) {
                // This line is a bit confusing. It will remove answers, and only send the message of the last one.
                // If it reaches the point of removing the gender and then it can't go back anymore, it will break the loop
                if ( ! deleteLastAnswer(session_pos, back_num==1) ) break;
            }

        } else if (command.equals("/hellothere")) {
            // easter_egg
            InputFile gif = new InputFile("https://external-preview.redd.it/ydorx1_c0fBD-RrGB6zVx4GW0T5iSkUpietCeb9Kq2E.gif?format=mp4&s=5e48de033628db5b07945a9d128823ac5837b094");
            SendAnimation test = new SendAnimation(update.getMessage().getChatId().toString(), gif);
            test.setCaption("General Kenobi!!");
            try {
                execute(test); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {

            String answer = "That command hasn't been implemented yet!";

        }


    }

    private void sendMessage(SendMessage m) {
        try {
            execute(m); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    protected void cleanSessions() {
        for (int i = 0; i < sessions.size(); i++) {
            if ((System.currentTimeMillis() - times.get(i)) > TIMEOUT) {
                System.out.println("Removing chatId: " + sessions.get(i));
                sessions.remove(i);
                patients.remove(i);
                times.remove(i);
                // As the list is shifting one down, we have to go through this position once more.
                i--;
            }
        }
    }

    private void addAnswer(int sessionPos, String answer) {
        Patient patient = patients.get(sessionPos);
        SendMessage message = new SendMessage();
        message.setChatId(sessions.get(sessionPos));

        if (patient.getGender() == null) {
            if (answer.equals("female") || answer.equals("f")) {
                patient.setGender(Patient.Gender.FEMALE);
            } else if (answer.equals("male") || answer.equals("m")) {
                patient.setGender(Patient.Gender.MALE);
            } else {
                message.setText("Sorry, I couldn't understand you.\nWere you born male(m) or female(f)?");
                sendMessage(message);
                return;
            }
            // ask for age
            askingAge = true;
            message.setText("What is your age?");
            sendMessage(message);

        } else if (patient.getAge() == null) {
            try {
                int age = Integer.parseInt(answer);
                if ( age < 0 ) {
                    message.setText("Sorry, I couldn't understand you.\nWhat is your age?");
                    sendMessage(message);
                    return;
                } else if (age < 10) {
                    patient.setAge(Patient.AgeRange.CHILD);
                } else if (age < 14) {
                    patient.setAge(Patient.AgeRange.YOUNG);
                } else if (age < 35) {
                    patient.setAge(Patient.AgeRange.YOUNGADULT);
                } else if (age < 115) {
                    patient.setAge(Patient.AgeRange.ADULT);
                } else {
                    message.setText("Sorry, I couldn't understand you.\nWhat is your age?");
                    sendMessage(message);
                    return;
                }
                // ask for abpain
                message.setText("How would you rate your abdominal pain?\n1. None\n2. Mild\n3. Severe");
                sendMessage(message);
            } catch (NumberFormatException e) {
                message.setText("Please introduce a number");
                sendMessage(message);
            }
        } else if (patient.getAbdpain() == null) {
            switch (answer) {
                case "1":
                    patient.setAbdpain(0);
                    break;
                case "2":
                    patient.setAbdpain(1);
                    break;
                case "3":
                    patient.setAbdpain(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHow would you rate your abdominal pain?\n1. None\n2. Mild\n3. Severe");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you suffer abdominal distention (inflated belly)?\n1. No\n2. Low\n3. High");
            sendMessage(message);
        } else if (patient.getDistention() == null) {
            switch (answer) {
                case "1":
                    patient.setDistention(0);
                    break;
                case "2":
                    patient.setDistention(1);
                    break;
                case "3":
                    patient.setDistention(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nDo you suffer abdominal distention (inflated belly)?\n1. No\n2. Low\n3. High");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you suffer nausea?\n1. No\n2. Sporadically\n3. Frequently");
            sendMessage(message);
        } else if (patient.getNausea() == null) {
            switch (answer) {
                case "1":
                    patient.setNausea(0);
                    break;
                case "2":
                    patient.setNausea(1);
                    break;
                case "3":
                    patient.setNausea(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nDo you suffer nausea?\n1. No\n2. Sporadically\n3. Frequently");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you experience vomiting lately?\n1. No\n2. Sporadically\n3. Frequently");
            sendMessage(message);
        } else if (patient.getVomiting() == null) {
            switch (answer) {
                case "1":
                    patient.setVomiting(0);
                    break;
                case "2":
                    patient.setVomiting(1);
                    break;
                case "3":
                    patient.setVomiting(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you experience vomiting lately?\n1. No\n2. Sporadically\n3. Frequently");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you felt unusually anxious or depressed lately?(yes/no)");
            sendMessage(message);
        } else if (patient.isAnxiety() == null) {
            switch (answer) {
                case "yes":
                case "y":
                    patient.setAnxiety(true);
                    break;
                case "no":
                case "n":
                    patient.setAnxiety(false);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you felt unusually anxious or depressed lately?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you have any antecedents of intestinal diseases in your close family?(yes/no)");
            sendMessage(message);
        } else if (patient.isGenetic() == null) {
            switch (answer) {
                case "yes":
                case "y":
                    patient.setGenetic(true);
                    break;
                case "no":
                case "n":
                    patient.setGenetic(false);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nDo you have any antecedents of intestinal diseases in your close family?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you smoke?(yes/no)");
            sendMessage(message);
        } else if (patient.isTobacco() == null) {
            switch (answer) {
                case "yes":
                case "y":
                    patient.setTobacco(true);
                    break;
                case "no":
                case "n":
                    patient.setTobacco(false);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nDo you smoke?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you suffer Diarrhea?(yes/no)");
            sendMessage(message);
        } else if (patient.isDiarrhea() == null) {
            switch (answer) {
                case "yes":
                case "y":
                    patient.setDiarrhea(true);
                    break;
                case "no":
                case "n":
                    patient.setDiarrhea(false);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nDo you suffer Diarrhea?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you bled from the anus?\n1. None\n2. Focalized\n3. Extended");
            sendMessage(message);
        } else if (patient.getRectalHemo() == null) {
            switch (answer) {
                case "1":
                    patient.setRectalHemo(0);
                    break;
                case "2":
                    patient.setRectalHemo(1);
                    break;
                case "3":
                    patient.setRectalHemo(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you bled from the anus?\n1. None\n2. Focalized\n3. Extended");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you felt exhausted?\n1. No\n2. Mildly\n3. Absolutely");
            sendMessage(message);
        } else if (patient.getExhaustion() == null) {
            switch (answer) {
                case "1":
                    patient.setExhaustion(0);
                    break;
                case "2":
                    patient.setExhaustion(1);
                    break;
                case "3":
                    patient.setExhaustion(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you felt exhausted?\n1. No\n2. Mildly\n3. Absolutely");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you lost weight lately?\n1. No\n2. Very little(0-5%)\n3. A lot(>5%)");
            sendMessage(message);
        } else if (patient.getWeightLoss() == null) {
            switch (answer) {
                case "1":
                    patient.setWeightLoss(0);
                    break;
                case "2":
                    patient.setWeightLoss(1);
                    break;
                case "3":
                    patient.setWeightLoss(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you lost weight lately?\n1. No\n2. Very little(0-5%)\n3. A lot(>5%)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you been experiencing abdominal cramps?\n1. No\n2. A few\n3. A lot(can't stand)");
            sendMessage(message);
        } else if (patient.getCramps() == null) {
            switch (answer) {
                case "1":
                    patient.setCramps(0);
                    break;
                case "2":
                    patient.setCramps(1);
                    break;
                case "3":
                    patient.setCramps(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you been experiencing abdominal cramps?\n1. No\n2. A few\n3. A lot(can't stand)");
                    sendMessage(message);
                    return;
                }
            } //->
            message.setText("Have you been experiencing constipation?(yes/no)");
            sendMessage(message);
        } else if (patient.isConstipation() == null) {
            // For  some reason doesn't catch errors
            switch (answer) {
                case "yes":
                case "y":
                    patient.setConstipation(true);
                    break;
                case "no":
                case "n":
                    patient.setConstipation(false);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nDo you suffer Constipation?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you been experiencing an increase in pee frequency?\n 1.No\n 2. few\n 3. A lot (can't stand)");
            sendMessage(message);
        } else if (patient.getPee() == null) {
            switch (answer) {
                case "1":
                    patient.setPee(0);
                    break;
                case "2":
                    patient.setPee(1);
                    break;
                case "3":
                    patient.setPee(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you been experiencing an increase in pee frequency?\n1. No\n2. few \n3. A lot(can't stand)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you have a bulk(s)?(yes/no)");
            sendMessage(message);
        } else if (patient.isBulks() == null) {
            switch (answer) {
                case "yes":
                case "y":
                    patient.setBulks(true);
                    break;
                case "no":
                case "n":
                    patient.setBulks(false);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nDo you have Bulk(s)?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you been experiencing fever lately?\n1. 37.5º or lower\n2. Between 37.5 and 39º\n3. Higher than 39º");
            sendMessage(message);
        } else if (patient.getFever() == null) {
            switch (answer) {
                case "1":
                    patient.setFever(0);
                    break;
                case "2":
                    patient.setFever(1);
                    break;
                case "3":
                    patient.setFever(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you been experiencing fever lately?\n1. 37.5º or lower\n2. Between 37.5 and 39º\n3. Higher than 39º");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you experienced perianal discomfort?\n1. No\n2. Mildly\n3. Absolutely");
            sendMessage(message);
        } else if (patient.getPerianalDiscom() == null) {
            switch (answer) {
                case "1":
                    patient.setPerianalDiscom(0);
                    break;
                case "2":
                    patient.setPerianalDiscom(1);
                    break;
                case "3":
                    patient.setPerianalDiscom(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you experienced perianal discomfort?\n1. No\n2. Mildly\n3. Absolutely");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you have ulcers?(yes/no)");
            sendMessage(message);
        } else if (patient.isUlcers() == null) {
            switch (answer) {
                case "yes":
                case "y":
                    patient.setUlcers(true);
                    break;
                case "no":
                case "n":
                    patient.setUlcers(false);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nDo you have Ulcers?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you suffer from blood in your feces?\n1. No\n2. Mildly\n3. Absolutely");
            sendMessage(message);
        } else if (patient.isMelenas() == null) {
            switch (answer) {
                case "1":
                    patient.setMelenas(0F);
                    break;
                case "2":
                    patient.setMelenas(1F);
                    break;
                case "3":
                    patient.setMelenas(2F);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nDo you suffer from blood in your feces?\n1. No\n2. Mildly\n3. Absolutely");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you experienced chills?\n1. No\n2. Sporadic\n3. Frequent");
            sendMessage(message);
        } else if (patient.isChills() == null) {
            switch (answer) {
                case "1":
                    patient.setChills(0F);
                    break;
                case "2":
                    patient.setChills(1F);
                    break;
                case "3":
                    patient.setChills(2F);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you experienced chills?\n1. No\n2. Sporadic\n3. Frequent");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you experienced constant fatigue?\n1. No\n2. Sporadic\n3. Frequent");
            sendMessage(message);
        } else if (patient.getFatigue() == null) {
            switch (answer) {
                case "1":
                    patient.setFatigue(0);
                    break;
                case "2":
                    patient.setFatigue(1);
                    break;
                case "3":
                    patient.setFatigue(2);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you experienced constant fatigue?\n1. No\n2. Sporadic\n3. Frequent");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you experienced a constant need to defecate?\n1. No\n2. Mildly\n3. Absolutely");
            sendMessage(message);
        } else if (patient.isPoo() == null) {
            switch (answer) {
                case "1":
                    patient.setPoo(0F);
                    break;
                case "2":
                    patient.setPoo(1F);
                    break;
                case "3":
                    patient.setPoo(2F);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you experienced a constant need to defecate?\n1. No\n2. Mildly\n3. Absolutely");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you suffered from dermatitis lately?\n1. No\n2. Focalized\n3. Extended");
            sendMessage(message);
        } else if (patient.isDermatitis() == null) {
            switch (answer) {
                case "1":
                    patient.setDermatitis(0F);
                    break;
                case "2":
                    patient.setDermatitis(1F);
                    break;
                case "3":
                    patient.setDermatitis(2F);
                    break;
                default: {
                    message.setText("Sorry, I couldn't understand you.\nHave you suffered from dermatitis lately?\n1. No\n2. Focalized\n3. Extended");
                    sendMessage(message);
                    return;
                }
            }

            message.setText(calculatePorcentageFromSymptoms(patient));
            sendMessage(message);
            //TODO: get a diagnosis.
            
        }
    }
    
    
        public String calculatePorcentageFromSymptoms(Patient patient){
            
        String diagnosisPorcentage="";
        ibs.patientSynmptomsToArrayList();
        chron.patientSynmptomsToArrayList();
        ulcerative_colitis.patientSynmptomsToArrayList();
        diverticulosis.patientSynmptomsToArrayList();
        hernia.patientSynmptomsToArrayList();
        appendicitis.patientSynmptomsToArrayList();
        enterocolitis.patientSynmptomsToArrayList();
        celiac_Disease.patientSynmptomsToArrayList();
        colorectal_cancer.patientSynmptomsToArrayList();
        
        ibsPorcentage = patient.ComparationArrayListSymptoms(ibs.getDiseaseArrayList());
        chronPorcentage = patient.ComparationArrayListSymptoms(chron.getDiseaseArrayList());
        ulcerativeColitisPorcentage = patient.ComparationArrayListSymptoms(ulcerative_colitis.getDiseaseArrayList());
        diverticulosisPorcentage = patient.ComparationArrayListSymptoms(diverticulosis.getDiseaseArrayList());
        herniaPorcentage = patient.ComparationArrayListSymptoms(hernia.getDiseaseArrayList());
        appendicitisPorcentage = patient.ComparationArrayListSymptoms(appendicitis.getDiseaseArrayList());
        enterocolitisPorcentage=patient.ComparationArrayListSymptoms(enterocolitis.getDiseaseArrayList());
        celiacPorcentage=patient.ComparationArrayListSymptoms(celiac_Disease.getDiseaseArrayList());
        colorectalCancerPorcentage=patient.ComparationArrayListSymptoms(colorectal_cancer.getDiseaseArrayList());
        
        diagnosisPorcentage="\nYour diagnosis is: "
                + "\n-> Ibs:"+ibsPorcentage+" %"
                + "\n-> Chron: "+chronPorcentage+" %"
                + "\n-> Ulcerative Colitis: "+ulcerativeColitisPorcentage+" %"
                + "\n-> Diverticulosis: "+diverticulosisPorcentage+" %"
                + "\n-> Hernia: "+herniaPorcentage+" %"
                + "\n-> Appendicitis: "+appendicitisPorcentage+" %"
                + "\n-> Enterocolitis: "+enterocolitisPorcentage+" %"
                + "\n-> Celiac Disease: "+celiacPorcentage+" %"
                + "\n-> Colorectal Cancer: "+colorectalCancerPorcentage+" %"
                + "";
        
        return diagnosisPorcentage;
        
        
    }
    

    private boolean deleteLastAnswer(int sessionPos, boolean sendMessage) {
        Patient patient = patients.get(sessionPos);
        SendMessage message = new SendMessage();
        message.setChatId(sessions.get(sessionPos));

        if (patient.getGender() == null) {
            message.setText("I can't go any further back\n\nWere you born male(m) or female(f)?");
            sendMessage(message);
            return false;
        } else if (patient.getAge() == null) {
            message.setText("Were you born male(m) or female(f)?");
            patient.setGender(null);
        } else if (patient.getAbdpain() == null) {
            message.setText("What is your age?");
            patient.setAge(null);
        } else if (patient.getDistention() == null) {
            message.setText("How would you rate your abdominal pain?\n1. None\n2. Mild\n3. Severe");
            patient.setAbdpain(null);
        } else if (patient.getNausea() == null) {
            message.setText("Do you suffer abdominal distention (inflated belly)?\n1. No\n2. Low\n3. High");
            patient.setDistention(null);
        } else if (patient.getVomiting() == null) {
            message.setText("Do you suffer nausea?\n1. No\n2. Sporadically\n3. Frequently");
            patient.setNausea(null);
        } else if (patient.isAnxiety() == null) {
            message.setText("Have you experience vomiting lately?\n1. No\n2. Sporadically\n3. Frequently");
            patient.setVomiting(null);
        } else if (patient.isGenetic() == null) {
            message.setText("Have you felt unusually anxious or depressed lately?(yes/no)");
            patient.setAnxiety(null);
        } else if (patient.isTobacco() == null) {
            message.setText("Do you have any antecedents of intestinal diseases in your close family?(yes/no)");
            patient.setGenetic(null);
        } else if (patient.isDiarrhea() == null) {
            message.setText("Do you smoke?(yes/no)");
            patient.setTobacco(null);
        } else if (patient.getRectalHemo() == null) {
            message.setText("Do you suffer Diarrhea?(yes/no)");
            patient.setDiarrhea(null);
        } else if (patient.getExhaustion() == null) {
            message.setText("Have you suffered discomfort around the anus?\n1. None\n2. Focalized\n3. Extended");
            patient.setRectalHemo(null);
        } else if (patient.getWeightLoss() == null) {
            message.setText("Have you felt exhausted?\n1. No\n2. Mildly\n3. Absolutely");
            patient.setExhaustion(null);
        } else if (patient.getCramps() == null) {
            message.setText("Have you lost weight lately?\n1. No\n2. Very little(0-5%)\n3. A lot(>5%)");
            patient.setWeightLoss(null);
        } else if (patient.isConstipation() == null) {
            message.setText("Have you been experiencing abdominal cramps?\n1. No\n2. A few\n3. A lot(can't stand)");
            patient.setCramps(null);
        } else if (patient.getPee() == null) {
            message.setText("Do you suffer Constipation?(yes/no)");
            patient.setConstipation(null);
        } else if (patient.isBulks() == null) {
            message.setText("Have you been experiencing an increase in pee frequency?\n1. No\n2. few \n3. A lot(can't stand)");
            patient.setPee(null);
        } else if (patient.getFever() == null) {
            message.setText("Do you have Bulk(s)?(yes/no)");
            patient.setBulks(null);
        } else if (patient.getPerianalDiscom() == null) {
            message.setText("Have you been experiencing fever lately?\n1. 37.5º or lower\n2. Between 37.5 and 39º\n3. Higher than 39º");
            patient.setFever(null);
        } else if (patient.isUlcers() == null) {
            message.setText("Have you experienced perianal discomfort?\n1. No\n2. Mildly\n3. Absolutely");
            patient.setPerianalDiscom(null);
        } else if (patient.isMelenas() == null) {
            message.setText("Do you have Ulcers?(yes/no)");
            patient.setUlcers(null);
        } else if (patient.isChills() == null) {
            message.setText("Do you suffer from blood in your feces?\n1. No\n2. Mildly\n3. Absolutely");
            patient.setMelenas(null);
        } else if (patient.getFatigue() == null) {
            message.setText("Have you experienced chills?\n1. No\n2. Sporadic\n3. Frequent");
            patient.setChills(null);
        } else if (patient.isPoo() == null) {
            message.setText("Have you experienced constant fatigue?\n1. No\n2. Sporadic\n3. Frequent");
            patient.setFatigue(null);
        } else if (patient.isDermatitis() == null) {
            message.setText("Have you experienced a constant need to defecate?\n1. No\n2. Mildly\n3. Absolutely");
            patient.setPoo(null);
        }

        if ( sendMessage ) sendMessage(message);
        return true;
    }

}
