package me.whiteship.chapter01.item01;

import java.util.ArrayList;
import java.util.List;

/**
 * 이 클래스의 인스턴스를 #getInstance()를 통해 사용한다.
 * @see #getInstance()
 */
public class Settings {

    private boolean useAutoSteering;

    private boolean useABS;

    private Difficulty difficulty;

    // 인스턴스 생성을 통제하고 싶다면 private 선언
    // 정적 팩토리 메서드 제공
    // 객체 생성을 스스로 통제 -> 외부에서 Settings 객체 생성 못함
    // 오직 팩토리 메서드로만 객체 생성.
    private Settings() {}

    private static final Settings SETTINGS = new Settings();

    public static Settings getInstance() {
        return SETTINGS;
    }

}
