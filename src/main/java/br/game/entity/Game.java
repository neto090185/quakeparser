package br.game.entity;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Game {

    private Integer totalKills;
    private Set<String> players;
    private Map<String,Integer> kills;

    public Game() {
        totalKills = 0;
        players = new HashSet<>();
        kills = new HashMap<>();
    }

    public void addTotalKill(){
        totalKills++;
    }

    public boolean addPlayer(String player){
        return players.add(player);
    }



    public Integer getTotalKills() {
        return totalKills;
    }

    public Set<String> getPlayers() {
        return players;
    }

    public Map<String, Integer> getKills() {
        return kills;
    }

    @Override
    public String toString() {
        return "{" +
                "totalKills=" + totalKills +
                ", players=" + players +
                ", kills=" + kills +
                '}';
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

    public void subKill(String player) {
        kills.merge(player,1,Integer::sum);
    }

    public void addKill(String player) {
        kills.merge(player,-1,Integer::sum);
    }
}
