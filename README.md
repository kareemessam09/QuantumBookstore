# 📚 Quantum Book Store

**Quantum Book Store** is a comprehensive Java application that simulates an online bookstore management system. This project demonstrates object-oriented programming principles including inheritance, polymorphism, abstraction, and exception handling.

---

## 🚀 Features

### 📖 Book Management
- **Multiple Book Types**: Support for different book formats
  - [`PaperBook`](models/PaperBook.java): Physical books with stock management
  - [`EBook`](models/EBook.java): Digital books with file format support
  - [`ShowcaseBook`](models/ShowcaseBook.java): Display-only books (not for sale)

### 🛒 Inventory Operations
- Add books to inventory with validation
- Purchase books with automatic stock management
- Remove outdated books based on publication year
- Display complete inventory with detailed information
- Duplicate book prevention

### 🚚 Delivery Services
- **Physical Books**: Automated shipping via [`ShippingService`](services/ShippingService.java)
- **Digital Books**: Email delivery via [`MailService`](services/MailService.java)
- **Showcase Books**: No delivery (display only)

### 🔧 Exception Handling
- [`InvalidInputException`](exceptions/InvalidInputException.java): Invalid parameters
- [`BookNotFoundException`](exceptions/BookNotFoundException.java): Book not in inventory
- [`InsufficientStockException`](exceptions/InsufficientStockException.java): Not enough stock
- [`BookNotForSaleException`](exceptions/BookNotForSaleException.java): Showcase books
- [`DuplicateBookException`](exceptions/DuplicateBookException.java): Duplicate ISBN

---

## 📁 Project Structure

```
QuantumBookStore/
├── models/                     # Book entity classes
│   ├── Book.java              # Abstract base class
│   ├── PaperBook.java         # Physical book implementation
│   ├── EBook.java             # Digital book implementation
│   └── ShowcaseBook.java      # Display-only book
├── services/                   # Business logic services
│   ├── InventoryManager.java  # Core inventory operations
│   ├── ShippingService.java   # Physical book delivery
│   └── MailService.java       # Digital book delivery
├── exceptions/                 # Custom exception classes
│   ├── BookStoreException.java
│   ├── InvalidInputException.java
│   ├── BookNotFoundException.java
│   ├── InsufficientStockException.java
│   ├── BookNotForSaleException.java
│   └── DuplicateBookException.java
├── QuantumBookstoreFullTest.java  # Main test application
└── README.md                  # Project documentation
```

---

## 💻 Usage Examples

### Creating Different Book Types

```java
// Create inventory manager
InventoryManager inventory = new InventoryManager();

// Add a physical book with stock
PaperBook javaBook = new PaperBook(
    "978-0134685991",
    "Effective Java",
    2018,
    45.99,
    "Joshua Bloch",
    15  // initial stock
);

// Add a digital book
EBook pythonBook = new EBook(
    "978-1593279288",
    "Python Programming",
    2019,
    29.99,
    "Al Sweigart",
    "PDF"  // file format
);

// Add a showcase book (not for sale)
ShowcaseBook showcaseBook = new ShowcaseBook(
    "978-0131103627",
    "The C Programming Language",
    1988,
    89.99,
    "Brian Kernighan & Dennis Ritchie"
);
```

### Inventory Operations

```java
// Add books to inventory
try {
    inventory.addBook(javaBook);
    inventory.addBook(pythonBook);
    inventory.addBook(showcaseBook);
} catch (InvalidInputException | DuplicateBookException e) {
    System.out.println("Error: " + e.getMessage());
}

// Purchase books
try {
    double total = inventory.buyBooks("978-0134685991", 2);
    System.out.println("Total paid: $" + total);
} catch (Exception e) {
    System.out.println("Purchase failed: " + e.getMessage());
}

// Remove outdated books
int removedCount = inventory.removeOutdatedBooks(2015);
```

---

## 🏗️ Design Patterns & Principles

### Object-Oriented Design
- **Inheritance**: All book types extend the abstract [`Book`](models/Book.java) class
- **Polymorphism**: Different delivery methods for each book type
- **Abstraction**: Abstract methods for `purchase()`, `canPurchase()`, and `deliver()`
- **Encapsulation**: Private fields with controlled access via getters/setters

### Exception Handling
- Custom exception hierarchy extending [`BookStoreException`](exceptions/BookStoreException.java)
- Specific exceptions for different error scenarios
- Proper error messages with context

### Service Layer
- [`InventoryManager`](services/InventoryManager.java): Core business logic
- [`ShippingService`](services/ShippingService.java): Physical delivery simulation
- [`MailService`](services/MailService.java): Digital delivery simulation

---

## 🧪 Testing

The [`QuantumBookstoreFullTest`](QuantumBookstoreFullTest.java) class provides comprehensive testing:

1. **Book Addition**: Tests adding various book types
2. **Inventory Display**: Shows current inventory status
3. **Successful Purchases**: Tests valid purchase scenarios
4. **Failed Purchases**: Tests error handling for invalid operations
5. **Outdated Book Removal**: Tests cleanup functionality
6. **Final Status**: Shows inventory after all operations

### Test Coverage
- ✅ All book types (Paper, E-Book, Showcase)
- ✅ All exception scenarios
- ✅ Stock management for physical books
- ✅ Unlimited availability for digital books
- ✅ Showcase book restrictions
- ✅ Input validation

---

## 📊 Sample Output

```
============================================================
     WELCOME TO QUANTUM BOOK STORE 
============================================================

TEST 1: Adding Books to Inventory
Quantum book store: Added book to inventory: Effective Java
Quantum book store: Added book to inventory: Design Patterns
...

TEST 3: Successful Book Purchases
Purchasing 2 copies of Effective Java:
Quantum book store: Successfully purchased 2 copies of Effective Java
Quantum book store: Remaining stock: 13
...
```

---
### Key Classes

| Class | Purpose | Key Methods |
|-------|---------|-------------|
| [`Book`](models/Book.java) | Abstract base class | `purchase()`, `canPurchase()`, `deliver()` |
| [`InventoryManager`](services/InventoryManager.java) | Core business logic | `addBook()`, `buyBooks()`, `removeOutdatedBooks()` |
| [`ShippingService`](services/ShippingService.java) | Physical delivery | `ship()`, `generateTrackingNumber()` |
| [`MailService`](services/MailService.java) | Digital delivery | `sendEmail()`, `sendNotification()` |

