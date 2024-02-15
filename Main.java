
public class Main {
    public static void main(String[] args) {
        Shop market = new Shop();
        Human human_1 = new Human("Иван");
        Human human_2 = new Human("Петр");
        Human human_3 = new Human("Василий");
//        Human human_4 = new Human("Сергей");
        market.accertToMarket(human_1);
        market.accertToMarket(human_2);
        market.accertToMarket(human_3);
//        market.accertToMarket(human_4);

        market.update();
    }
}