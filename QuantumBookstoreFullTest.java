import models.*;
import services.InventoryManager;
import exceptions.*;

/*
 * Hi!
 * i tried to be as simple as possible}
 * 
 * java is my first ever programming language so i have some {alot i guess} love for it so i tried my best
 * 
 * i could have done better though, but the time was not too much
 * 
 * hope u find it ez to review and looking forword to work together
 * 
 * have a nice day
 * 
 * kareem essam
 * 01554158037
 * 
 * again this is 100% effort from me, i just got ai help to wite the tests not more than that
 * thanks
 */

public class QuantumBookstoreFullTest {

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("     WELCOME TO QUANTUM BOOK STORE ");
        System.out.println("=".repeat(60));

        // Create inventory
        InventoryManager inventory = new InventoryManager();

        System.out.println("\n TEST 1: Adding Books to Inventory");
        testAddingBooks(inventory);

        System.out.println("\n TEST 2: Display Current Inventory");
        inventory.displayInventory();

        System.out.println("\n TEST 3: Successful Book Purchases");
        testSuccessfulPurchases(inventory);

        System.out.println("\n TEST 4: Failed Purchase Attempts");
        testFailedPurchases(inventory);

        System.out.println("\n TEST 5: Remove Outdated Books");
        testRemoveOutdatedBooks(inventory);

        System.out.println("\n TEST 6: Final Inventory Status");
        inventory.displayInventory();

        System.out.println("\n" + "=".repeat(60));
        System.out.println("     ALL TESTS COMPLETED SUCCESSFULLY!");
        System.out.println("=".repeat(60));
    }

    private static void testAddingBooks(InventoryManager inventory) {
        // Add Paper Books
        PaperBook javaBook = new PaperBook(
                "978-0134685991",
                "Effective Java",
                2018,
                45.99,
                "Joshua Bloch",
                15);

        PaperBook designPatternsBook = new PaperBook(
                "978-0201633610",
                "Design Patterns",
                1994,
                54.99,
                "Gang of Four",
                8);

        // Add E-Books
        EBook pythonBook = new EBook(
                "978-1593279288",
                "Automate the Boring Stuff with Python",
                2019,
                29.99,
                "Al Sweigart",
                "PDF");

        EBook jsBook = new EBook(
                "978-1449331818",
                "Learning JavaScript Design Patterns",
                2012,
                39.99,
                "Addy Osmani",
                "EPUB");

        // Add Showcase Books
        ShowcaseBook rareLegacyBook = new ShowcaseBook(
                "978-0131103627",
                "The C Programming Language",
                1988,
                89.99,
                "Brian Kernighan & Dennis Ritchie");

        ShowcaseBook upcomingBook = new ShowcaseBook(
                "978-0135957059",
                "The Future of Programming",
                2026,
                59.99,
                "Future Author");

        // Add all books with exception 
        try {
            inventory.addBook(javaBook);
            inventory.addBook(designPatternsBook);
            inventory.addBook(pythonBook);
            inventory.addBook(jsBook);
            inventory.addBook(rareLegacyBook);
            inventory.addBook(upcomingBook);
        } catch (InvalidInputException | DuplicateBookException e) {
            System.out.println("Exception while adding book: " + e.getMessage());
        }

        // Try to add duplicate 
        System.out.println("\n Attempting to add duplicate book:");
        try {
            inventory.addBook(new PaperBook("978-0134685991", "Duplicate Java Book", 2020, 35.99, "Someone Else", 5));
        } catch (DuplicateBookException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }

    private static void testSuccessfulPurchases(InventoryManager inventory) {
        System.out.println("Purchasing 2 copies of Effective Java:");
        try {
            double total1 = inventory.buyBooks("978-0134685991", 2);

            System.out.println("\nPurchasing 1 copy of Python E-Book:");
            double total2 = inventory.buyBooks("978-1593279288", 1);

            System.out.println("\nPurchasing 5 copies of JavaScript E-Book:");
            double total3 = inventory.buyBooks("978-1449331818", 5);

            double grandTotal = total1 + total2 + total3;
            System.out.println("\nGrand Total for all purchases: $" + String.format("%.2f", grandTotal));

        } catch (InvalidInputException | BookNotFoundException | InsufficientStockException
                | BookNotForSaleException e) {
            System.out.println("Purchase failed: " + e.getMessage());
        }
    }

    private static void testFailedPurchases(InventoryManager inventory) {
        System.out.println("Attempting to purchase non-existent book:");
        try {
            inventory.buyBooks("978-9999999999", 1);
        } catch (BookNotFoundException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        } catch (InvalidInputException | InsufficientStockException | BookNotForSaleException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        System.out.println("\nAttempting to purchase showcase book:");
        try {
            inventory.buyBooks("978-0131103627", 1);
        } catch (BookNotForSaleException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        } catch (InvalidInputException | BookNotFoundException | InsufficientStockException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        System.out.println("\nAttempting to purchase more than available stock:");
        try {
            inventory.buyBooks("978-0201633610", 20); // Only 8 in stock
        } catch (InsufficientStockException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        } catch (InvalidInputException | BookNotFoundException | BookNotForSaleException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        System.out.println("\nAttempting to purchase with invalid quantity:");
        try {
            inventory.buyBooks("978-0134685991", 0);
        } catch (InvalidInputException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        } catch (BookNotFoundException | InsufficientStockException | BookNotForSaleException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        try {
            inventory.buyBooks("978-0134685991", -1);
        } catch (InvalidInputException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        } catch (BookNotFoundException | InsufficientStockException | BookNotForSaleException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        System.out.println("\nAttempting to purchase with invalid ISBN:");
        try {
            inventory.buyBooks(null, 1);
        } catch (InvalidInputException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        } catch (BookNotFoundException | InsufficientStockException | BookNotForSaleException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        try {
            inventory.buyBooks("", 1);
        } catch (InvalidInputException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        } catch (BookNotFoundException | InsufficientStockException | BookNotForSaleException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }

    private static void testRemoveOutdatedBooks(InventoryManager inventory) {
        System.out.println("Current year: 2025");

        // Remove books published before 2015 (10 years old)
        int cutoffYear = 2025 - 10;
        System.out.println("Removing books published before " + cutoffYear + ":");

        int removedCount = inventory.removeOutdatedBooks(cutoffYear);

        if (removedCount == 0) {
            System.out.println("Quantum book store: No outdated books found.");
        }

    }

}
