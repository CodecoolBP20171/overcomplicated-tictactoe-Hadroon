package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;

@Controller
@SessionAttributes({"player", "game"})
public class GameController {

    public final String oMark = "<i class=\"fa fa-circle-o\" aria-hidden=\"true\"></i>";
    public final String xMark = "<i class=\"fa fa-times\" aria-hidden=\"true\"></i>";

    String xoState = xMark;

    @Autowired
    StateController stateController;

    @Autowired
    ApiController apiController;

    @ModelAttribute("player")
    public Player getPlayer() {
        return new Player();
    }

    @ModelAttribute("game")
    public TictactoeGame getGame() {
        return new TictactoeGame();
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() {
        return "https://robohash.org/codecool";
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) throws Exception {
//        JSONObject jsonObject = apiController.sendGet("https://api.chucknorris.io/jokes/random");
//        String name = (String) jsonObject.get("value");
//        System.out.println(name);
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(
            @ModelAttribute("player") Player player,
            Model model,
            @ModelAttribute("msg") String msg) throws Exception {
        
        JSONObject chuckJson = apiController.sendGet("https://api.chucknorris.io/jokes/random");
        model.addAttribute("funfact", (String) chuckJson.get("value"));

        Random rand = new Random();
        int  randomNumber = rand.nextInt(1900) + 1;
        JSONObject comicJson = apiController.sendGet("https://xkcd.com/" + randomNumber + "/info.0.json");
        model.addAttribute("comic_uri", (String) comicJson.get("img"));

        model.addAttribute("board", stateController.getGameStateArray());
        model.addAttribute("msg", msg);
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) throws Exception {
        String title = stateController.getGameStateArray().get(move);
        if (title == oMark || title == xMark) {
            return "redirect:/game?msg=Wrong move!";
        }
        stateController.getGameStateArray().set(move, xoState);
        if (stateController.checkWin()) {
            String winner;
            if (xoState == xMark) {
                winner = "X";
            } else {
                winner = "O";
            }
            return "redirect:/game?msg=" + winner + " Won!";
        }

//        JSONObject jsonObject = apiController.sendGet("http://tttapi.herokuapp.com/api/v1/-O-----X-/O");
//        String name = (String) jsonObject.get("recommendation");
//        System.out.println(name);

        if (xoState == oMark) {
            xoState = xMark;
        } else {
            xoState = oMark;
        }
        return "redirect:/game";
    }
}
