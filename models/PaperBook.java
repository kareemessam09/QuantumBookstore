package models;

import services.ShippingService;
import exceptions.*;


public class PaperBook extends Book {
    private int stock;
    private ShippingService shippingService;


    public PaperBook(String isbn, String title, int publishYear, double price, String author, int stock) {
        super(isbn, title, publishYear, price, author);
        this.stock = stock;
        this.shippingService = new ShippingService();
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public void addStock(int quantity) {
        this.stock += quantity;
        System.out.println("Quantum book store: Added " + quantity + " units to stock. New stock: " + this.stock);
    }

    @Override
    public boolean canPurchase(int quantity) throws InvalidInputException {
        if (quantity <= 0) {
            throw new InvalidInputException("quantity", quantity, "Must be greater than 0");
        }
        return stock >= quantity;
    }

    @Override
    public boolean purchase(int quantity) throws InvalidInputException, InsufficientStockException {
        if (quantity <= 0) {
            throw new InvalidInputException("quantity", quantity, "Must be greater than 0");
        }
        
        if (stock < quantity) {
            throw new InsufficientStockException(title, quantity, stock);
        }
        
        stock -= quantity;
        System.out.println("Quantum book store: Successfully purchased " + quantity + " copies of " + title);
        System.out.println("Quantum book store: Remaining stock: " + stock);
        deliver();
        return true;
    }

    @Override
    public void deliver() {
        shippingService.ship(this);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Stock: %d [Paper Book]", stock);
    }
}
