package kg.akoikelov.springmvcapp.bot;

import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpBot implements BotCommand{
    @Override
    public String getName() {
        return "0";
    }

    @Override
    public void execute(Update update) {

    }
}
