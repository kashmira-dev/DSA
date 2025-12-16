package stack;

import java.util.LinkedList;
import java.util.Queue;


// Stack implementation using two queues 
 
public class QueueStackPushFriendly {
    private Queue<Integer> mainQueue;
    private Queue<Integer> tempQueue;

 // Constructor to initialize the queues
    public QueueStackPushFriendly() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(int x) {
        mainQueue.add(x);
        System.out.println("Pushed: " + x);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }

        // Move all elements except last from mainQueue to tempQueue
        while (mainQueue.size() > 1) {
            tempQueue.add(mainQueue.remove());
        }

        // Get the last element (top of stack)
        int top = mainQueue.remove();
        System.out.println("Popped: " + top);

        // Swap the queues
        Queue<Integer> swap = mainQueue;
        mainQueue = tempQueue;
        tempQueue = swap;

        return top;
    }

    /**
     * Peek operation - Similar to pop but doesn't remove element
     * @return the top element without removing it
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }

        // Move all elements except last from mainQueue to tempQueue
        while (mainQueue.size() > 1) {
            tempQueue.add(mainQueue.remove());
        }

        // Get the last element without removing it
        int top = mainQueue.peek();
        tempQueue.add(mainQueue.remove());

        // Swap the queues
        Queue<Integer> swap = mainQueue;
        mainQueue = tempQueue;
        tempQueue = swap;

        return top;
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
        QueueStackPushFriendly stack = new QueueStackPushFriendly();
        
        System.out.println("=== Testing QueueStackPushFriendly ===");
        
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

//=== Testing QueueStackPushFriendly ===
//Pushed: 3
//Pushed: 5
//Pushed: 7
//Stack contents (top to bottom): [3, 5, 7]
//Top element: 7
//Popped: 7
//Stack contents (top to bottom): [3, 5]
//Pushed: 9
//Stack contents (top to bottom): [3, 5, 9]
//Popped: 9
//Popped: 5
//Stack contents (top to bottom): [3]
//Stack size: 1
//Is stack empty? false