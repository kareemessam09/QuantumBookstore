package exceptions;


public class InsufficientStockException extends BookStoreException {
    
    private final int requested;
    private final int available;
    
    public InsufficientStockException(String bookTitle, int requested, int available) {
        super(String.format("Insufficient stock for '%s'. Requested: %d, Available: %d", 
                           bookTitle, requested, available));
        this.requested = requested;
        this.available = available;
    }
    
    public int getRequested() {
        return requested;
    }
    
    public int getAvailable() {
        return available;
    }
}
