package br.game.entity;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//    game_1: {
//            total_kills: 45;
//            players: ["Dono da bola", "Isgalamido", "Zeh"]
//            kills: {
//            "Dono da bola": 5,
//            "Isgalamido": 18,
//            "Zeh": 20
//            }
//            }
public class Game {

    private Integer totalKills;
    private Set<String> players;
    private Map<String,Integer> kills;

    public Game() {
        totalKills = 0;
        players = new HashSet<>();
        kills = new HashMap<>();
    }

    public Integer getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(Integer totalKills) {
        this.totalKills = totalKills;
    }

    public Set<String> getPlayers() {
        return players;
    }

    public void setPlayers(Set<String> players) {
        this.players = players;
    }

    public Map<String, Integer> getKills() {
        return kills;
    }

    public void setKills(Map<String, Integer> kills) {
        this.kills = kills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (totalKills != null ? !totalKills.equals(game.totalKills) : game.totalKills != null) return false;
        if (players != null ? !players.equals(game.players) : game.players != null) return false;
        return kills != null ? kills.equals(game.kills) : game.kills == null;
    }

    @Override
    public int hashCode() {
        int result = totalKills != null ? totalKills.hashCode() : 0;
        result = 31 * result + (players != null ? players.hashCode() : 0);
        result = 31 * result + (kills != null ? kills.hashCode() : 0);
        return result;
    }
}
