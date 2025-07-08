package exceptions;


public class InvalidInputException extends BookStoreException {
    
    private final String parameterName;
    private final Object invalidValue;
    
    public InvalidInputException(String parameterName, Object invalidValue, String reason) {
        super(String.format("Invalid %s: %s - %s", parameterName, invalidValue, reason));
        this.parameterName = parameterName;
        this.invalidValue = invalidValue;
    }
    
    public String getParameterName() {
        return parameterName;
    }
    
    public Object getInvalidValue() {
        return invalidValue;
    }
}
