package com.codecool.enterprise.overcomplicated.controller;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class StateController {

    public String gameStateString;

    public ArrayList<String> gameStateArray = new ArrayList();

    public StateController() {
        this.gameStateString = "---------";
        this.gameStateArray.add("");
        this.gameStateArray.add("");
        this.gameStateArray.add("");
        this.gameStateArray.add("");
        this.gameStateArray.add("");
        this.gameStateArray.add("");
        this.gameStateArray.add("");
        this.gameStateArray.add("");
        this.gameStateArray.add("");
    }

    public String getGameStateString() {
        return gameStateString;
    }

    public void setGameStateString(String gameStateString) {
        this.gameStateString = gameStateString;
    }

    public ArrayList<String> getGameStateArray() {
        return gameStateArray;
    }

    public void setGameStateArray(ArrayList<String> gameStateArray) {
        this.gameStateArray = gameStateArray;
    }
}
