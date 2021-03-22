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
        Node node = bst.deleteNode( 5);
        bst.printTree(node);
        bst.inOrder(node);

        System.out.println();
        System.out.println("Print the tree in pre-order, root, left, right");
        bst.preOrder(node);

        System.out.println();
        System.out.println("Print the tree in post-order, left, right, root");
        bst.postOrder(node);

        System.out.println();
        System.out.println("the height of the tree, root to leaf");
        int h = bst.findHeight(bst.getRoot());
        System.out.println(h);

        System.out.println();
        System.out.println("the height of the tree, root to leaf");
        int h1 = bst.findH(bst.getRoot());
        System.out.println(h1);


        System.out.println();
        System.out.println("Find the kth ancestors");
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(6);
        binarySearchTree.add(4);
        binarySearchTree.add(9);
        binarySearchTree.add(2);
        binarySearchTree.add(5);
        binarySearchTree.add(8);
        binarySearchTree.add(12);
        binarySearchTree.add(10);
        binarySearchTree.add(14);

        binarySearchTree.inOrder(binarySearchTree.getRoot());
        System.out.println();
        List<Integer> result = binarySearchTree.findAncestor(10);
        result.forEach(System.out::println);

        System.out.println();
        Node re = binarySearchTree.findLCA(binarySearchTree.getRoot(), 4, 14);
        System.out.println(re.getData());

        System.out.println();
        binarySearchTree.printKNodes(binarySearchTree.getRoot(), 2);
    }


}
