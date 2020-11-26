package odz;

public abstract class Item {
    private String title;
    private double price;
    private int quantity;
    private int discount;
    private double total;

    public Item(String title, double price, int quantity){
        setPrice(price);
        setQuantity(quantity);
        setTitle(title);
    }

    public abstract int calculateDiscount();

    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * (100.00 - getDiscount()) / 100.00;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return total;
    }

    public void setTotalPrice(double total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }



}
