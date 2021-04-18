package com.github.VladimirMaSTeR.TelegaBot.telegramBot.command;

import com.github.VladimirMaSTeR.TelegaBot.telegramBot.service.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class UnknownCommand implements Command {
    private final static String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F, " +
            "напишите /help чтобы узнать что я понимаю.";

    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
