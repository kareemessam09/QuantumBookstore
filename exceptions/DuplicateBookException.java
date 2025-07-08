package exceptions;


public class DuplicateBookException extends BookStoreException {
    
    private final String isbn;
    private final String existingTitle;
    
    public DuplicateBookException(String isbn, String existingTitle) {
        super(String.format("Book with ISBN '%s' already exists in inventory: '%s'", isbn, existingTitle));
        this.isbn = isbn;
        this.existingTitle = existingTitle;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getExistingTitle() {
        return existingTitle;
    }
}
