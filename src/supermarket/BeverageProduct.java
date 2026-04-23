package supermarket;

public class BeverageProduct extends InventoryManager{
    private double volume;

    public BeverageProduct(int productID, String productName, double price, int quantity, String category, String supplierName, String storageLocation, double volume) {
        super(productID, productName, price, quantity, category, supplierName, storageLocation);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && volume > 0;
    }

    @Override
    public void generateReport() {
        System.out.println("beverage product report: " + toString());
    }

    @Override
    public String toString() {
        return super.toString() + ", Volume=" + volume + "L";
    }
}
