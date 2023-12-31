package org.example.chapter04.item15.premier;

import java.util.List;

public class PremierLeagueApp {

    // 의존성 주입
    /*private PremierLeagueService epl;

    public PremierLeagueApp() {
        this.epl = new PremierLeagueServiceImp();
    }

    public PremierLeagueService getEpl() {
        return epl;
    }*/

    public static void main(String[] args) {
        PremierLeagueService leagueService = new PremierLeagueServiceImp();

        List<Player> players = leagueService.players();

        for (Player player : players) {
            System.out.println(player);
        }
    }
}
