package com.github.VladimirMaSTeR.TelegaBot.telegramBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {

    void execute(Update update);

}
