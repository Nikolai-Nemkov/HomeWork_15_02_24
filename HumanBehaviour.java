public interface HumanBehaviour {

    void setMakeOrder(boolean makeOrder);  // Сделать заказ

    void setTakeOrder(boolean takeOrder);  // Получить заказ

    boolean isMakeOrder();                 // Проверка:  Сделал ли он заказ

    boolean isTakeOrder();                 //            Получил ли он заказ

}
