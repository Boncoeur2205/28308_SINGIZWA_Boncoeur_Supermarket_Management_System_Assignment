package supermarket;

public class CleaningProduct extends InventoryManager{
    private String chemicalComposition;

    public CleaningProduct(int productID, String productName, double price, int quantity, String category, String supplierName, String storageLocation, String chemicalComposition) {
        super(productID, productName, price, quantity, category, supplierName, storageLocation);
        this.chemicalComposition = chemicalComposition;
    }

    public String getChemicalComposition() {
        return chemicalComposition;
    }

    public void setChemicalComposition(String chemicalComposition) {
        this.chemicalComposition = chemicalComposition;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() *0.1;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && chemicalComposition != null && !chemicalComposition.isBlank();
    }

    @Override
    public void generateReport() {
        System.out.println("cleaning product report: " + toString());
    }

    @Override
    public String toString() {
        return super.toString() + ", Composition='" + chemicalComposition + '\'';
    }
}
