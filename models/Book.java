package models;

import exceptions.*;


public abstract class Book {
    protected String isbn;
    protected String title;
    protected int publishYear;
    protected double price;
    protected String author;


    public Book(String isbn, String title, int publishYear, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.publishYear = publishYear;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void deliver();

    public abstract boolean canPurchase(int quantity) throws InvalidInputException;

    public abstract boolean purchase(int quantity) throws InvalidInputException, InsufficientStockException, BookNotForSaleException;

    @Override
    public String toString() {
        return String.format("ISBN: %s, Title: %s, Author: %s, Year: %d, Price: $%.2f", 
                           isbn, title, author, publishYear, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
