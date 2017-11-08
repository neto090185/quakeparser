package br.game;

import br.game.entity.Game;
import br.game.parser.QuakeParser;
import com.google.gson.Gson;

import java.io.InputStream;

import  java.lang.ClassLoader;
import java.util.Map;

import static spark.Spark.get;

public class Application {

    public static void main(String[] args){
        InputStream gamesInputStream = ClassLoader.getSystemResourceAsStream("games.log");
        final Map<String, Game> gameMap = new QuakeParser().parser(gamesInputStream);
        Gson gson = new Gson();

        get("/", (req, res) -> gameMap, gson::toJson);

        get("/:game", (req, res) -> gameMap.get(req.params(":game")), gson::toJson);
    }
}
