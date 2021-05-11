package com.ramanhmr.telegram.bot;

import com.ramanhmr.telegram.database.citycheck.NoCityException;
import com.ramanhmr.telegram.database.dataaccess.DataAccess;
import com.ramanhmr.telegram.database.datatypes.TypesOfData;

import java.sql.SQLException;
import java.util.List;

public final class AnswerCreator {
    public static String answer(List<String> messageWords) {
        StringBuilder answer = new StringBuilder();
        StringBuilder errorAnswers = new StringBuilder();
        try {
            if (messageWords.size() == 1) {
                if (messageWords.size() == 1) {
                    try {
                        answer.append(DataAccess.get(messageWords.get(0), TypesOfData.COUNTRY));
                        answer.append("\n");
                        answer.append(DataAccess.get(messageWords.get(0), TypesOfData.POPULATION));
                    } catch (SQLException e) {
                        e.printStackTrace();
                        errorAnswers.append("\nОй, что-то пошло не так! Попробуйте снова!");
                    }
                }
            } else {
                for (int i = 1; i < messageWords.size(); i++) {
                    TypesOfData dataType = MessageInterpreter.getDataType(messageWords.get(i));
                    if (dataType == null) {
                        errorAnswers.append("Не удалось найти информацию: ").append(messageWords.get(i)).append("\n");
                    } else {
                        answer.append(DataAccess.get(messageWords.get(0), dataType));
                        answer.append("\n");
                    }
                }
            }
        } catch (NoCityException e) {
            errorAnswers.append("Упс, я не знаю о городе ").append(messageWords.get(0));
        } catch (SQLException e) {
            errorAnswers.append("Не удалось найти нужную информацию");
        }
        return answer.append(errorAnswers).toString();
    }
}
