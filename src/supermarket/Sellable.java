package supermarket;

public interface Sellable {
    void processSale(int quantity);
    double calculateFinalPrice();
    void printReceipt();
    void printReceipt(int purchasedQuantity);

}
