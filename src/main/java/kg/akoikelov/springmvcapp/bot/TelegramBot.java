package kg.akoikelov.springmvcapp.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "aibek_fastcreditbot";
    }

    @Override
    public String getBotToken() {
        return "1641101949:AAEyUK4_1XPCHatzD2RFNs60wfQ_hJju_aY";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.getMessage().getText().equals("/start")){
            System.out.println("Start");
            System.out.println(update.getMessage().getChatId());
        }

    }
}
