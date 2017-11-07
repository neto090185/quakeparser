package br.game;

import br.game.parser.QuakeParser;

import java.io.InputStream;

import  java.lang.ClassLoader;

public class Application {

    public static void main(String[] args){
        InputStream gamesInputStream = ClassLoader.getSystemResourceAsStream("games.log");
        new QuakeParser().parser(gamesInputStream);
    }
}
