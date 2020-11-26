package odz;

public class ItemRegular extends Item{
    public ItemRegular(String title, double price, int quantity){
        super(title,price,quantity);
    }

    public int calculateDiscount() {
        int discount = 0;
        if (discount < 80) {
            discount += this.getQuantity() / 10;
            if (discount > 80)
                discount = 80;
        }
        return discount;
    }
}
