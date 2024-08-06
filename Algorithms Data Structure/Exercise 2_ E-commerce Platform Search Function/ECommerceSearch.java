import java.util.*;

class Product {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getProductId() {
        return id;
    }

    public String getProductName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + id +
                ", productName='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

class SequentialSearch {
    public static Product findProductById(Product[] products, int searchId) {
        for (Product p : products) {
            if (p.getProductId() == searchId) {
                return p;
            }
        }
        return null;
    }
}

class SortedBinarySearch {
    public static Product findProductById(Product[] products, int searchId) {
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
        int low = 0;
        int high = products.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (products[mid].getProductId() == searchId) {
                return products[mid];
            } else if (products[mid].getProductId() > searchId) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }
}

public class ProductSearch {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Book", "Education"),
            new Product(4, "Shirt", "Clothing"),
            new Product(5, "Shoes", "Footwear"),
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID to search: ");
        int searchId = scanner.nextInt();

        Product resultBinary = SortedBinarySearch.findProductById(products, searchId);
        System.out.println("Result from Binary Search:");
        System.out.println(resultBinary);

        Product resultLinear = SequentialSearch.findProductById(products, searchId);
        System.out.println("Result from Linear Search:");
        System.out.println(resultLinear);

        scanner.close();
    }
}
