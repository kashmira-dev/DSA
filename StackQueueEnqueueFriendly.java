
package queue;

import java.util.Stack;
 
public class StackQueueEnqueueFriendly {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public StackQueueEnqueueFriendly() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

   
    public void enqueue(int x) {
        enqueueStack.push(x);
        System.out.println("Enqueued: " + x);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        
        
        if (dequeueStack.isEmpty()) {
            transferStacks();
        }
        
        int front = dequeueStack.pop();
        System.out.println("Dequeued: " + front);
        return front;
    }

   
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        
       
        if (dequeueStack.isEmpty()) {
            transferStacks();
        }
        
        return dequeueStack.peek();
    }

    
    private void transferStacks() {
        while (!enqueueStack.isEmpty()) {
            dequeueStack.push(enqueueStack.pop());
        }
    }

    
    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

   
    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }

    
    public void display() {
        System.out.print("Queue contents (front to rear): ");
        
        if (!dequeueStack.isEmpty()) {
            Stack<Integer> temp = new Stack<>();
            for (Integer element : dequeueStack) {
                temp.push(element);
            }
            while (!temp.isEmpty()) {
                System.out.print(temp.pop() + " ");
            }
        }
        
        for (Integer element : enqueueStack) {
            System.out.print(element + " ");
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();
        
        System.out.println("=== Testing StackQueueEnqueueFriendly ===");
        
        // Enqueue operations
        queue.enqueue(3);
        queue.enqueue(5);
        queue.display();
        
        // Dequeue operation
        System.out.println("Front element: " + queue.peek());
        queue.dequeue();
        queue.display();
        
        // Enqueue more
        queue.enqueue(7);
        queue.display();
        
        // Dequeue remaining
        queue.dequeue();
        queue.dequeue();
        queue.display();
        
        System.out.println("Queue size: " + queue.size());
        System.out.println("Is queue empty? " + queue.isEmpty());
        
        // Additional test to show stack behavior
        System.out.println("\n=== Additional Test ===");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.display();
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