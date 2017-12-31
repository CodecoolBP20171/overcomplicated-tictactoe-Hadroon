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

    public boolean checkWin () {
        if (
            gameStateArray.get(0) == gameStateArray.get(1) && gameStateArray.get(0) == gameStateArray.get(2) && gameStateArray.get(0) != "" ||
            gameStateArray.get(3) == gameStateArray.get(4) && gameStateArray.get(3) == gameStateArray.get(5) && gameStateArray.get(3) != "" ||
            gameStateArray.get(6) == gameStateArray.get(7) && gameStateArray.get(6) == gameStateArray.get(8) && gameStateArray.get(6) != "" ||
            gameStateArray.get(0) == gameStateArray.get(3) && gameStateArray.get(0) == gameStateArray.get(6) && gameStateArray.get(0) != "" ||
            gameStateArray.get(1) == gameStateArray.get(4) && gameStateArray.get(1) == gameStateArray.get(7) && gameStateArray.get(1) != "" ||
            gameStateArray.get(2) == gameStateArray.get(5) && gameStateArray.get(2) == gameStateArray.get(8) && gameStateArray.get(2) != "" ||
            gameStateArray.get(0) == gameStateArray.get(4) && gameStateArray.get(0) == gameStateArray.get(8) && gameStateArray.get(0) != "" ||
            gameStateArray.get(2) == gameStateArray.get(4) && gameStateArray.get(2) == gameStateArray.get(6) && gameStateArray.get(2) != ""
                ) {
            return true;
        }
        return false;
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
