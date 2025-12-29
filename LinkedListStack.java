
package stack;


public class LinkedListStack {
    private Node top;
    private int size;
    
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public LinkedListStack() {
        top = null;
        size = 0;
    }
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        
        int data = top.data;
        top = top.next;
        size--;
        return data;
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }
    
 
    public boolean isEmpty() {
        return size == 0;
    }
    
  
    public int size() {
        return size;
    }
    
 
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
   
    public void reverse() {
        LinkedListStack tempStack = new LinkedListStack();
        
        while (!isEmpty()) {
            tempStack.push(pop());
        }
        
        Node current = tempStack.top;
        while (current != null) {
            push(current.data);
            current = current.next;
        }
    }
    
 
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();
        
        System.out.println("Peek: " + stack.peek()); 
        System.out.println("Pop: " + stack.pop()); 
        stack.display(); 
        
        System.out.println("Size: " + stack.size()); 
        System.out.println("Is empty: " + stack.isEmpty()); 
        
        stack.reverse();
        System.out.print("After reversal: ");
        stack.display(); 
        
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        } 
        System.out.println();
        
        System.out.println("Is empty: " + stack.isEmpty()); 
    }
}


/*run:
Stack (top to bottom): 40 30 20 10 
Peek: 40
Pop: 40
Stack (top to bottom): 30 20 10 
Size: 3
Is empty: false
After reversal: Stack (top to bottom): 30 20 10 
30 20 10 
Is empty: true*/