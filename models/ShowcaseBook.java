package models;

import exceptions.*;

public class ShowcaseBook extends Book {


    public ShowcaseBook(String isbn, String title, int publishYear, double price, String author) {
        super(isbn, title, publishYear, price, author);
    }

    @Override
    public boolean canPurchase(int quantity) throws InvalidInputException {
        if (quantity <= 0) {
            throw new InvalidInputException("quantity", quantity, "Must be greater than 0");
        }
        return false;
    }

    @Override
    public boolean purchase(int quantity) throws InvalidInputException, BookNotForSaleException {
        if (quantity <= 0) {
            throw new InvalidInputException("quantity", quantity, "Must be greater than 0");
        }
        throw new BookNotForSaleException(title, isbn, "Showcase Book");
    }

    @Override
    public void deliver() {
        System.out.println("Quantum book store: Showcase books cannot be delivered as they are not for sale.");
    }

    @Override
    public String toString() {
        return super.toString() + " [Showcase Only - Not for Sale]";
    }
}
