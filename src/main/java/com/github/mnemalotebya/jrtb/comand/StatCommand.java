package com.github.mnemalotebya.jrtb.comand;

import com.github.mnemalotebya.jrtb.comand.annotation.AdminCommand;
import com.github.mnemalotebya.jrtb.service.SendBotMessageService;
import com.github.mnemalotebya.jrtb.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

@AdminCommand
public class StatCommand implements Command{

    private final TelegramUserService telegramUserService;
    private final SendBotMessageService sendBotMessageService;
    public final static String STAT_MESSAGE = "Javarush Telegram Bot использует %s user(s).";

    @Autowired
    public StatCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        int activeUserCount = telegramUserService.findAllActiveUsers().size();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), String.format(STAT_MESSAGE, activeUserCount));
    }
}
