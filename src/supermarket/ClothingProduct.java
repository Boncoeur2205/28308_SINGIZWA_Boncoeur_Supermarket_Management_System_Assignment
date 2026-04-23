package supermarket;

public class ClothingProduct extends InventoryManager{
    private String size;

    public ClothingProduct(int productID, String productName, double price, int quantity, String category, String supplierName, String storageLocation, String size) {
        super(productID, productName, price, quantity, category, supplierName, storageLocation);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.25;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && size != null && !size.isBlank();
    }

    @Override
    public void generateReport() {
        System.out.println("clothing product report: " + toString());
    }

    @Override
    public String toString() {
        return super.toString() + ", Size='" + size + '\'';
    }
}
