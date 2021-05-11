package com.ramanhmr.telegram.database.datatypes;

import lombok.Getter;

@Getter
public enum TypesOfData {
    POPULATION("население", "population"),
    COUNTRY("страна", "country");

    private final String call;
    private final String dbCall;

    TypesOfData(String call, String dbCall) {
        this.call = call;
        this.dbCall = dbCall;
    }
}
