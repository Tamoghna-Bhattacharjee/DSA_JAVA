package BinaryTrees;

public abstract class Tree_Operation {
    public abstract TreeNode getRoot();
    //outside the package it can't be accessed
    protected abstract boolean setRoot(TreeNode node);

    public abstract boolean add(TreeNode node);
    public abstract boolean remove(TreeNode node);
    //public abstract void remove(TreeNode removingNode , TreeNode parent);
    public abstract void traverse(TreeNode root);
}
