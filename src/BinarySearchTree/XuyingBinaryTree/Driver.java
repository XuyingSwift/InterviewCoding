package BinarySearchTree.XuyingBinaryTree;

public class Driver {
    public static void main(String[] args) {
        BST bst1 = new BST();
        bst1.add(29);
        bst1.add(38);
        bst1.add(23);

        bst1.printTree(bst1.getRoot());

        BST bst2 = new BST();
        bst2.recursive(25);
        bst2.recursive(45);
        bst2.recursive(13);

        bst2.printTree(bst2.getRoot());
        bst2.search(77);

        Node node = bst1.search1(38);
        System.out.println(node.getData());

        BST bst3 = new BST();
        bst3.add(1);
        bst3.add(2);
        bst3.add(3);
        bst3.add(4);
        bst3.add(5);
        bst3.add(6);
        bst3.add(7);

        bst3.levelOrderTraversal(bst3.getRoot());

        BST bst4 = new BST();
        bst4.add(19);
        bst4.add(17);
        bst4.add(15);
        bst4.add(13);
        bst4.add(9);
        bst4.levelOrderTraversal(bst4.getRoot());
        System.out.println();
        System.out.println(findMin(bst4.getRoot()));

        System.out.println();
        System.out.println(findMin1(bst4.getRoot()));
    }

    // finding the min value of the node
    public static int findMin(Node root) {
        if (root == null) return -1;
        // keep traversing towards left till you reach leaf node
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
        return root.getData();
    }

    // finding min using recurision
    public static int findMin1(Node root) {
        if (root == null) {
            return -1;
        } else if (root.getLeftChild() == null) {
            return root.getData();
        }else {
            return findMin1(root.getLeftChild());
        }
    }
}
