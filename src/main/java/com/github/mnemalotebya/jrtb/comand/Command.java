package com.github.mnemalotebya.jrtb.comand;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    void execute(Update update);
}
