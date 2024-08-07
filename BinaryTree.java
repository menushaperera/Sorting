package Algorithms;

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int val) {
        data = val;
        left = null; 
        right = null;
    }
}

public class BinaryTree {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
           
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public static int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // Inorder tree traversal
    public static void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    // Preorder tree traversal
    public static void preorderTraversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Postorder tree traversal
    public static void postorderTraversal(Node root) {
        if (root == null)
            return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = null;
     
        root = insert(root, 9);
        root = insert(root, 13);
        root = insert(root, 4);
        root = insert(root, 7);
        root = insert(root, 11);
        root = insert(root, 8);
        root = insert(root, 15);
        root = insert(root, 14);
        root = insert(root, 2);
        root = insert(root, 5);

        System.out.print("Preorder: ");
        preorderTraversal(root);

        System.out.print("\nInorder: ");
        inorderTraversal(root);

        System.out.print("\nPostorder: ");
        postorderTraversal(root);

        System.out.println("\n\nDeleting 13");
        root = delete(root, 13);
        System.out.print("Inorder after deletion: ");
        inorderTraversal(root);
    }
}
