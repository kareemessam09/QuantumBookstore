#!/bin/bash

# Quantum Book Store - Build and Run Script
echo "🚀 Building Quantum Book Store..."

# Compile all Java files
javac -d . models/*.java services/*.java utils/*.java *.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "✅ Compilation successful!"
    echo ""
    echo "🏃 Running the application..."
    echo ""
    java QuantumBookstoreFullTest
else
    echo "❌ Compilation failed!"
    exit 1
fi
