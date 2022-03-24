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

    protected static final long TIMEOUT = 5000; //3600000; // in ms

    public Telegrambot( String token ){
        super();
        this.token = token;
        sessions = new ArrayList<>();
        patients = new ArrayList<>();
        times = new ArrayList<>();

        acceptable_answers_set = new HashSet<String>();
        acceptable_answers_set.add("yes");
        acceptable_answers_set.add("no");
        acceptable_answers_set.add("1");
        acceptable_answers_set.add("2");
        acceptable_answers_set.add("3");
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


        String message_received = update.getMessage().getText();
        if ( message_received.startsWith("/")){
            // It's a command
            processCommand(message_received, update);
        } else if ( acceptable_answers_set.contains(message_received.toLowerCase())) {
            // It's an acceptable answer, but we still have to check for each symptom if it makes sense.

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
            answer.setText("We are going to start asking you questions now.");
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


}
