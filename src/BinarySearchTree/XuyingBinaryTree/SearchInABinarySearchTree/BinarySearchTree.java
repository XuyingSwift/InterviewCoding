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
    public Node deleteNode(int value) {
        // pointer to store the parent of the current node
        Node parent = null;

        // start with the root node
        Node current = this.root;

        // return if the key is not found in the tree;
        if (current == null){
            return null;
        }

        // search key in the bst and set its parent pointer
        while(current != null && current.getData() != value) {

            // update the parent to point to the current node
            parent = current;

            // if the given key is less than the current node, go the left sub tree
            if (value < current.getData()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        // case1: node to be deleted has no children, root or leaf node
        if(current.getLeftChild() == null && current.getRightChild() == null){

            // if the node to be deleted is not a root node, then set its parent to left and right child to null
            if (current != this.root) {
                if (parent.getLeftChild() == current) {
                    parent.setLeftChild(null);
                } else {
                    parent.setRightChild(null);
                }
            }else{
                // if the tree has only a root node, set it to null
                this.root = null;
            } // case 2: node to be deleted has two children
        } else if(current.getLeftChild() != null & current.getRightChild() != null) {
            // find its inorder successor node
            Node successor = getMinimumKey(current.getRightChild());

            // Store the successor value
            int succValue = successor.getData();

            // recursively delete the successor. note that the successor will have the most one child right child
            deleteNode(successor.getData());

            // copy value of the successor to the current node
            current.setData(succValue);
        } else { // case 3: node to be deleted has only one child
            // choose a child node
            Node child = (current.getLeftChild() != null) ? current.getLeftChild(): current.getRightChild();

            // if the node to be deleted is not a root node, set its parent to its child
            if(current != root) {
                if(current == parent.getLeftChild()) {
                    parent.setLeftChild(child);
                } else{
                    parent.setRightChild(child);
                }
            }else { // if the node to be deleted is a root node, then set to root the child
                this.root = child;
            }

        }
        return this.root;
    }

    // Helper function to find minimum value node in the subtree rooted at `curr`
    public static Node getMinimumKey(Node curr)
    {
        while (curr.getLeftChild() != null) {
            curr = curr.getLeftChild();
        }
        return curr;
    }

    /*
    *  In order traverse in a left-root-right order: we first visit the left node, then comes the turn of the root, and finally the right child
    * the following steps are required to perform in-order traversal Starting from the root node:
    * 1: traverser the left sub-tree of the current node, recursively using the InOrder() function
    * 2: visit the current node and read
    * 3: traverse the right sub-tree of currentNode, recursively using the InOrder() function
    * */

    public void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        System.out.print(node.getData() + " ");
        inOrder(node.getRightChild());
    }

    /*
    * Pre-order root-left-right order, we first visit the root/parent node and then the children, First the left child and then right one
    * 1: visit the current node and display its data
    * 2: traverse the left sub-tree of current-node, recursively using the preOrder() function
    * 3: traverse the right sub-tree of current-node, recursively using the preOrder() function
    * */

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    /*
    * Post-order traversal
    * left-right-root
    * 1: traverse the left,
    * 2: traverse the right
    * 3: traverse the root
    * */

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.print(node.getData() + " ");
    }

    public int findHeight(Node root) {

        int h = 1;
        if (root == null){
            return 0;
        }else{
            h = h +1;
            findHeight(root.getLeftChild());
            findHeight(root.getRightChild());
        }
        return h;
    }

    // Height of a node -- maximum number of connections between the node and a leaf node in its path
    // height of a tree height of its root node

    public int findH(Node root) {
        // base case
        if(root == null) {
            return  -1;
        }else {
            // root and leaf is 1
            return 1 + Math.max(findH(root.getLeftChild()), findH(root.getRightChild()));
        }
    }

}
