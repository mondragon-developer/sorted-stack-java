# Sorted Integer Stack Program (v2.0)

## Maintenance Notice
**This is Version 2.0, maintained from the original SortedIntegerList (Project #4)**

This version demonstrates software maintenance practices by adapting the original sorted-linkedlist-java (https://github.com/mondragon-developer/sorted-linkedlist-java/tree/main) implementation to use a Stack data structure while preserving all user-facing functionality.

## What Changed in v2.0
- **Data Structure**: LinkedList → Stack
- **Insertion Algorithm**: Adapted for Stack's LIFO constraints
- **Method Names**: Updated to reflect Stack terminology
- **Everything Else**: Preserved from original implementation

## Overview
This Java program demonstrates the use of the Collections Framework to maintain a sorted stack of integers. Despite Stack's Last-In-First-Out (LIFO) nature, the program maintains elements in sorted order through a clever temporary stack algorithm.

## Features (Unchanged from v1.0)
- Interactive command-line interface
- Automatic sorting of integers
- Display functionality to view the current stack
- Input validation and error handling
- Comprehensive JavaDoc documentation

## Requirements
- Java Development Kit (JDK) 8 or higher
- Command-line terminal

## Compilation Instructions

Navigate to the project root directory and compile the Java source file:

```bash
javac -d . src/SortedIntegerStack.java
```

## Running the Program

After compilation, run the program using:

```bash
java SortedIntegerStack
```

## How to Use (Identical to v1.0)

1. The program will display a welcome message and instructions
2. Enter integers one at a time and press Enter
3. Use these commands:
   - **Any integer**: Adds the integer to the sorted stack
   - **show**: Displays the current sorted stack
   - **quit**: Exits the program and displays the final stack

### Example Session
```
=== Sorted Integer Stack Program ===
Enter integers to add to the sorted stack.
Commands:
  - Enter any integer to add it to the stack
  - Type 'show' to display the current stack
  - Type 'quit' to exit and display final stack
====================================

Enter input: 42
Added 42 to the sorted stack.
Enter input: 15
Added 15 to the sorted stack.
Enter input: 73
Added 73 to the sorted stack.
Enter input: show

=== Sorted Integer Stack ===
Size: 3
Elements (bottom to top): [15, 42, 73]
Minimum: 15
Maximum: 73
Top element (largest): 73
===========================

Enter input: quit
```

## Technical Implementation Details

### The Stack Sorting Challenge
Stacks only allow access to the top element (LIFO - Last In, First Out). To maintain sorted order, we use a temporary stack algorithm:

1. When inserting a new value, pop all larger elements to a temporary stack
2. Push the new value onto the main stack
3. Push all elements back from the temporary stack

This ensures elements remain sorted from bottom (smallest) to top (largest).

### Why This Design Works
- The bottom of the stack holds the smallest value
- The top of the stack holds the largest value
- Iteration from bottom to top shows ascending order
- The temporary stack technique maintains this order during insertions

## Generating JavaDoc Documentation

To generate the JavaDoc documentation, use:

```bash
javadoc -d docs -author -version -private src/SortedIntegerStack.java
```

## File Structure
```
SortedStackProject/
├── src/
│   └── SortedIntegerStack.java     # Maintained from SortedIntegerList.java
├── docs/                           # Generated JavaDoc files
├── README.md                       # This file
├── MAINTENANCE_LOG.md              # Details of maintenance changes
└── SortedIntegerStack.class        # Compiled class file
```

## Maintenance Benefits Demonstrated
1. **Code Reuse**: aprox 80% of original code preserved
2. **User Experience**: Identical interface and commands
3. **Design Integrity**: Core architecture maintained
4. **Documentation**: Updated to reflect changes
5. **Testing**: Original test cases still apply

## Performance Characteristics

| Operation | Time Complexity| Space Complexity | Notes |
|-----------|----------------|------------------|-------|
| Insert    | O(n)           | O(n)             | Uses temporary stack |
| Search    | O(n)           | O(1)             | Linear search in Stack |
| Display   | O(n)           | O(1)             | Iteration through stack |
| Min/Max   | O(n)           | O(1)             | Via Collections methods |

## Author
Jose Mondragon

## Version History
- 1.0 - Original implementation using LinkedList (Project #4)
- 2.0 - Maintained version using Stack (Project #5)
