package org.example.chapter04.item15.league;

import org.example.chapter04.item15.premier.Player;
import org.example.chapter04.item15.premier.PremierLeagueService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LeagueServiceTest {

    @Mock
    PremierLeagueService leagueService;

    @Test
    void eplService() {
        LeagueService epl = new LeagueService(leagueService);
        List<Player> players = epl.leagueService.players();
        Assertions.assertEquals(0, players.size());
    }

}