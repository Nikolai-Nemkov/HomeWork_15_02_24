# HomeWork_15_02_24

Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования
Реализовать класс Market и все методы, которые он обязан реализовывать.
Методы из интерфейса QueueBehaviour, имитируют работу очереди, MarketBehaviour – помещает и удаляет человека из очереди, метод update – обновляет состояние магазина (принимает и отдаёт заказы)
Формат сдачи: ссылка на гитхаб проект


## Human

 public class Human extends Buyer {
 
    public Human(String name) {
    
        super(name);
    }
    
    @Override
    public void setMakeOrder(boolean makeOrder) {
        super.makeOrder = makeOrder;
    }

    @Override
    public void setTakeOrder(boolean takeOrder) {
        super.takeOrder = takeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return makeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return takeOrder;
    }
}

## HumanBehaviour

public interface HumanBehaviour {

    void setMakeOrder(boolean makeOrder);  // Сделать заказ

    void setTakeOrder(boolean takeOrder);  // Получить заказ

    boolean isMakeOrder();                 // Проверка:  Сделал ли он заказ

    boolean isTakeOrder();                 //            Получил ли он заказ

}


## ShopBehaviour

import java.util.List;

public interface ShopBehaviour {

    void accertToMarket(Buyer actor);                  // ьетод отвечаюющий что человек становится в очередь

    void releaseFromMarket(List<Buyer> actors);        // выйти из магазина

    void update();                                     // обновляет информацию о посетителях

}


## Buyer

public abstract class Buyer implements HumanBehaviour {

    protected String name;
    
    protected boolean makeOrder;
    
    protected boolean takeOrder;

    public Buyer(String name) {
        this.name = name;
        makeOrder = false;
        takeOrder = false;
    }

    public String getName() {
        return name;
    }
}


  ## QueueBehaviour

  void takeInQueue(Buyer actor);    

    void takeOrders();               // собрать все заказы с очереди

    void giveOrders();               // отдать заказы

    void releaseFromQueue();         // убрать человека с очереди
}



## ShopBehaviour

import java.util.ArrayList;

import java.util.List;

public class Shop implements ShopBehaviour, QueueBehaviour {

    private List<Buyer> queue = new ArrayList<>();

    @Override
    public void accertToMarket(Buyer actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        takeInQueue(actor);


    }

    @Override
    public void releaseFromMarket(List<Buyer> actors) {
        for (Buyer actor : actors) {
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Buyer actor) {
        System.out.println(actor.getName() + " встал в очередь");
        queue.add(actor);

    }

    @Override
    public void takeOrders() {
        for (Buyer actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал заказ");
            }
        }

    }

    @Override
    public void giveOrders() {
        for (Buyer actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Buyer> releasedActors = new ArrayList<>();
        for (Buyer actor : queue) {
            if (actor.isTakeOrder()) {
                releasedActors.add(actor);
                System.out.println(actor.getName() + " вышел из очереди");
            }
        }
        releaseFromMarket(releasedActors);
    }
}


## main

public class Main {

    public static void main(String[] args) {
    
        Shop market = new Shop();
        Human human_1 = new Human("Иван");
        Human human_2 = new Human("Петр");
        Human human_3 = new Human("Василий");
 
        market.accertToMarket(human_1);
        market.accertToMarket(human_2);
        market.accertToMarket(human_3);

        market.update();
    }
}


                   ##  ВЫВОД:

Иван пришел в магазин
Иван встал в очередь
Петр пришел в магазин
Петр встал в очередь
Василий пришел в магазин
Василий встал в очередь
Иван сделал заказ
Петр сделал заказ
Василий сделал заказ
Иван получил заказ
Петр получил заказ
Василий получил заказ
Иван вышел из очереди
Петр вышел из очереди
Василий вышел из очереди
Иван вышел из магазина
Петр вышел из магазина
Василий вышел из магазина          


