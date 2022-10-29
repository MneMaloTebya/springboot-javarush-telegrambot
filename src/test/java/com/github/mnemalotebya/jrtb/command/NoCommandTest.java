package com.github.mnemalotebya.jrtb.command;

import com.github.mnemalotebya.jrtb.comand.Command;
import com.github.mnemalotebya.jrtb.comand.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.mnemalotebya.jrtb.comand.CommandName.NO;
import static com.github.mnemalotebya.jrtb.comand.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
