package supermarket;

public class FoodProduct extends InventoryManager {
    private String expiryDate;

    public FoodProduct(int productID, String productName, double price, int quantity, String category, String supplierName, String storageLocation, String expiryDate) {
        super(productID, productName, price, quantity, category, supplierName, storageLocation);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && expiryDate != null && !expiryDate.isBlank();
    }

    // FIX: removed accidental double semicolon ;;
    @Override
    public void generateReport() {
        System.out.println("Food product report: " + toString());
    }

    @Override
    public String toString() {
        return super.toString() + ", ExpiryDate='" + expiryDate + '\'';
    }
}
