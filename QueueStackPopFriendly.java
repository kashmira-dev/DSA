
package stack;


import java.util.LinkedList;
import java.util.Queue;

 // Stack implementation using two queues 

public class QueueStackPopFriendly {
    private Queue<Integer> mainQueue;
    private Queue<Integer> tempQueue;

    // Constructor to initialize the queues
    public QueueStackPopFriendly() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    /**
     * Push operation - Less efficient (O(n))
     * Add new element to empty queue, then move all elements from mainQueue
     * @param x - element to be pushed
     */
    public void push(int x) {
        // Add new element to empty queue
        tempQueue.add(x);
        System.out.println("Pushed: " + x);
        
        // Move all elements from mainQueue to tempQueue
        while (!mainQueue.isEmpty()) {
            tempQueue.add(mainQueue.remove());
        }
        
        // Swap the queues
        Queue<Integer> swap = mainQueue;
        mainQueue = tempQueue;
        tempQueue = swap;
    }

    /**
     * Pop operation - Efficient (O(1))
     * Simply remove from front of mainQueue
     * @return the top element of stack
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        
        int top = mainQueue.remove();
        System.out.println("Popped: " + top);
        return top;
    }

    /**
     * Peek operation - Efficient (O(1))
     * @return the top element without removing it
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return mainQueue.peek();
    }

    /**
     * Check if stack is empty
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    /**
     * Get the size of stack
     * @return number of elements in stack
     */
    public int size() {
        return mainQueue.size();
    }

    /**
     * Display stack contents
     */
    public void display() {
        System.out.println("Stack contents (top to bottom): " + mainQueue);
    }

    // Main method for testing
    public static void main(String[] args) {
        QueueStackPopFriendly stack = new QueueStackPopFriendly();
        
        System.out.println("=== Testing QueueStackPopFriendly ===");
        
        // Push operations
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.display();
        
        // Pop operations
        System.out.println("Top element: " + stack.peek());
        stack.pop();
        stack.display();
        
        // Push more
        stack.push(9);
        stack.display();
        
        // Pop remaining
        stack.pop();
        stack.pop();
        stack.display();
        
        System.out.println("Stack size: " + stack.size());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

//output

//=== Testing QueueStackPopFriendly ===
//Pushed: 3
//Pushed: 5
//Pushed: 7
//Stack contents (top to bottom): [7, 5, 3]
//Top element: 7
//Popped: 7
//Stack contents (top to bottom): [5, 3]
//Pushed: 9
//Stack contents (top to bottom): [9, 5, 3]
//Popped: 9
//Popped: 5
//Stack contents (top to bottom): [3]
//Stack size: 1
//Is stack empty? false