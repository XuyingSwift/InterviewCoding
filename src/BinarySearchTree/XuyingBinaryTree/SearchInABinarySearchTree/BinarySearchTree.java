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

    // function to delete a node from BST
    public Node deleteNode(Node root, int value) {

        // pointer to store the parent of the current node
        Node parent = null;
        // start with the root node
        Node current = root;

        // search key in the BST and set its parent pointer
        while(current != null && current.getData() != value) {
            // update the parent to the current node
            parent = current;

            // if the given key is lessthan the current node, go to the left sub tree
            // otherwise go the right tree
            if (value < current.getData()){
                current = current.getLeftChild();
            } else {
                current.getRightChild();
            }
        }

        // return if the key is not found in the tree
        if (current == null) {
            return root;
        }

        // Case 1: node to be deleted has no children it is a leaf node
        if (current.getLeftChild() == null && current.getRightChild() == null){
            // if the node to be deleted is not a root node, then its parent left/right child to null
            if (current != root) {
                if (parent.getLeftChild() == current){
                    parent.setLeftChild(null);
                } else {
                    parent.setRightChild(null);
                }
            }
            // if the tree has only a root, set it to null
            else{
                root = null;
            }
        }

        // case 2: node ot be deleted has two children
        else if (current.getLeftChild() != null && current.getRightChild() != null) {
            // find its inorder successor node
            Node successor = getMinimumKey(current.getRightChild());

            // store successor value
            int val = successor.getData();

            // recursiely delete the successor, note that successor will have at most one child(right child)
            deleteNode(root, successor.getData());

            current.setData(val);
        }

        // case 3: node to be dleted has only one child
        else{
            // Choose a child Node
            Node child = (current.getLeftChild() != null) ? current.getLeftChild() : current.getRightChild();

            // if the node to be deleted is not a root, set its parent to its child
            if (current != root) {
                if (current == parent.getLeftChild()) {
                    parent.setLeftChild(child);
                } else {
                    parent.setLeftChild(child);
                }
            }
            // if the node to be deleted is a root node, then set the root to the child
            else {
                root = child;
            }
        }
        return root;
    }

    // Helper function to find minimum value node in the subtree rooted at `curr`
    public static Node getMinimumKey(Node curr)
    {
        while (curr.getLeftChild() != null) {
            curr = curr.getLeftChild();
        }
        return curr;
    }
}
