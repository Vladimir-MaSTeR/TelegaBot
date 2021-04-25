package com.github.VladimirMaSTeR.TelegaBot.telegramBot.command;

import com.github.VladimirMaSTeR.TelegaBot.telegramBot.bot.TbBot;
import com.github.VladimirMaSTeR.TelegaBot.telegramBot.service.SendBotMessageService;
import com.github.VladimirMaSTeR.TelegaBot.telegramBot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstractCommandTest {
    protected TbBot tbBot = Mockito.mock(TbBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(tbBot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatId = 434234324L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(tbBot).execute(sendMessage);
    }
}
