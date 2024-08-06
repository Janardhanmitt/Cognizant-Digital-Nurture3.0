import java.util.*;

class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

class BubbleSort {
    public static void sortByBubble(Order[] orders) {
        int length = orders.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort {
    public static void sortByQuick(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            sortByQuick(orders, low, pivotIndex - 1);
            sortByQuick(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivotValue = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivotValue) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

public class SortCustomerOrder {
    public static void main(String[] args) {
        Order[] orders = {
                new Order(3, "Charlie", 450.00),
                new Order(1, "Alice", 300.50),
                new Order(4, "David", 200.00),
                new Order(2, "Bob", 150.75),
        };

        System.out.println("Original Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        BubbleSort.sortByBubble(orders);
        System.out.println("\nSorted Orders (Bubble Sort):");
        System.out.println(Arrays.toString(orders));

        QuickSort.sortByQuick(orders, 0, orders.length - 1);
        System.out.println("\nSorted Orders (Quick Sort):");
        System.out.println(Arrays.toString(orders));
    }
}
