package me.whiteship.chapter01.item13;

public class SubItem extends Item implements Cloneable {

    private String name;

    // 구체적인 타입은 상위 타입으로 변할 수 있지만
    // 상위 타입은 구체적 타입으로 변환되지 못함
    @Override
    public SubItem clone() {
        return (SubItem) super.clone();
    }

    public static void main(String[] args) {
        SubItem item = new SubItem();
        SubItem clone = (SubItem) item.clone();

        System.out.println(clone != null);
        System.out.println(clone.getClass() == item.getClass());
    }
}