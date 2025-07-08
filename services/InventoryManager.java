package services;

import models.*;
import exceptions.*;
import java.util.*;


public class InventoryManager {
    private Map<String, Book> inventory;

    public InventoryManager() {
        this.inventory = new HashMap<>();
    }

    public void addBook(Book book) throws InvalidInputException, DuplicateBookException {
        if (book == null) {
            throw new InvalidInputException("book", null, "Book cannot be null");
        }
        
        if (inventory.containsKey(book.getIsbn())) {
            Book existingBook = inventory.get(book.getIsbn());
            throw new DuplicateBookException(book.getIsbn(), existingBook.getTitle());
        }
        
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book to inventory: " + book.getTitle());
    }


    public int removeOutdatedBooks(int cutoffYear) {
        List<String> booksToRemove = new ArrayList<>();
        
        for (Book book : inventory.values()) {
            if (book.getPublishYear() < cutoffYear) {
                booksToRemove.add(book.getIsbn());
            }
        }
        
        int removedCount = 0;
        for (String isbn : booksToRemove) {
            Book removedBook = inventory.remove(isbn);
            if (removedBook != null) {
                System.out.println("Quantum book store: Removed outdated book: " + removedBook.getTitle() + " (Published: " + removedBook.getPublishYear() + ")");
                removedCount++;
            }
        }
        
        System.out.println("Quantum book store: Removed " + removedCount + " outdated books from inventory.");
        return removedCount;
    }


    public double buyBooks(String isbn, int quantity) throws InvalidInputException, BookNotFoundException, 
                                                            InsufficientStockException, BookNotForSaleException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new InvalidInputException("isbn", isbn, "ISBN cannot be null or empty");
        }
        
        if (quantity <= 0) {
            throw new InvalidInputException("quantity", quantity, "Must be greater than 0");
        }
        
        Book book = inventory.get(isbn);
        if (book == null) {
            throw new BookNotFoundException(isbn);
        }
        
        boolean purchaseSuccess = book.purchase(quantity);
        if (purchaseSuccess) {
            double totalAmount = book.getPrice() * quantity;
            System.out.println("Quantum book store: Total amount paid: $" + String.format("%.2f", totalAmount));
            return totalAmount;
        }
        
        return 0.0;
    }

   
    public Book findBookByIsbn(String isbn) {
        return inventory.get(isbn);
    }

    public Collection<Book> getAllBooks() {
        return inventory.values();
    }


    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Quantum book store: Inventory is empty.");
            return;
        }
        
        System.out.println("Quantum book store: Current Inventory:");
        System.out.println("=" + "=".repeat(80));
        
        for (Book book : inventory.values()) {
            System.out.println(book);
        }
        
        System.out.println("=" + "=".repeat(80));
        System.out.println("Quantum book store: Total books in inventory: " + inventory.size());
    }


    public int getInventorySize() {
        return inventory.size();
    }

    public boolean containsBook(String isbn) {
        return inventory.containsKey(isbn);
    }


    public boolean removeBook(String isbn) {
        Book removedBook = inventory.remove(isbn);
        if (removedBook != null) {
            System.out.println("Quantum book store: Removed book: " + removedBook.getTitle());
            return true;
        } else {
            System.out.println("Quantum book store: Book with ISBN " + isbn + " not found.");
            return false;
        }
    }
}
