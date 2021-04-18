package com.github.VladimirMaSTeR.TelegaBot.telegramBot.service;

import com.github.VladimirMaSTeR.TelegaBot.telegramBot.bot.TbBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final TbBot tbBot;

    @Autowired
    public SendBotMessageServiceImpl(TbBot tbBot) {
        this.tbBot = tbBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            tbBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logging to the project.
            e.printStackTrace();
        }
    }
}
