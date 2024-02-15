
import java.util.List;

public interface ShopBehaviour {
    void accertToMarket(Buyer actor);   // ьетод отвечаюющий что человек становится в очередь

    void releaseFromMarket(List<Buyer> actors);  // выйти из магазина

    void update();               // обновляет информацию о посетителях

}
