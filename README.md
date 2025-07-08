# 📚 Quantum Book Store

**Quantum Book Store** is a simple, object-oriented Java application simulating an online book store. It demonstrates good software design principles such as inheritance, abstraction, and extensibility, while remaining beginner-friendly.

---

## 🚀 Features

- Manage an inventory of different types of books:
  - **PaperBook**: Has stock and supports shipping.
  - **EBook**: Delivered via email in a specific file format.
  - **ShowcaseBook**: Display-only book that cannot be purchased.
- Add books with details: ISBN, title, publish year, price, and author.
- Remove outdated books based on publication year.
- Buy books using ISBN and quantity:
  - Automatically handles stock reduction.
  - Simulates sending books via shipping or email.
  - Calculates and displays total amount paid.
- All system messages are prefixed with `Quantum book store`.

---

## 🧱 Project Structure

```
QuantumBookStore/
│
├── models/                    # Book classes
│   ├── Book.java             # Abstract base class
│   ├── PaperBook.java        # Physical book with stock
│   ├── EBook.java            # Digital book with file type
│   └── ShowcaseBook.java     # Display-only, not for sale
│
├── services/                  # Services and logic
│   ├── InventoryManager.java # Core inventory logic
│   ├── MailService.java      # Mock email delivery
│   └── ShippingService.java  # Mock shipping delivery
│
├── utils/                     # Constants and helpers
│   └── Constants.java        # Application constants
│
└── QuantumBookstoreFullTest.java # Main class to test the app
```

---

## 🧠 Design Principles Used

| Principle | Description |
|----------|-------------|
| **Abstraction** | `Book` is an abstract class with common properties and methods. |
| **Inheritance** | Specific book types (PaperBook, EBook, ShowcaseBook) extend `Book`. |
| **Polymorphism** | Delivery behavior is handled differently per book type via overridden methods. |
| **Open/Closed Principle** | You can add new book types without modifying existing logic. |
| **Separation of Concerns** | Business logic is separated into `InventoryManager`, and services are mocked. |

---

## 🔧 How to Run

1. **Compile the Java files:**
   ```bash
   cd QuantumBookStore
   javac -d . models/*.java services/*.java utils/*.java *.java
   ```

2. **Run the test application:**
   ```bash
   java QuantumBookstoreFullTest
   ```

---

## 📖 Usage Examples

### Adding Books
```java
// Create inventory manager
InventoryManager inventory = new InventoryManager();

// Add a paper book
PaperBook javaBook = new PaperBook(
    "978-0134685991", 
    "Effective Java", 
    2018, 
    45.99, 
    "Joshua Bloch", 
    15  // stock
);
inventory.addBook(javaBook);

// Add an e-book
EBook pythonBook = new EBook(
    "978-1593279288", 
    "Automate the Boring Stuff with Python", 
    2019, 
    29.99, 
    "Al Sweigart", 
    "PDF"  // file format
);
inventory.addBook(pythonBook);

// Add a showcase book
ShowcaseBook rareBook = new ShowcaseBook(
    "978-0131103627", 
    "The C Programming Language", 
    1988, 
    89.99, 
    "Brian Kernighan & Dennis Ritchie"
);
inventory.addBook(rareBook);
```

### Purchasing Books
```java
// Purchase paper books (reduces stock)
double total1 = inventory.buyBooks("978-0134685991", 2);

// Purchase e-books (unlimited stock)
double total2 = inventory.buyBooks("978-1593279288", 1);

// Try to purchase showcase book (will fail)
double total3 = inventory.buyBooks("978-0131103627", 1);
```

### Managing Inventory
```java
// Display all books
inventory.displayInventory();

// Remove outdated books (published before 2015)
int removedCount = inventory.removeOutdatedBooks(2015);

// Find specific book
Book book = inventory.findBookByIsbn("978-0134685991");

// Check inventory size
int size = inventory.getInventorySize();
```

---

## 🎯 Key Classes Overview

### Abstract Book Class
- **Purpose**: Base class for all book types
- **Key Methods**: `deliver()`, `canPurchase()`, `purchase()`
- **Properties**: ISBN, title, publish year, price, author

### PaperBook Class
- **Inheritance**: Extends `Book`
- **Special Features**: Stock management, shipping delivery
- **Behavior**: Stock decreases on purchase, uses `ShippingService`

### EBook Class
- **Inheritance**: Extends `Book`
- **Special Features**: File format, email delivery
- **Behavior**: Unlimited stock, uses `MailService`

### ShowcaseBook Class
- **Inheritance**: Extends `Book`
- **Special Features**: Display-only, cannot be purchased
- **Behavior**: Always returns false for `canPurchase()`

### InventoryManager Class
- **Purpose**: Core business logic for inventory management
- **Key Methods**: `addBook()`, `buyBooks()`, `removeOutdatedBooks()`
- **Features**: Validation, error handling, reporting

---

## 🧪 Test Coverage

The `QuantumBookstoreFullTest` class demonstrates:

1. ✅ Adding different types of books
2. ✅ Successful purchases with stock management
3. ✅ Failed purchase attempts (various scenarios)
4. ✅ Removing outdated books by year
5. ✅ Inventory display and management
6. ✅ Error handling and validation

---

## 🔮 Future Enhancements

- 🛒 Shopping cart functionality
- 💳 Payment processing integration
- 👤 User account management
- 📊 Sales reporting and analytics
- 🔍 Advanced search and filtering
- 📱 Mobile app compatibility
- 🌐 Web interface
- 💾 Database persistence

---

## 👨‍💻 Development Notes

- **Java Version**: Compatible with Java 8+
- **Dependencies**: None (pure Java)
- **Testing**: Manual testing via main method
- **Architecture**: Object-oriented with clear separation of concerns
- **Extensibility**: Easy to add new book types or services

---

## 📝 License

This project is created for educational purposes and demonstrates object-oriented programming concepts in Java.

---

**Happy Coding! 🚀**
