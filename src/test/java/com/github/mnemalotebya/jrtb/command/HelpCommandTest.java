package com.github.mnemalotebya.jrtb.command;

import com.github.mnemalotebya.jrtb.comand.Command;
import com.github.mnemalotebya.jrtb.comand.HelpCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.mnemalotebya.jrtb.comand.CommandName.HELP;
import static com.github.mnemalotebya.jrtb.comand.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {


    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
