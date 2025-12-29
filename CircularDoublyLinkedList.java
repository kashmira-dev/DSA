
package linkedlist;

public class CircularDoublyLinkedList {
    private Node head;
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
    
    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;
            
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;
            
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
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
        Node current = head;
        
        for (int i = 0; i < index; i++) {
            current = current.next;
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
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
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
        
        Node tail = head.prev;
        int data = tail.data;
        
        tail.prev.next = head;
        head.prev = tail.prev;
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
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
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
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    public boolean contains(int data) {
        if (isEmpty()) {
            return false;
        }
        
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public void rotateForward() {
        if (!isEmpty()) {
            head = head.next;
        }
    }
    
    public void rotateBackward() {
        if (!isEmpty()) {
            head = head.prev;
        }
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Circular Doubly Linked List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("Circular Doubly Linked List: ");
        for (int i = 0; i < size; i++) {
            System.out.print(current.data);
            if (i < size - 1) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println(" (circular)");
    }
    
    public void displayReverse() {
        if (isEmpty()) {
            System.out.println("Circular Doubly Linked List is empty");
            return;
        }
        
        Node current = head.prev;
        System.out.print("Circular Doubly Linked List (Reverse): ");
        for (int i = 0; i < size; i++) {
            System.out.print(current.data);
            if (i < size - 1) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }
        System.out.println(" (circular)");
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        
        list.addFirst(10);
        list.addLast(30);
        list.addAt(1, 20);
        list.addLast(40);
        list.display();
        list.displayReverse();
        
        System.out.println("Get at index 2: " + list.get(2));
        System.out.println("Contains 20: " + list.contains(20));
        
        list.rotateForward();
        System.out.print("After forward rotation: ");
        list.display();
        
        System.out.println("Remove first: " + list.removeFirst());
        list.display();
        
        System.out.println("Remove last: " + list.removeLast());
        list.display();
        
        System.out.println("Size: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());
    }
}


/*run:
Circular Doubly Linked List: 10 <-> 20 <-> 30 <-> 40 (circular)
Circular Doubly Linked List (Reverse): 40 <-> 30 <-> 20 <-> 10 (circular)
Get at index 2: 30
Contains 20: true
After forward rotation: Circular Doubly Linked List: 20 <-> 30 <-> 40 <-> 10 (circular)
Remove first: 20
Circular Doubly Linked List: 30 <-> 40 <-> 10 (circular)
Remove last: 10
Circular Doubly Linked List: 30 <-> 40 (circular)
Size: 2
Is empty: false*/