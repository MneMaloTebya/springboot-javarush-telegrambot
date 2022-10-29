package com.github.mnemalotebya.jrtb.service;

import com.github.mnemalotebya.jrtb.bot.JavaRushTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final JavaRushTelegramBot javaRushBot;

    @Autowired
    public SendBotMessageServiceImpl(JavaRushTelegramBot javaRushBot) {
        this.javaRushBot = javaRushBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            javaRushBot.execute(sendMessage);
            // TODO: 29.10.2022 add logging to the project
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
