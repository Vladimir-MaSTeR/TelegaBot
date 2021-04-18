package com.github.VladimirMaSTeR.TelegaBot.telegramBot.command;

import com.github.VladimirMaSTeR.TelegaBot.telegramBot.service.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class StartCommand implements Command {
    private final static String START_MESSAGE = "Привет. Я создан в учебных целях, мал, и только учусь. " +
                                                "Но у меня огромные планы";

    private final SendBotMessageService sendBotMessageService;


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
