import java.util.*;

/**
 * A program that maintains a sorted stack of integers.
 * This class has been MAINTAINED from SortedIntegerList to use Stack instead of LinkedList.
 * 
 * <p>MAINTENANCE NOTES: This class was adapted from SortedIntegerList (Project #4).
 * The primary change is the underlying data structure from LinkedList to Stack,
 * while preserving the sorted order functionality.</p>
 * 
 * <p>The program continuously reads integers from standard input
 * and maintains them in ascending order within a Stack structure.</p>
 * 
 * <p><b>Usage:</b> Run from command line and input integers.
 * Type 'quit' to stop input and display the sorted stack.</p>
 * 
 * <p><b>Design Challenge:</b> Stacks are LIFO structures, so maintaining
 * sorted order requires using a temporary stack during insertion.</p>
 * 
 * @author Jose Mondragon
 * @version 2.0 (Maintained from version 1.0)
 * @since 2025-06-10
 */
public class SortedIntegerStack {
    
    /** 
     * The main stack that stores integers in sorted order.
     * MAINTENANCE: Changed from LinkedList<Integer> to Stack<Integer>
     */
    private Stack<Integer> sortedStack;
    
    /** Scanner for reading user input (no changes) */
    private Scanner scanner;
    
    /**
     * Constructs a new SortedIntegerStack with an empty stack.
     * MAINTENANCE: Updated to initialize Stack instead of LinkedList.
     */
    public SortedIntegerStack() {
        this.sortedStack = new Stack<>();
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Inserts an integer into the stack while maintaining sorted order.
     * 
     * <p>MAINTENANCE: Completely redesigned algorithm due to Stack's LIFO nature.
     * Uses a temporary stack to maintain sorted order during insertion.</p>
     * 
     * <p>Algorithm:
     * 1. Pop elements larger than the new value to a temporary stack
     * 2. Push the new value
     * 3. Push back all elements from the temporary stack</p>
     * 
     * @param value the integer to be inserted
     */
    public void insertSorted(Integer value) {
        // MAINTENANCE: New algorithm required for Stack's LIFO constraint
        
        // If stack is empty, simply push the element
        if (sortedStack.isEmpty()) {
            sortedStack.push(value);
            return;
        }
        
        // Create temporary stack to hold elements during reorganization
        // This is new code required due to Stack's limitations
        Stack<Integer> tempStack = new Stack<>();
        
        // Pop all elements greater than the value to insert
        // This maintains ascending order from bottom to top
        while (!sortedStack.isEmpty() && sortedStack.peek() > value) {
            tempStack.push(sortedStack.pop());
        }
        
        // Push the new value at the correct position
        sortedStack.push(value);
        
        // Push back all elements from temporary stack
        // This restores the larger elements above the new value
        while (!tempStack.isEmpty()) {
            sortedStack.push(tempStack.pop());
        }
    }
    
    /**
     * Displays the current sorted stack to the console.
     * MAINTENANCE: Updated to work with Stack's iteration order.
     * 
     * <p>Note: Stack iteration shows elements from bottom to top,
     * which displays our sorted order correctly (smallest to largest).</p>
     */
    public void displayStack() {
        System.out.println("\n=== Sorted Integer Stack ===");
        
        if (sortedStack.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("Size: " + sortedStack.size());
            // MAINTENANCE: Direct iteration works because Stack extends Vector
            System.out.println("Elements (bottom to top): " + sortedStack);
            
            // MAINTENANCE: Using Collections methods still works with Stack
            System.out.println("Minimum: " + Collections.min(sortedStack));
            System.out.println("Maximum: " + Collections.max(sortedStack));
            System.out.println("Top element (largest): " + sortedStack.peek());
        }
        
        System.out.println("===========================\n");
    }
    
    /**
     * Validates if a string can be parsed as an integer.
     * MAINTENANCE: This method remains unchanged - good code reuse!
     * 
     * @param input the string to validate
     * @return true if the input can be parsed as an integer, false otherwise
     */
    private boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Main interaction loop that reads user input and processes commands.
     * MAINTENANCE: Core logic preserved, only display method name changed.
     */
    public void run() {
        // MAINTENANCE: Updated program name in welcome message
        System.out.println("=== Sorted Integer Stack Program ===");
        System.out.println("Enter integers to add to the sorted stack.");
        System.out.println("Commands:");
        System.out.println("  - Enter any integer to add it to the stack");
        System.out.println("  - Type 'show' to display the current stack");
        System.out.println("  - Type 'quit' to exit and display final stack");
        System.out.println("====================================\n");
        
        String input;
        
        while (true) {
            System.out.print("Enter input: ");
            input = scanner.nextLine().trim();
            
            // Check for exit command (unchanged)
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            
            // Check for show command (method name updated)
            if (input.equalsIgnoreCase("show")) {
                displayStack();  // MAINTENANCE: Changed from displayList()
                continue;
            }
            
            // Validate and process integer input (logic unchanged)
            if (isValidInteger(input)) {
                Integer value = Integer.parseInt(input);
                insertSorted(value);
                System.out.println("Added " + value + " to the sorted stack.");
            } else {
                System.out.println("Invalid input. Please enter an integer, 'show', or 'quit'.");
            }
        }
        
        // Display final stack before exiting
        System.out.println("\nFinal sorted stack:");
        displayStack();  // MAINTENANCE: Changed from displayList()
        
        // Clean up resources (unchanged)
        scanner.close();
    }
    
    /**
     * Main method - entry point of the program.
     * MAINTENANCE: Only class name changed in instantiation.
     * 
     * @param args command line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        SortedIntegerStack program = new SortedIntegerStack();
        program.run();
    }
    
    /**
     * Utility method to get a copy of the sorted stack.
     * MAINTENANCE: Updated to return Stack instead of LinkedList.
     * Uses Stack's copy constructor for defensive copying.
     * 
     * @return a new Stack containing all elements in sorted order
     */
    public Stack<Integer> getSortedStackCopy() {
        // MAINTENANCE: Stack has a copy constructor like LinkedList
        return new Stack<Integer>() {{
            addAll(sortedStack);
        }};
    }
    
    /**
     * Clears all elements from the sorted stack.
     * MAINTENANCE: Stack inherits clear() from Vector, so no change needed.
     */
    public void clearStack() {
        sortedStack.clear();
    }
    
    /**
     * Checks if a specific value exists in the sorted stack.
     * MAINTENANCE: Updated to use Stack's search() method.
     * 
     * @param value the integer to search for
     * @return true if the value exists in the stack, false otherwise
     */
    public boolean contains(Integer value) {
        // MAINTENANCE: Stack's search() returns -1 if not found
        // This is different from binarySearch, but serves the same purpose
        return sortedStack.search(value) != -1;
    }
    
    /**
     * Returns the number of elements in the sorted stack.
     * MAINTENANCE: Method unchanged - Stack has size() like LinkedList.
     * 
     * @return the size of the sorted stack
     */
    public int size() {
        return sortedStack.size();
    }
}
