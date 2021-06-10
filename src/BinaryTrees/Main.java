package BinaryTrees;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        String stringData = "1 2 3 4 5 6 7 5 8";

        String[] data = stringData.split(" ");
        for (String s : data) {
            binaryTree.add(new TreeNode(s));
        }
        binaryTree.traverse(binaryTree.getRoot());

        System.out.println("\n\nAfter removal");
        binaryTree.remove(new TreeNode("8"));
        binaryTree.traverse(binaryTree.getRoot());

        System.out.println("\n\nAfter removal");
        binaryTree.remove(new TreeNode("1"));
        binaryTree.traverse(binaryTree.getRoot());
    }
}
