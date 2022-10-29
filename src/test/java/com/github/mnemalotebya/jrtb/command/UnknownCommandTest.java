package com.github.mnemalotebya.jrtb.command;

import com.github.mnemalotebya.jrtb.comand.Command;
import com.github.mnemalotebya.jrtb.comand.UnknownCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.mnemalotebya.jrtb.comand.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/fdgdfgdfgdbd";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
