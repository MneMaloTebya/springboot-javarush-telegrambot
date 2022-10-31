package com.github.mnemalotebya.jrtb.comand;

import com.github.mnemalotebya.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.mnemalotebya.jrtb.comand.CommandName.STAT;
import static java.lang.String.format;

public class AdminHelpCommand implements Command {

    public static final String ADMIN_HELP_MESSAGE = format("✨<b>Доступные команды админа</b>✨\n\n"
                    + "<b>Получить статистику</b>\n"
                    + "%s - статистика бота\n",
            STAT.getCommandName());

    private final SendBotMessageService sendBotMessageService;

    public AdminHelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), ADMIN_HELP_MESSAGE);
    }
}
