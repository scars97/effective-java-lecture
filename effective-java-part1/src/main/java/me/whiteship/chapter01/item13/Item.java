package me.whiteship.chapter01.item13;

public class Item implements Cloneable{

    private String name;

    @Override
    public Item clone() {
//        Item item = new Item();
//        item.name = this.name;
//        return item;
        Item result = null;
        try {
            result = (Item) super.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
