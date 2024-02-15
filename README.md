# HomeWork_15_02_24

Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования
Реализовать класс Market и все методы, которые он обязан реализовывать.
Методы из интерфейса QueueBehaviour, имитируют работу очереди, MarketBehaviour – помещает и удаляет человека из очереди, метод update – обновляет состояние магазина (принимает и отдаёт заказы)
Формат сдачи: ссылка на гитхаб проект


## QueueBehaviour

public interface QueueBehaviour {
    void takeInQueue(Buyer actor);   // стать в очередь, добавляет человека в список

    void takeOrders();               // собрать все заказы с очереди

    void giveOrders();               // отдать заказы

    void releaseFromQueue();         // убрать человека с очереди
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
