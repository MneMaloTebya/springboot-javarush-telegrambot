package com.github.mnemalotebya.jrtb.command;

import com.github.mnemalotebya.jrtb.comand.Command;
import com.github.mnemalotebya.jrtb.comand.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.mnemalotebya.jrtb.comand.CommandName.START;
import static com.github.mnemalotebya.jrtb.comand.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}