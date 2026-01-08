
package tree;

class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;

    BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int min = root.key;
        while (root.left != null) {
            root = root.left;
            min = root.key;
        }
        return min;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (key < root.key)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}

public class BinarySearchTree {

    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal:");
        tree.inorder();

        tree.delete(20);
        tree.delete(30);

        System.out.println("Inorder traversal after deletion:");
        tree.inorder();

        int searchKey = 70;
        System.out.println("Is " + searchKey + " present? " + tree.search(searchKey));

        System.out.println("Preorder traversal:");
        tree.preorder();

        System.out.println("Postorder traversal:");
        tree.postorder();
    }
}
/*
run:
Inorder traversal:
20 30 40 50 60 70 80 
Inorder traversal after deletion:
40 50 60 70 80 
Is 70 present? true
Preorder traversal:
50 40 70 60 80 
Postorder traversal:
40 60 80 70 50
*/
