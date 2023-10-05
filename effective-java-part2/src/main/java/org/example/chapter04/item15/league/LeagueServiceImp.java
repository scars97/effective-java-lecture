package org.example.chapter04.item15.league;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class LeagueServiceImp implements LeagueService {

    ScoreSeq seq = new ScoreSeq();

    // 선수 리스트
    @Override
    public List<Player> players() {
        return insertPlayer();
    }

    // 득점 순위
    @Override
    public List<Player> scoreRank() {
        List<Player> players = insertPlayer();

        // sort를 사용해 득점순으로 오름차순 정렬
        players.sort(seq);

        return players;
    }

    // 정적 내부 클래스
    private static class ScoreSeq implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            // Player 객체의 득점수를 비교하여 오름차순 정렬
            return o2.getScore() - o1.getScore();
        }
    }

    private List<Player> insertPlayer() {
        return Arrays.asList(
                Player.builder().name("Hwang").score(4).build(),
                Player.builder().name("Son").score(6).build(),
                Player.builder().name("J.Bowen").score(5).build(),
                Player.builder().name("A.Isak").score(4).build(),
                Player.builder().name("E.Haaland").score(8).build()
        );
    }
}
