package com.github.mnemalotebya.jrtb.comand;

import com.github.mnemalotebya.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    private final static String START_MESSAGE = "Привет! (Отдельный привет Ане <3). Я JavaRush Telegram Bot. Я нахажусь еще только в разработке!";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
