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
