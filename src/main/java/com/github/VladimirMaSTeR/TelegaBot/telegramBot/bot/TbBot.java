package com.github.VladimirMaSTeR.TelegaBot.telegramBot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TbBot extends TelegramLongPollingBot {

    @Value("${bot.userName}")
    private String userName;

    @Value("${bot.token}")
    private String token;


    /*
    это и есть точка входа,
    куда будут поступать сообщения от пользователей.
    Отсюда будет идти вся новая логика;
     */
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText(message);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                //todo add logging to the project.
                e.printStackTrace();
            }
        }
    }

    /*
    здесь нужно добавить username нашего бота,
    к которому будем соединяться;
     */
    @Override
    public String getBotUsername() {
        return userName;
    }

    /*
    а это, соответственно, токен бота.
     */
    @Override
    public String getBotToken() {
        return token;
    }

}
