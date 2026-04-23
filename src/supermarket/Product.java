package supermarket;

public abstract class Product {
    private int productID;
    private String productName;
    private double price;
    private int quantity;
    private String category;

    public Product() {
    }

    public Product(int productID, String productName, double price, int quantity, String category) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                '}';
    }
    public abstract double calculateDiscount();
    public abstract double applyTax();
    public abstract boolean checkAvailability();
    public abstract double calculateTotalValue();
    public abstract void updateStock(int newQuantity);
    public abstract boolean validateProduct();
    public abstract void generateReport();
    public abstract String getCategoryDescription();
}
