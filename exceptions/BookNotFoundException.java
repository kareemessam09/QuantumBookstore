package exceptions;


public class BookNotFoundException extends BookStoreException {
    
    private final String isbn;
    
    public BookNotFoundException(String isbn) {
        super(String.format("Book with ISBN '%s' not found in inventory", isbn));
        this.isbn = isbn;
    }
    
    public String getIsbn() {
        return isbn;
    }
}
