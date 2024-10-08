package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

// Node class to define the structure of the node
class Node {
    int data;
    Node left;
    Node right;

    // Parameterized Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    // Function to insert nodes
    public static Node insert(Node root, int data) {
        // If tree is empty, new node becomes the root
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Queue to traverse the tree and find the position to insert the node
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();

            // Insert node as the left child of the parent node
            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                q.offer(temp.left);
            }

            // Insert node as the right child of the parent node
            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                q.offer(temp.right);
            }
        }
        return root;
    }

    // Function to delete the deepest node in the tree
    public static void deleteDeepest(Node root, Node d_node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp == d_node) {
                temp = null;
                return;
            }

            if (temp.right != null) {
                if (temp.right == d_node) {
                    temp.right = null;
                    return;
                } else {
                    q.offer(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == d_node) {
                    temp.left = null;
                    return;
                } else {
                    q.offer(temp.left);
                }
            }
        }
    }

    // Function to delete a node with the given key
    public static Node deletion(Node root, int key) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null) {
            if (root.data == key)
                return null;
            else
                return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        Node temp = null;
        Node keyNode = null;

        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.data == key) {
                keyNode = temp;
            }

            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);
        }

        if (keyNode != null) {
            int deepestNodeValue = temp.data;
            keyNode.data = deepestNodeValue;
            deleteDeepest(root, temp);
        }
        return root;
    }

    // Inorder tree traversal (Left - Root - Right)
    public static void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    // Preorder tree traversal (Root - Left - Right)
    public static void preorderTraversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Postorder tree traversal (Left - Right - Root)
    public static void postorderTraversal(Node root) {
        if (root == null)
            return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

   
    public static void main(String[] args) {
        Node root = null;

        // Insertion of nodes
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
        // Display traversals
        System.out.print("Preorder traversal: ");
        preorderTraversal(root);
        System.out.print("\nInorder traversal: ");
        inorderTraversal(root);
        System.out.print("\nPostorder traversal: ");
        postorderTraversal(root);

        // Delete a node with data = 11
        root = deletion(root, 11);

        // Display traversals after deletion
        System.out.print("\nInorder traversal after deletion: ");
        inorderTraversal(root);
    }
}
