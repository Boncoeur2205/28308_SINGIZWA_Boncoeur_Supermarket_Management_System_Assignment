package supermarket;

public class InputValidator {
    public static boolean validateString(String input){
        if (input == null || input.trim().isEmpty()){
            System.out.println("Error: Input cannot be empty");
            return false;
        }
        return true;
    }
    public static boolean validatePositiveNumber(int number){
        if (number <= 0){
            System.out.println("Error: Number must be greater than zero");
            return false;
        }
        return true;
    }
    public static boolean validatePrice(double price){
        if (price <= 0){
            System.out.println("Error: Price must be greater than zero");
            return false;
        }
        return true;
    }
    public static boolean validatePhoneNumber(String phoneNumber){
        if (!phoneNumber.matches("\\d{10,}")){
            System.out.println("Error: Invalid phone number format. Must be at least 10 digits");
            return false;
        }
        return true;
    }
    public static boolean validateCategory(String category){
        String[] validateCategories = {"food", "Beverage", "Electronic", "Clothing", "Cleaning", "PersonalCare"};
        for (String valid : validateCategories){
            if (valid.equalsIgnoreCase(category)){
                return true;
            }
        }
        System.out.println("Error: Invalid product category");
        return false;
    }
}
