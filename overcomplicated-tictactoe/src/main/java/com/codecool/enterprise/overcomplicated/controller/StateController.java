package com.codecool.enterprise.overcomplicated.controller;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class StateController {

    public final String oMark = "<i class=\"fa fa-circle-o\" aria-hidden=\"true\"></i>";
    public final String xMark = "<i class=\"fa fa-times\" aria-hidden=\"true\"></i>";

    public String gameStateString;

    public ArrayList<String> gameStateArray = new ArrayList();

    public StateController() {
        this.gameStateString = "";
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

    public String stateToString() {
        gameStateString = "";
        for (int i=0; i<=8; i++ ) {
            if (gameStateArray.get(i) == "") {
                gameStateString += "-";
            } else if (gameStateArray.get(i) == xMark) {
                gameStateString += "X";
            } else if (gameStateArray.get(i) == oMark) {
                gameStateString += "O";
            }
        }
        return gameStateString;
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
