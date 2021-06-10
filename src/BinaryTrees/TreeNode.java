package BinaryTrees;

public class TreeNode {
    protected TreeNode left;
    protected TreeNode right;
    protected Object value;

    public TreeNode(Object value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode left(){
        return this.left;
    }

    public TreeNode right(){
        return this.right;
    }

    public TreeNode setLeft(TreeNode node){
        this.left = node;
        return this.left;
    }

    public TreeNode setRight(TreeNode node){
        this.right = node;
        return this.right;
    }

    public int compareTo(TreeNode node){

        if(node != null)
            return this.value.toString().compareTo(node.value.toString());
        else
            return -1;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
