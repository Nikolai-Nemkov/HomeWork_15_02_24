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
