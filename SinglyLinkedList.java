
package linkedlist;


public class SinglyLinkedList {
    private Node head;
    private int size;
    
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
  
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    // Add at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
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
        
        Node newNode = new Node(data);
        Node current = head;
        
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
  
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
   
    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        if (size == 1) {
            return removeFirst();
        }
        
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        int data = current.next.data;
        current.next = null;
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
        
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        int data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }
    
   
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
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
    
   
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        Node current = head;
        System.out.print("Singly Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
   
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addAt(1, 15);
        list.display(); 
        
        System.out.println("Get at index 2: " + list.get(2)); 
        System.out.println("Contains 15: " + list.contains(15)); 
        
        System.out.println("Remove first: " + list.removeFirst()); 
        list.display(); 
        
        System.out.println("Remove last: " + list.removeLast()); 
        list.display(); 
        
        list.reverse();
        list.display(); 
        
        System.out.println("Size: " + list.size()); 
        System.out.println("Is empty: " + list.isEmpty()); 
    }
}


/*run:
Singly Linked List: 10 -> 15 -> 20 -> 30 -> null
Get at index 2: 20
Contains 15: true
Remove first: 10
Singly Linked List: 15 -> 20 -> 30 -> null
Remove last: 30
Singly Linked List: 15 -> 20 -> null
Singly Linked List: 20 -> 15 -> null
Size: 2
Is empty: false*/