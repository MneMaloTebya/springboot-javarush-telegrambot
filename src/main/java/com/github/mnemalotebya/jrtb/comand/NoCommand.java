package com.github.mnemalotebya.jrtb.comand;

import com.github.mnemalotebya.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final static String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\\n\"\n" +
            "           + \"Чтобы посмотреть список команд введите /help";


    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
