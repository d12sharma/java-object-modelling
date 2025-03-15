import java.util.*;

class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
}

class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private static int orderCounter = 1;
    
    public Order(Customer customer) {
        this.orderId = orderCounter++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }
    
    public void addProduct(Product product) {
        products.add(product);
    }
    
    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " - Customer: " + customer.getName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("\t" + product.getName() + " - $" + product.getPrice());
        }
    }
}

class Customer {
    private String name;
    private List<Order> orders;
    
    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void placeOrder(Order order) {
        orders.add(order);
    }
    
    public void showOrderHistory() {
        System.out.println("Customer: " + name + " - Order History:");
        for (Order order : orders) {
            order.showOrderDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        
        Product laptop = new Product("Laptop", 1200.00);
        Product phone = new Product("Smartphone", 800.00);
        Product headphones = new Product("Headphones", 150.00);
        
        Order order1 = new Order(customer1);
        order1.addProduct(laptop);
        order1.addProduct(phone);
        customer1.placeOrder(order1);
        
        Order order2 = new Order(customer2);
        order2.addProduct(headphones);
        customer2.placeOrder(order2);
        
        customer1.showOrderHistory();
        customer2.showOrderHistory();
    }
}