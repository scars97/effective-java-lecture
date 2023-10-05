package org.example.chapter04.item15.league;

import java.util.List;

public class LeagueApp {

    public static void main(String[] args) {
        LeagueService leagueService = new LeagueServiceImp();

        List<Player> players = leagueService.players();

        for (Player player : players) {
            System.out.println(player);
        }
    }
}
