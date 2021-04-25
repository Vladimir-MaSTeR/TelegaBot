package com.github.VladimirMaSTeR.TelegaBot.telegramBot.command;

import com.github.VladimirMaSTeR.TelegaBot.telegramBot.service.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class StopCommand implements Command {
    protected final static String STOP_MESSAGE = "Понял, завершаю работу. \uD83D \uDE1F.";

    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
