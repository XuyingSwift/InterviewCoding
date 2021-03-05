package BinarySearchTree.XuyingBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    // a starting point for the tree
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // insert a node into the tree using iteration
    public boolean add(int value) {
        // the stating point is root node
        if (root == null) {
            root = new Node(value); // if the root is empty we insert the value at root
            return true;
        }

        // start with the current node
        Node currentNode = root;

        while (currentNode != null) {
            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            // check if the value is greater than current node
            // if the value is greater than current node then go to right sub
            if (value > currentNode.getData()) {
                // if right child is null, insert value here
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                // after insertion we can change the node now
                currentNode = rightChild;
            }else {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            } // end of else
        } // end of while
        return false;
    }

    public void printTree(Node root) {
        if (root == null) return;
        System.out.println(root.getData() + ",");
        printTree(root.getLeftChild());
        printTree(root.getRightChild());
    }

    // recursive function to insert a value in BST
    public Node recursive_insert(Node currentNode, int value) {

        // base case
        if (currentNode == null) {
            return new Node(value);
        }

        if (value <  currentNode.getData()) {
            // iterate left sub tree
            currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()) {
            // iterate right sub tree
            currentNode.setRightChild(recursive_insert(currentNode.getLeftChild(), value));
        } else {
            // value already exists
            return currentNode;
        }
        return currentNode;
    }

    // function to call recursive insert
    public boolean recursive(int value) {
        root = recursive_insert(this.root, value);
        return true;
    }

    public Node search(int value) {
        if (isEmpty()) return null; // if the tree is empty return null
        Node currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.getData() == value) return currentNode;
            if (currentNode.getData() > value) { // if data from current nod is greater than value
                currentNode = currentNode.getLeftChild(); // then move towards left sub tree
            } else {
                currentNode = currentNode.getRightChild();
            }
        } // end of while
        System.out.println(value + "Not Found in the tree");
        return null;
    }

    //Function to check if Tree is empty or not
    public boolean isEmpty() {
        return root == null; //if root is null then it means Tree is empty
    }

    //Wrapper function for recursive search
    public Node search1(int value) {

        if (isEmpty()) return null; // if tree is empty simply return null

        // return the output of the recursive search
        return searchRecursive(root, value);
    }

    //Recursive search function
    public Node searchRecursive(Node currentNode, int value){
        // if node is null or value is found then return node
        if (currentNode==null || currentNode.getData() == value)
            return currentNode;

        // if value is greater than node's data then search left sub-tree
        if (currentNode.getData() > value){
            return searchRecursive(currentNode.getLeftChild(), value);
        }
        else{
            // if value is less than node's data then search right sub-tree
            return searchRecursive(currentNode.getRightChild(), value);
        }
    }

    public void levelOrderTraversal(Node current) {
        if (current == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.getData() + " ");

            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }
    }

}
