package BinarySearchTree.XuyingBinaryTree.SearchInABinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    // a binary search tree is that valueOf(leftchild) <= current < rightChild

    // variables
    private Node root;

    // constructor
    public BinarySearchTree(){}

    // getter and setters

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // insert node into the tree.
    // insert node using iterate
    public boolean add(int value) {

        // check is root is empty or not, if null, insert the node at root and return true
        if (root  == null) {
            root = new Node(value);
            return true;
        }

        // now set root as current node, we need to keep track of current node
        Node currentNode = root;

        // iterate through until reach null
        while(currentNode != null) {
            // create pointer to left and right child
            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            // we need first to compare the value with the current value, and then check null for left or right child
            // if the left child is null then insert here

            if (value < currentNode.getData()) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            }else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;

            } //end if
        } // end of while
        return false;
    }

    // search method using iterate
    public List<Node> search(int value){

        List<Node> nodes = new ArrayList<>();
        // check root is null or not
        if (root == null) {return null;}

        Node currentNode = root;
        // compare the value
        while(currentNode != null) {
          // first compare the value with current node, if they are equal
            if (value == currentNode.getData()) {
                nodes.add(currentNode);
                nodes.add(currentNode.getLeftChild());
                nodes.add(currentNode.getRightChild());
                return  nodes;
            }
          // then value is greater
            else if (value < currentNode.getData()) {
                // keep moving down and search
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
          // then value if less
        }
        // nothing found
        return null;
    }

    public void printTree(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getData() + " ");
        printTree(node.getLeftChild());
        printTree(node.getRightChild());
    }
}
