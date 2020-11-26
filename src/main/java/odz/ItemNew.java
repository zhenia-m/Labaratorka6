package odz;

public class ItemNew extends Item{
    public ItemNew(String title, double price, int quantity){
        super(title,price,quantity);
    }

    public int calculateDiscount() {
        return 0;
    }
}
