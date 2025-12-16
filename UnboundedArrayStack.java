
package stack;


 // Stack implementation using dynamic array that resizes as needed
 // Grows by doubling when full, shrinks by halving when quarter full
 
public class UnboundedArrayStack {
    private int[] stackArray;
    private int top;
    private int capacity;
    private static final int INITIAL_CAPACITY = 2;

    // Constructor to initialize the stack
    public UnboundedArrayStack() {
        capacity = INITIAL_CAPACITY;
        stackArray = new int[capacity];
        top = -1; // Stack is initially empty
    }

    
     // Push operation - O(1) amortized
     //  x - element to be pushed
     
    public void push(int x) {

        if (isFull()) {           // Check if array needs to be resized
            resize(capacity * 2); // Double the capacity
        }
        
        stackArray[++top] = x;
        System.out.println("Pushed: " + x + " (capacity: " + capacity + ")");
    }

    
     // Pop operation - O(1) amortized
     // @return the top element of stack
     
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        
        int value = stackArray[top--];
        
        // Shrink array if it's only quarter full
        if (top + 1 <= capacity / 4 && capacity > INITIAL_CAPACITY) {
            resize(capacity / 2);
        }
        
        System.out.println("Popped: " + value + " (capacity: " + capacity + ")");
        return value;
    }

    
     //Peek operation - O(1)
     //@return the top element without removing it
     
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stackArray[top];
    }

    /**
     * Check if stack is empty
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    
     // Check if stack is full
     // @return true if stack is full, false otherwise
     
    private boolean isFull() {
        return top == capacity - 1;
    }

    
     // Resize the array to new capacity
     // @param newCapacity - new size of array
     
    private void resize(int newCapacity) {
        System.out.println("Resizing array from " + capacity + " to " + newCapacity);
        
        int[] newArray = new int[newCapacity];
        
        // Copy elements to new array
        for (int i = 0; i <= top; i++) {
            newArray[i] = stackArray[i];
        }
        
        stackArray = newArray;
        capacity = newCapacity;
    }

    
     // Get the size of stack
     // @return number of elements in stack
    
    public int size() {
        return top + 1;
    }

    /**
     * Get current capacity of array
     * @return current array capacity
     */
    public int getCapacity() {
        return capacity;
    }

    
     // Display stack contents
     
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        
        System.out.print("Stack contents (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println("(size: " + size() + ", capacity: " + capacity + ")");
    }

    // Main method for testing
    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();
        
        System.out.println("=== Testing UnboundedArrayStack ===");
        
        // Test push operations with automatic resizing
        System.out.println("\nPushing elements (watch resizing):");
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        stack.display();
        
        // Test pop operations with automatic shrinking
        System.out.println("\nPopping elements (watch shrinking):");
        while (stack.size() > 2) {
            stack.pop();
            stack.display();
        }
        
        // Test edge cases
        System.out.println("\nTop element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Current capacity: " + stack.getCapacity());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

//output

//=== Testing StackQueueEnqueueFriendly ===
//Enqueued: 3
//Enqueued: 5
//Queue contents (front to rear): 3 5 
//Front element: 3
//Dequeued: 3
//Queue contents (front to rear): 5 
//Enqueued: 7
//Queue contents (front to rear): 5 7 
//Dequeued: 5
//Dequeued: 7
//Queue contents (front to rear): 
//Queue size: 0
//Is queue empty? true
//
//=== Additional Test ===
//Enqueued: 1
//Enqueued: 2
//Enqueued: 3
//Dequeued: 1
//Enqueued: 4
//Queue contents (front to rear): 2 3 4