package com.github.mnemalotebya.jrtb.bot;

import com.github.mnemalotebya.jrtb.comand.CommandContainer;
import com.github.mnemalotebya.jrtb.javarushclient.JavaRushGroupClient;
import com.github.mnemalotebya.jrtb.service.GroupSubService;
import com.github.mnemalotebya.jrtb.service.SendBotMessageServiceImpl;
import com.github.mnemalotebya.jrtb.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

import static com.github.mnemalotebya.jrtb.comand.CommandName.NO;

@Component
public class JavarushTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    @Autowired
    public JavarushTelegramBot(TelegramUserService telegramUserService, JavaRushGroupClient groupClient, GroupSubService groupSubService,
                               @Value("#{'${bot.admins}'}") List<String> admins) {
        this.commandContainer =
                new CommandContainer(new SendBotMessageServiceImpl(this),
                        telegramUserService, groupClient, groupSubService, admins);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String username = update.getMessage().getFrom().getUserName();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier, username).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName(), username).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
