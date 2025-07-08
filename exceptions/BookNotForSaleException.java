package exceptions;


public class BookNotForSaleException extends BookStoreException {
    
    private final String isbn;
    private final String bookType;
    
    public BookNotForSaleException(String bookTitle, String isbn, String bookType) {
        super(String.format("'%s' (%s) is not for sale", bookTitle, bookType));
        this.isbn = isbn;
        this.bookType = bookType;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getBookType() {
        return bookType;
    }
}
