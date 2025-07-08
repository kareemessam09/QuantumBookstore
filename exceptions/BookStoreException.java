package exceptions;

public class BookStoreException extends Exception {
   public BookStoreException(String var1) {
      super("Quantum book store: " + var1);
   }

   public BookStoreException(String var1, Throwable var2) {
      super("Quantum book store: " + var1, var2);
   }
}
