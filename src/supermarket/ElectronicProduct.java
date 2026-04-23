package supermarket;

public class ElectronicProduct extends InventoryManager{
    private int warrantyPeriod;

    public ElectronicProduct(int productID, String productName, double price, int quantity, String category, String supplierName, String storageLocation, int warrantyPeriod) {
        super(productID, productName, price, quantity, category, supplierName, storageLocation);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && warrantyPeriod > 0;
    }

    @Override
    public void generateReport() {
        System.out.println("electronic product report: " + toString());
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty=" + warrantyPeriod + " months";
    }
}
