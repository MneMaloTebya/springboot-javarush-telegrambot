package com.github.mnemalotebya.jrtb.command;

import com.github.mnemalotebya.jrtb.comand.Command;
import com.github.mnemalotebya.jrtb.comand.StopCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.mnemalotebya.jrtb.comand.CommandName.STOP;
import static com.github.mnemalotebya.jrtb.comand.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}
