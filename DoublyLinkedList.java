
package linkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    private class Node {
        int data;
        Node prev;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
  
    public void addFirst(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
   
    public void addLast(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    
    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        if (index == size) {
            addLast(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current;
        
       
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }
    
  
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        int data = head.data;
        
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }
    
   
    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        int data = tail.data;
        
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }
    
   
    public int removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        if (index == 0) {
            return removeFirst();
        }
        
        if (index == size - 1) {
            return removeLast();
        }
        
        Node current;
        
      
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        
        int data = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return data;
    }
    
   
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        Node current;
        
      
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        
        return current.data;
    }
    
  
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    
    public void displayForward() {
        Node current = head;
        System.out.print("Doubly Linked List (Forward): ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
   
    public void displayBackward() {
        Node current = tail;
        System.out.print("Doubly Linked List (Backward): ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
   
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        list.addFirst(10);
        list.addLast(30);
        list.addAt(1, 20);
        list.addLast(40);
        list.displayForward(); 
        list.displayBackward(); 
        
        System.out.println("Get at index 2: " + list.get(2)); 
        System.out.println("Contains 20: " + list.contains(20)); 
        
        System.out.println("Remove first: " + list.removeFirst()); 
        list.displayForward();
        
        System.out.println("Remove last: " + list.removeLast()); 
        list.displayForward(); 
        
        System.out.println("Remove at index 1: " + list.removeAt(1));
        list.displayForward(); 
        
        System.out.println("Size: " + list.size()); 
        System.out.println("Is empty: " + list.isEmpty()); 
    }
}


/*run:
Doubly Linked List (Forward): 10 <-> 20 <-> 30 <-> 40 <-> null
Doubly Linked List (Backward): 40 <-> 30 <-> 20 <-> 10 <-> null
Get at index 2: 30
Contains 20: true
Remove first: 10
Doubly Linked List (Forward): 20 <-> 30 <-> 40 <-> null
Remove last: 40
Doubly Linked List (Forward): 20 <-> 30 <-> null
Remove at index 1: 30
Doubly Linked List (Forward): 20 <-> null
Size: 1
Is empty: false*/