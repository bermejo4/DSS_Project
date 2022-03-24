package telegram;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TelegramMain {

    public static void main(String[] args) {
        String token;
        try {
            File f = new File("DSS_Abdominal/src/telegram/token.txt");
            System.out.println(f.getAbsolutePath());
            Scanner scanner = new Scanner(f);
            token = scanner.nextLine();
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            Telegrambot my_bot = new Telegrambot(token);
            botsApi.registerBot(my_bot);
            while (true) {
                //System.out.println("Cleaning list");
                Thread.sleep(Telegrambot.TIMEOUT/2);
                my_bot.cleanSessions();
            }



        } catch ( TelegramApiException e) {
            e.printStackTrace();
        } catch ( FileNotFoundException e) {
            System.out.println("Please create a file under DSS_Abdominal/src/telegram/ called token.txt and introduce the token for your bot there");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
