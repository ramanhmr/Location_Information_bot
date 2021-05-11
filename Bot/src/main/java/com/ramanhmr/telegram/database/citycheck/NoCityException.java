package com.ramanhmr.telegram.database.citycheck;

public class NoCityException extends Exception {
    public NoCityException() {
        super("There is no such city in database.");
    }
}
