package me.whiteship.chapter01.item02;

public class TelescopingConstructor {

    private final int servingSize;  // (mL, 1회 제공량)     필수
    private final int servings;     // (회, 총 n회 제공량)  필수
    private final int calories;     // (1회 제공량당)       선택
    private final int fat;          // (g/1회 제공량)       선택
    private final int sodium;       // (mg/1회 제공량)      선택
    private final int carbohydrate; // (g/1회 제공량)       선택

    // 생성자 체이닝
    public TelescopingConstructor(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public TelescopingConstructor(int servingSize, int servings,
                                  int calories) {
        this(servingSize, servings, calories, 0);
    }

    public TelescopingConstructor(int servingSize, int servings,
                                  int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public TelescopingConstructor(int servingSize, int servings,
                                  int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public TelescopingConstructor(int servingSize, int servings,
                                  int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize  = servingSize;
        this.servings     = servings;
        this.calories     = calories;
        this.fat          = fat;
        this.sodium       = sodium;
        this.carbohydrate = carbohydrate;
    }

    // 어떤 인수를 줘야할 지 명확하지 않음
    public static void main(String[] args) {
        TelescopingConstructor cocaCola =
                new TelescopingConstructor(10, 10);
    }
}
