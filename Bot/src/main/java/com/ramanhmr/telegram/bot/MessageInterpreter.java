package com.ramanhmr.telegram.bot;

import com.ramanhmr.telegram.database.datatypes.TypesOfData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MessageInterpreter {
    private static final String TRIM_BEGGINING = "\\A[^а-яА-Я0-9]*";
    private static final String TRIM_END = "[^а-яА-Я0-9]*\\Z";
    private static final String WORDS_SEPARATOR = "[^а-яА-Я0-9]*,[^а-яА-Я0-9]*";

    static List<String> interpretMessage(String message) {
        String msg = message.replaceAll(TRIM_BEGGINING, "")
                .replaceAll(TRIM_END, "");
        return new ArrayList<String>(Arrays.asList(msg.split(WORDS_SEPARATOR)));
    }

    static TypesOfData getDataType(String string) {
        if (string.equalsIgnoreCase("население")) {
            return TypesOfData.POPULATION;
        } else if (string.equalsIgnoreCase("страна")) {
            return TypesOfData.COUNTRY;
        }
        return null;
    }
}
