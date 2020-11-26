package odz;

public class ItemSecondFree extends Item{
    public ItemSecondFree(String title, double price, int quantity){
        super(title,price,quantity);
    }

    public int calculateDiscount() {
        int discount = 0;

        if (this.getQuantity() > 1)
            discount = 50;

        if (discount < 80) {
            discount += this.getQuantity() / 10;
            if (discount > 80)
                discount = 80;
        }
        return discount;
    }

}
