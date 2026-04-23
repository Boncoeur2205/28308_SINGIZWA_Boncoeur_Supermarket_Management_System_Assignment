package supermarket;

public class InventoryManager extends Product implements Sellable {
    private String supplierName;
    private String storageLocation;

    public InventoryManager(int productID, String productName, double price, int quantity,
                            String category, String supplierName, String storageLocation) {
        super(productID, productName, price, quantity, category);
        this.supplierName = supplierName;
        this.storageLocation = storageLocation;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }

    @Override
    public double applyTax() {
        return getPrice() * 0.18;
    }

    @Override
    public boolean checkAvailability() {
        return getQuantity() > 0;
    }

    @Override
    public double calculateTotalValue() {
        return getPrice() * getQuantity();
    }

    @Override
    public void updateStock(int newQuantity) {
        setQuantity(newQuantity);
    }

    @Override
    public boolean validateProduct() {
        return getProductID() > 0 && !getProductName().isBlank() && getPrice() > 0;
    }

    @Override
    public void generateReport() {
        System.out.println(getCategory() + " product report: " + toString());
    }

    @Override
    public String getCategoryDescription() {
        return "Category: " + getCategory();
    }

    @Override
    public void processSale(int quantity) {
        if (checkAvailability() && quantity <= getQuantity()) {
            updateStock(getQuantity() - quantity);
            System.out.println("Sale processed for " + quantity + " units of " + getProductName());
        } else {
            System.out.println("Error: Not enough stock available. Current stock: " + getQuantity());
        }
    }

    @Override
    public double calculateFinalPrice() {
        return getPrice() - calculateDiscount() + applyTax();
    }

    // FIX: printReceipt() was empty — now prints a basic summary receipt
    @Override
    public void printReceipt() {
        System.out.println("========== RECEIPT ==========");
        System.out.println("Product:  " + getProductName());
        System.out.println("Category: " + getCategory());
        System.out.println("Unit Price: $" + String.format("%.2f", getPrice()));
        System.out.println("Discount:   $" + String.format("%.2f", calculateDiscount()));
        System.out.println("Tax:        $" + String.format("%.2f", applyTax()));
        System.out.println("Final Price:$" + String.format("%.2f", calculateFinalPrice()));
        System.out.println("=============================");
    }

    @Override
    public void printReceipt(int purchasedQuantity) {
        double finalUnitPrice = calculateFinalPrice();
        double finalTotal = finalUnitPrice * purchasedQuantity;
        System.out.println("========== RECEIPT ==========");
        System.out.println("Product:   " + getProductName());
        System.out.println("Category:  " + getCategory());
        System.out.println("Units:     " + purchasedQuantity);
        System.out.println("Unit Price:$" + String.format("%.2f", getPrice()));
        System.out.println("Discount:  $" + String.format("%.2f", calculateDiscount()));
        System.out.println("Tax:       $" + String.format("%.2f", applyTax()));
        System.out.println("TOTAL:     $" + String.format("%.2f", finalTotal));
        System.out.println("=============================");
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + getProductID() +
                ", Name='" + getProductName() + '\'' +
                ", Price=" + getPrice() +
                ", Quantity=" + getQuantity() +
                ", Category='" + getCategory() + '\'' +
                ", Supplier='" + supplierName + '\'' +
                ", Storage='" + storageLocation + '\'' +
                '}';
    }
}
