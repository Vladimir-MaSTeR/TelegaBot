package com.github.VladimirMaSTeR.TelegaBot.telegramBot.command;

import com.github.VladimirMaSTeR.TelegaBot.telegramBot.service.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class NoCommand implements Command {
    protected final static String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\n " +
            "Чтобы посмотреть список команд введите /help";

    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
