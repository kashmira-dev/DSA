
package queue;

public class ArrayCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    
    public void enqueue(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }
    
   
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }
    
   
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }
    
   
    public int rear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Circular Queue: ");
        int count = 0;
        int i = front;
        
        while (count < size) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
            count++;
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        ArrayCircularQueue cq = new ArrayCircularQueue(5);
        
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.display(); 
        
        System.out.println("Dequeue: " + cq.dequeue()); 
        System.out.println("Dequeue: " + cq.dequeue()); 
        cq.display(); 
        
        cq.enqueue(60);
        cq.enqueue(70);
        cq.display();
        
        System.out.println("Front: " + cq.peek()); 
        System.out.println("Rear: " + cq.rear()); 
        System.out.println("Size: " + cq.size()); 
        System.out.println("Is full: " + cq.isFull()); 
    }
}



/*run:
Circular Queue: 10 20 30 40 50 
Dequeue: 10
Dequeue: 20
Circular Queue: 30 40 50 
Circular Queue: 30 40 50 60 70 
Front: 30
Rear: 70
Size: 5
Is full: true*/