package kg.akoikelov.springmvcapp.bot;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotCommand {
    String getName();
    void execute(Update update);
}
