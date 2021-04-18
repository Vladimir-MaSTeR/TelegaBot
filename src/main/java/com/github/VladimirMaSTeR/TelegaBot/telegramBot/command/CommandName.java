package com.github.VladimirMaSTeR.TelegaBot.telegramBot.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("/no");

    private final String commandName;
}
