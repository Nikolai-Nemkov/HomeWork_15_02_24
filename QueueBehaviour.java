public interface QueueBehaviour {
    void takeInQueue(Buyer actor);   // стать в очередь, добавляет человека в список

    void takeOrders();               // собрать все заказы с очереди

    void giveOrders();               // отдать заказы

    void releaseFromQueue();         // убрать человека с очереди
}
