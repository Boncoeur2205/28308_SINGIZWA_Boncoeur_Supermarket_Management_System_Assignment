package supermarket;

public class PersonalCareProduct extends InventoryManager{
    private String skinType;

    public PersonalCareProduct(int productID, String productName, double price, int quantity, String category, String supplierName, String storageLocation, String skinType) {
        super(productID, productName, price, quantity, category, supplierName, storageLocation);
        this.skinType = skinType;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.12;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && skinType != null && !skinType.isBlank();
    }

    @Override
    public void generateReport() {
        System.out.println("personal care product report: " + toString());
    }

    @Override
    public String toString() {
        return super.toString() + ", SkinType='" + skinType + '\'';
    }
}
