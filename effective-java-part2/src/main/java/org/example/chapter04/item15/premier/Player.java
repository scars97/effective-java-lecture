package org.example.chapter04.item15.premier;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class Player {

    private String name; // 선수명
    private int score; // 득점

    @Override
    public String toString() {
        return "선수: " + this.name +
               ", 득점: " + this.score;
    }
}
