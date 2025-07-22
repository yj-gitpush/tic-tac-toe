package com.lld.tictactoe.enums;

public enum GameState {
    NOT_STARTED("NOT_STARTED"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED");

    private String name;
    GameState(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
