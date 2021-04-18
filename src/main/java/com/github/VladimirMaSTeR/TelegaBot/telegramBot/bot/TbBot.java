package com.github.VladimirMaSTeR.TelegaBot.telegramBot.bot;

import com.github.VladimirMaSTeR.TelegaBot.telegramBot.command.CommandContainer;
import com.github.VladimirMaSTeR.TelegaBot.telegramBot.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.github.VladimirMaSTeR.TelegaBot.telegramBot.command.CommandName.NO;

@Component
public class TbBot extends TelegramLongPollingBot {
    public static String COMMAND_PREFIX = "/";

    @Value("${bot.userName}")
    private String userName;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    public TbBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }



    /*
    это и есть точка входа,
    куда будут поступать сообщения от пользователей.
    Отсюда будет идти вся новая логика;
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();

            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
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
