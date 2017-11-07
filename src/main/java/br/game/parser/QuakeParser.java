package br.game.parser;

import br.game.entity.Game;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuakeParser {

    public Map<String, Game> parser(InputStream inputStream) {
        Map<String, Game> games = new HashMap<>();
        Scanner scanner = new Scanner(inputStream);

        Game game = null;
        int count = 1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            switch (extractAction(line)) {
                case "InitGame":
                    System.out.println("init game");
                    game = new Game();
                    break;
                case "Kill":
                    game.addKill();
                    break;
                case "ClientUserinfoChanged":

                    break;
                case "ShutdownGame":
                    System.out.println("game_" + count++  + "  " + game.getTotalKills());
                    break;
            }
        }
        return games;
    }

    public String extractAction(String line) {
        int second = line.indexOf(":", 7);
        if (second > 0) {
            int first = line.indexOf(":");
            return line.substring(first + 4, second);
        }
        return "INVALID";
    }
}
