package org.example.chapter04.item15.league;

import org.example.chapter04.item15.premier.PremierLeagueService;

public class LeagueService {

    PremierLeagueService leagueService;

    public LeagueService(PremierLeagueService leagueService) {
        this.leagueService = leagueService;
    }
}
