package telegram;

import dss_abdominal.Patient;
import org.checkerframework.checker.units.qual.A;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
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

    protected static final long TIMEOUT = 3600000; // in ms

    public Telegrambot( String token ){
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


    @Override
    public String getBotUsername() {
        return "Abdominal Pain DSS";
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text

        if (update.hasMessage() && update.getMessage().hasText()) {

            String chatId = update.getMessage().getChatId().toString();
            // First we check if this chat has a session:
            int pos = sessions.indexOf(chatId);
            if ( pos != -1 ) {
                processMessage(update);
            } else {
                // This is either the case they have contacted us for the first time or that they have been removed due to inactivity

                SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields

                message.setChatId(update.getMessage().getChatId().toString()); // Answer to the same chat.
                message.setText("Welcome to the DSS for Abdominal Pain. Type **/start** to start your analysis or **/help** to see a list of commands.");

                System.out.println("Adding chatId: "+chatId);
                // We add this new Client to the list of clients.
                sessions.add(chatId);
                patients.add(null);
                times.add(System.currentTimeMillis());

                sendMessage(message);

            }


        }
    }

    private void processMessage(Update update){
        // We update the last time we saw a client.
        String chatId = update.getMessage().getChatId().toString();
        int pos = sessions.indexOf(chatId);
        times.set(pos, System.currentTimeMillis());

        String message_received = update.getMessage().getText();
        if ( message_received.startsWith("/")){
            // It's a command
            processCommand(message_received, update);
        } else if ( acceptable_answers_set.contains(message_received.toLowerCase()) || askingAge) {
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

    private void processCommand(String msg, Update update){
        String command;

        String chatId = update.getMessage().getChatId().toString();
        int session_pos = sessions.indexOf(chatId);

        int pos = msg.indexOf(" ");
        if ( pos  == -1 ) {
            command = msg.substring(1, msg.length()).toLowerCase();
        } else {
            command = msg.substring(1, pos).toLowerCase();
        }

        if ( command.equals("start") ){
            // Initiate the patient and start asking questions.
            patients.set(session_pos, new Patient());
            SendMessage answer = new SendMessage();
            answer.setChatId(chatId);
            answer.setText("We are going to start asking you questions now. Please answer with the numbers at the left " +
                    "of the options. If no number is provided you can answer freely\n\nWere you born male(m) or female(f)?");

            sendMessage(answer);



        } else if ( command.equals("help") ) {
            SendMessage answer = new SendMessage();
            answer.setChatId(chatId);
            answer.setText("This is a list of the current available commands:\n/help\n/start\n/stop\n/hellothere");
            sendMessage(answer);

        } else if ( command.equals("stop")) {
            sessions.remove(session_pos);
            patients.remove(session_pos);
            times.remove(session_pos);

            SendMessage answer = new SendMessage();
            answer.setText("Goodbye!");
            answer.setChatId(chatId);
            sendMessage(answer);

        } else if ( command.equals("hellothere") ) {
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

    private void sendMessage(SendMessage m){
        try {
            execute(m); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    protected void cleanSessions(){
        for( int i = 0; i < sessions.size(); i++ ){
            if ( (System.currentTimeMillis() - times.get(i))  > TIMEOUT ){
                System.out.println("Removing chatId: "+ sessions.get(i));
                sessions.remove(i);
                patients.remove(i);
                times.remove(i);
                // As the list is shifting one down, we have to go through this position once more.
                i--;
            }
        }
    }

    private void addAnswer(int sessionPos, String answer){
        Patient patient = patients.get(sessionPos);
        SendMessage message = new SendMessage();
        message.setChatId(sessions.get(sessionPos));

        if ( patient.getGender() == null ) {
            if (answer.equals("female") || answer.equals("f") ) {
                patient.setGender(Patient.Gender.FEMALE);
            } else if ( answer.equals("male") || answer.equals("m") ) {
                patient.setGender(Patient.Gender.MALE);
            } else {
                message.setText("Sorry, I couldn't understand you.\nWere you born male(m) or female(f)?");
                sendMessage(message);
                return;
            }
            // ask for age
            askingAge=true;
            message.setText("What is your age?");
            sendMessage(message);

        } else if ( patient.getAge() == null ) {
            try{
                int age = Integer.parseInt(answer);
                if ( age < 10) {
                    patient.setAge(Patient.AgeRange.CHILD);
                } else if ( age < 14 ) {
                    patient.setAge(Patient.AgeRange.YOUNG);
                } else if ( age < 35 ){
                    patient.setAge(Patient.AgeRange.YOUNGADULT);
                } else if ( age < 115 ) {
                    patient.setAge(Patient.AgeRange.ADULT);
                } else {
                    message.setText("Sorry, I couldn't understand you.\nWhat is your age?");
                    sendMessage(message);
                    return;
                }
                // ask for abpain
                message.setText("How would you rate your abdominal pain?\n1. None\n2. Mild\n3. Severe");
                sendMessage(message);
            } catch (NumberFormatException e ){
                message.setText("Please introduce a number");
                sendMessage(message);
            }
        } else if ( patient.getAbdpain() == null ){
            switch (answer) {
                case "1" -> patient.setAbdpain(0);
                case "2" -> patient.setAbdpain(1);
                case "3" -> patient.setAbdpain(2);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nHow would you rate your abdominal pain?\n1. None\n2. Mild\n3. Severe");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you suffer abdominal distention (inflated belly)?\n1. No\n2. Low\n3. High");
            sendMessage(message);
        } else if ( patient.getDistention() == null ){
            switch (answer) {
                case "1" -> patient.setDistention(0);
                case "2" -> patient.setDistention(1);
                case "3" -> patient.setDistention(2);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nDo you suffer abdominal distention (inflated belly)?\n1. No\n2. Low\n3. High");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you suffer nausea?\n1. No\n2. Sporadically\n3. Frequently");
            sendMessage(message);
        } else if ( patient.getNausea() == null ){
            switch (answer) {
                case "1" -> patient.setNausea(0);
                case "2" -> patient.setNausea(1);
                case "3" -> patient.setNausea(2);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nDo you suffer nausea?\n1. No\n2. Sporadically\n3. Frequently");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you experience vomiting lately?\n1. No\n2. Sporadically\n3. Frequently");
            sendMessage(message);
        } else if ( patient.getVomiting() == null ){
            switch (answer) {
                case "1" -> patient.setVomiting(0);
                case "2" -> patient.setVomiting(1);
                case "3" -> patient.setVomiting(2);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nHave you experience vomiting lately?\n1. No\n2. Sporadically\n3. Frequently");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you felt unusually anxious or depressed lately?(yes/no)");
            sendMessage(message);
        } else if ( patient.isAnxiety() == null ){
            switch (answer) {
                case "yes", "y" -> patient.setAnxiety(true);
                case "no", "n" -> patient.setAnxiety(false);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nHave you felt unusually anxious or depressed lately?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you have any antecedents of intestinal diseases in your close family?(yes/no)");
            sendMessage(message);
        } else if ( patient.isGenetic() == null ){
            switch (answer) {
                case "yes", "y" -> patient.setGenetic(true);
                case "no", "n" -> patient.setGenetic(false);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nDo you have any antecedents of intestinal diseases in your close family?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you smoke?(yes/no)");
            sendMessage(message);
        } else if ( patient.isTobacco() == null ){
            switch (answer) {
                case "yes", "y" -> patient.setTobacco(true);
                case "no", "n" -> patient.setTobacco(false);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nDo you smoke?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Do you suffer Diarrhea?(yes/no)");
            sendMessage(message);
        } else if ( patient.isDiarrhea() == null ){
            switch (answer) {
                case "yes", "y" -> patient.setDiarrhea(true);
                case "no", "n" -> patient.setDiarrhea(false);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nDo you suffer Diarrhea?(yes/no)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you suffered discomfort around the anus?\n1. None\n2. Focalized\n3. Extended");
            sendMessage(message);
        } else if ( patient.getRectalHemo() == null ){
            switch (answer) {
                case "1" -> patient.setRectalHemo(0);
                case "2" -> patient.setRectalHemo(1);
                case "3" -> patient.setRectalHemo(2);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nHave you suffered discomfort around the anus?\n1. None\n2. Focalized\n3. Extended");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you felt exhausted?\n1. No\n2. Mildly\n3. Absolutely");
            sendMessage(message);
        } else if ( patient.getExhaustion() == null ){
            switch (answer) {
                case "1" -> patient.setExhaustion(0);
                case "2" -> patient.setExhaustion(1);
                case "3" -> patient.setExhaustion(2);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nHave you felt exhausted?\n1. No\n2. Mildly\n3. Absolutely");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you lost weight lately?\n1. No\n2. Very little(0-5%)\n3. A lot(>5%)");
            sendMessage(message);
        } else if ( patient.getWeightLoss() == null ){
            switch (answer) {
                case "1" -> patient.setWeightLoss(0);
                case "2" -> patient.setWeightLoss(1);
                case "3" -> patient.setWeightLoss(2);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nHave you lost weight lately?\n1. No\n2. Very little(0-5%)\n3. A lot(>5%)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you been experiencing abdominal cramps?\n1. No\n2. A few\n3. A lot(can't stand)");
            sendMessage(message);
        }  else if ( patient.getCramps() == null ){
            switch (answer) {
                case "1" -> patient.setCramps(0);
                case "2" -> patient.setCramps(1);
                case "3" -> patient.setCramps(2);
                default -> {
                    message.setText("Sorry, I couldn't understand you.\nHave you been experiencing abdominal cramps?\n1. No\n2. A few\n3. A lot(can't stand)");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Have you been experiencing constipation?(yes/no)");
            sendMessage(message);
        }
    }


}
