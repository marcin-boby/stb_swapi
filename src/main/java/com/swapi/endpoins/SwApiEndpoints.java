package com.swapi.endpoins;

public enum SwApiEndpoints {
    PEOPLE("people"),
    PLANETS("planets"),
    FILMS ("films"),
    SPECIES ("species"),
    VEHICLES ("vehicles"),
    STARSHIPS ("starships");

    final String value;

    SwApiEndpoints(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
