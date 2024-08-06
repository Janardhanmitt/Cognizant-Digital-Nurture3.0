import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Quantity=" + quantity + ", Price=" + price + "]";
    }
}

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addNewProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void modifyProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void showInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        int userChoice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add New Product:");
            System.out.println("2. Modify Product:");
            System.out.println("3. Remove Product:");
            System.out.println("4. Show Inventory:");
            System.out.println("Enter your choice:");
            userChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            if (userChoice == -1) {
                break;
            }

            String id, name;
            int quantity;
            double price;

            switch (userChoice) {
                case 1:
                    System.out.println("Enter product ID:");
                    id = scanner.nextLine();
                    System.out.println("Enter product name:");
                    name = scanner.nextLine();
                    System.out.println("Enter product quantity:");
                    quantity = scanner.nextInt();
                    System.out.println("Enter product price:");
                    price = scanner.nextDouble();
                    ims.addNewProduct(new Product(id, name, quantity, price));
                    break;

                case 2:
                    System.out.println("Enter product ID:");
                    id = scanner.nextLine();
                    System.out.println("Enter product name:");
                    name = scanner.nextLine();
                    System.out.println("Enter product quantity:");
                    quantity = scanner.nextInt();
                    System.out.println("Enter product price:");
                    price = scanner.nextDouble();
                    ims.modifyProduct(new Product(id, name, quantity, price));
                    break;

                case 3:
                    System.out.println("Enter product ID:");
                    id = scanner.nextLine();
                    ims.removeProduct(id);
                    break;

                case 4:
                    ims.showInventory();
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
