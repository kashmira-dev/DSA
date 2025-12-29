
package queue;

public class StackQueueDequeuefriendly {
   
    private Node head;
    private Node tail;
    private int size;
    
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public StackQueueDequeuefriendly() {
        head = null;
        tail = null;
        size = 0;
    }
    
    
    public void add(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
  
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("StackQueue is empty");
        }
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }
    
   
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("StackQueue is empty");
        }
        
       
        if (head == tail) {
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }
        
       
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        
        int data = tail.data;
        tail = current;
        tail.next = null;
        size--;
        return data;
    }
    
    
    public int peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("StackQueue is empty");
        }
        return head.data;
    }
    
    
    public int peekEnd() {
        if (isEmpty()) {
            throw new IllegalStateException("StackQueue is empty");
        }
        return tail.data;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        Node current = head;
        System.out.print("StackQueue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
 
    public static void main(String[] args) {
        StackQueueDequeuefriendly sq = new StackQueueDequeuefriendly();
        
      
        sq.add(10);
        sq.add(20);
        sq.add(30);
        sq.display(); 
        
        System.out.println("Dequeue: " + sq.remove()); 
        sq.display(); 
        
        
        sq.add(40);
        sq.display(); 
        System.out.println("Pop: " + sq.pop()); 
        sq.display(); 
        
        System.out.println("Size: " + sq.size()); 
        System.out.println("Is empty: " + sq.isEmpty()); 
    }
}



/*run:
StackQueue: 10 20 30 
Dequeue: 10
StackQueue: 20 30 
StackQueue: 20 30 40 
Pop: 40
StackQueue: 20 30 
Size: 2
Is empty: false*/