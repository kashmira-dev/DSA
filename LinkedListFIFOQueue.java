
package queue;

public class LinkedListFIFOQueue {
    private Node front;
    private Node rear;
    private int size;
    
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public LinkedListFIFOQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public void enqueue(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        int data = front.data;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }
    
    public int peekRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return rear.data;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void reverse() {
        if (isEmpty() || size == 1) {
            return;
        }
        
        int[] stack = new int[size];
        int top = -1;
        
        Node current = front;
        while (current != null) {
            stack[++top] = current.data;
            current = current.next;
        }
        
        front = rear = null;
        size = 0;
        
        while (top >= 0) {
            enqueue(stack[top--]);
        }
    }
    
    public static void main(String[] args) {
        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();
        
        System.out.println("Peek front: " + queue.peek());
        System.out.println("Peek rear: " + queue.peekRear());
        
        System.out.println("Dequeue: " + queue.dequeue());
        queue.display();
        
        System.out.println("Size: " + queue.size());
        System.out.println("Is empty: " + queue.isEmpty());
        
        queue.reverse();
        System.out.print("After reversal: ");
        queue.display();
        
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
        
        System.out.println("Is empty: " + queue.isEmpty());
    }
}