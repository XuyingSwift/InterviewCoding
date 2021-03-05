package BinarySearchTree.XuyingBinaryTree;

public class Node {
    // variables
    private int data;
    private Node leftChild;
    private Node rightChild;

    // constructor
    public Node(int data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

    // getter and setters


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
