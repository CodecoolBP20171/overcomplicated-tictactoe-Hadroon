package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        model.addAttribute("funfact", "&quot;Chuck Norris knows the last digit of pi.&quot;");
        model.addAttribute("comic_uri", "https://imgs.xkcd.com/comics/bad_code.png");
        model.addAttribute("board", stateController.getGameStateArray());
        model.addAttribute("msg", msg);

//        JSONObject jsonObject = apiController.sendGet("https://api.chucknorris.io/jokes/random");
//        String name = (String) jsonObject.get("value");
//        System.out.println(name);



        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
        String title = stateController.getGameStateArray().get(move);
        if (title == oMark || title == xMark) {
            return "redirect:/game?msg=Wrong move!";
        }
        stateController.getGameStateArray().set(move, xoState);
        if (xoState == oMark) {
            xoState = xMark;
        } else {
            xoState = oMark;
        }
        
        //System.out.println("Player moved " + move);
        return "redirect:/game";
    }
}
