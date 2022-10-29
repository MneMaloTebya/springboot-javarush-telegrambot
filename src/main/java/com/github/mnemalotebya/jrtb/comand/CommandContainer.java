package com.github.mnemalotebya.jrtb.comand;

import com.github.mnemalotebya.jrtb.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.github.mnemalotebya.jrtb.comand.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendBotMessageService);
    }
    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
