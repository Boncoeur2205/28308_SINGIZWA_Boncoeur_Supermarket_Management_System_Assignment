package supermarket;

public class Order {
    private int orderID;
    private Product product;
    private int quantityPurchased;
    private double totalPrice;

    public Order() {
    }

    public Order(int orderID, Product product, int quantityPurchased, double totalPrice) {
        this.orderID = orderID;
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.totalPrice = calculateTotalPrice();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(int quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
        this.totalPrice = calculateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public double calculateTotalPrice(){
        if (product != null){
            return product.getPrice() * quantityPurchased;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", product=" + product +
                ", quantityPurchased=" + quantityPurchased +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
