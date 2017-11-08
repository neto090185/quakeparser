package br.game.parser;

import br.game.entity.Game;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuakeParser {
    private final Pattern actionPattern = Pattern.compile("\\s*\\d{1,2}:\\d{2}\\s*(\\w+):\\w*");
    private final Pattern playerPattern = Pattern.compile("n\\\\(.*?)\\\\t\\\\");


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
        Matcher matcher = actionPattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "INVALID";
    }

    public String extractPlayer(String line) {
        Matcher matcher = playerPattern.matcher(line);
        return matcher.find() ? matcher.group(1) : null;
    }
}
