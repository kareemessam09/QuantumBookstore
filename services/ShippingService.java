package services;

import models.PaperBook;
import java.util.Random;


public class ShippingService {
    private Random random;


    public ShippingService() {
        this.random = new Random();
    }

    public void ship(PaperBook paperBook) {
        if (paperBook == null) {
            System.out.println("Quantum book store: Cannot ship null book.");
            return;
        }
        
        String trackingNumber = generateTrackingNumber();
        String shippingMethod = selectShippingMethod();
        int estimatedDays = getEstimatedDeliveryDays(shippingMethod);
        
        System.out.println("Quantum book store: Preparing book for shipping...");
        System.out.println("Quantum book store: Shipping Details:");
        System.out.println("  - Book: " + paperBook.getTitle() + " by " + paperBook.getAuthor());
        System.out.println("  - Tracking Number: " + trackingNumber);
        System.out.println("  - Shipping Method: " + shippingMethod);
        System.out.println("  - Estimated Delivery: " + estimatedDays + " business days");
        System.out.println("  - Shipping Address: 123 Customer Street, City, State, ZIP");
        System.out.println("Quantum book store: Physical book successfully shipped!");
    }


    private String generateTrackingNumber() {
        String prefix = "QBS";
        String suffix = String.format("%010d", random.nextInt(1000000000));
        return prefix + suffix;
    }


    private String selectShippingMethod() {
        String[] methods = {
            "Standard Shipping",
            "Express Shipping",
            "Priority Mail",
            "Ground Shipping"
        };
        return methods[random.nextInt(methods.length)];
    }


    private int getEstimatedDeliveryDays(String method) {
        switch (method) {
            case "Express Shipping":
                return 1 + random.nextInt(2); 
            case "Priority Mail":
                return 2 + random.nextInt(2); 
            case "Standard Shipping":
                return 5 + random.nextInt(3); 
            case "Ground Shipping":
                return 7 + random.nextInt(4);
            default:
                return 5;
        }
    }

    public double calculateShippingCost(String method) {
        switch (method) {
            case "Express Shipping":
                return 15.99;
            case "Priority Mail":
                return 8.99;
            case "Standard Shipping":
                return 4.99;
            case "Ground Shipping":
                return 2.99;
            default:
                return 4.99;
        }
    }


    public void checkShippingStatus(String trackingNumber) {
        String[] statuses = {
            "Package prepared",
            "In transit",
            "Out for delivery",
            "Delivered"
        };
        
        String status = statuses[random.nextInt(statuses.length)];
        System.out.println("Quantum book store: Tracking " + trackingNumber + " - Status: " + status);
    }
}
