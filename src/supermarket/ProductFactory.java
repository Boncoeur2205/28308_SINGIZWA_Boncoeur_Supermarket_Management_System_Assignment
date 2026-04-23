package supermarket;

public class ProductFactory {
    public static Product createProduct(int productID, String productName, double price, int quantity, String category, String supplierName, String storageLocation, String extraAttribute){
        if (category.equalsIgnoreCase("food")){
            return new FoodProduct(productID, productName, price, quantity, category, supplierName, storageLocation, extraAttribute);
        } else if (category.equalsIgnoreCase("Beverage")) {
            double volume = Double.parseDouble(extraAttribute);
            return new BeverageProduct(productID, productName, price, quantity, category, supplierName, storageLocation, volume);
        } else if (category.equalsIgnoreCase("Electronic")) {
            int warranty = Integer.parseInt(extraAttribute);
            return new ElectronicProduct(productID, productName, price, quantity, category, supplierName, storageLocation, warranty);
        } else if (category.equalsIgnoreCase("Clothing")) {
            return new ClothingProduct(productID, productName, price, quantity, category, supplierName, storageLocation, extraAttribute);
        } else if (category.equalsIgnoreCase("Cleaning")) {
            return new CleaningProduct(productID, productName, price, quantity, category, supplierName, storageLocation, extraAttribute);
        } else if (category.equalsIgnoreCase("PersonalCare")) {
            return new PersonalCareProduct(productID, productName, price, quantity, category, supplierName, storageLocation, extraAttribute);
        }else {
            System.out.println("Error: Unknown category");
            return null;
        }
    }
}
