package BinarySearchTree.XuyingBinaryTree.SearchInABinarySearchTree;

import java.util.List;

public class main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(6);
        bst.add(4);
        bst.add(1);
        bst.add(5);
        bst.add(8);
        bst.add(9);

        bst.printTree(bst.getRoot());
        List<Node> nodes = bst.search(8);
        System.out.println("sjfkjselkfjs");
        System.out.println(nodes.size());
        nodes.stream().filter(s -> s !=null).forEach(s -> System.out.println(s.getData()));
        System.out.println("delete");
        Node node = bst.deleteNode(bst.getRoot(), 5);
        bst.printTree(node);
    }
}
