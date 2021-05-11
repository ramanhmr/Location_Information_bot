package com.ramanhmr.telegram.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {

    private String botUsername = "Location_Information_bot";
    private String botToken = "1720794432:AAHCQfcCsKnYU6GLvwgpBLcg6AScogcinG4";

    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            List<String> messageWords = MessageInterpreter.interpretMessage(update.getMessage().getText());
            try {
                execute(new SendMessage(chatId, AnswerCreator.answer(messageWords)));
                execute(new SendMessage(chatId, "Если вам интересен другой город - напишите его название.\n" +
                        "Чтобы узнать о населении или стране, в которой расположен город, введите соответствующее слово через запятую после названия города (прим. \"Минск, население\")"));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
