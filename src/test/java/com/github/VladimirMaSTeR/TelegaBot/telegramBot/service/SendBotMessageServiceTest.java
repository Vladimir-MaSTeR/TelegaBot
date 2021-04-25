package com.github.VladimirMaSTeR.TelegaBot.telegramBot.service;


import com.github.VladimirMaSTeR.TelegaBot.telegramBot.bot.TbBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private TbBot tbBot;

    @BeforeEach
    public void init() {
        tbBot = Mockito.mock(TbBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(tbBot);
    }


    @Test
    public void properlySendMessage() throws TelegramApiException {
        String testChatId = "test_chat_id";
        String testMessage = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(testMessage);
        sendMessage.setChatId(testChatId);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(testChatId, testMessage);

        Mockito.verify(tbBot).execute(sendMessage);
    }
}