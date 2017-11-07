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
                    game = new Game();
                    break;
                case "Kill":
                    game.addKill();
                    break;
                case "ClientUserinfoChanged":
                    game.addPlayer(extractPlayer(line));
                    break;
                case "ShutdownGame":
                    System.out.println("game_" + count++ + "  " + game.getTotalKills() + "  " + game.getPlayers());
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

    public String extractPlayer(String line) {
        return line.substring(line.indexOf(" n\\")+3, line.indexOf("\\t\\"));
    }
}
