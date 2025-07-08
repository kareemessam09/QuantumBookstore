package models;

import services.MailService;
import exceptions.*;

public class EBook extends Book {
    private String fileFormat;
    private MailService mailService;

    public EBook(String isbn, String title, int publishYear, double price, String author, String fileFormat) {
        super(isbn, title, publishYear, price, author);
        this.fileFormat = fileFormat;
        this.mailService = new MailService();
    }

    public String getFileFormat() {
        return fileFormat;
    }


    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public boolean canPurchase(int quantity) throws InvalidInputException {
        if (quantity <= 0) {
            throw new InvalidInputException("quantity", quantity, "Must be greater than 0");
        }
        // Digital books have unlimited "stock" since they can be copied infinitely
        return true;
    }

    @Override
    public boolean purchase(int quantity) throws InvalidInputException {
        if (quantity <= 0) {
            throw new InvalidInputException("quantity", quantity, "Must be greater than 0");
        }
        
        System.out.println("Quantum book store: Successfully purchased " + quantity + " digital copies of " + title);
        deliver();
        return true;
    }

    @Override
    public void deliver() {
        mailService.sendEmail(this);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Format: %s [E-Book]", fileFormat);
    }
}
