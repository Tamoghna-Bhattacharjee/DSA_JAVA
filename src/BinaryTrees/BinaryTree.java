package BinaryTrees;

public class BinaryTree extends Tree_Operation{

    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    @Override
    public TreeNode getRoot() {
        return this.root;
    }

    @Override
    protected boolean setRoot(TreeNode node) {
        if(node != null) {
            this.root = node;
            return true;
        }
        return false;
    }

    //addition algorithm for ordered binary tree
    //if node < current attach with left else right
    @Override
    public boolean add(TreeNode node) {
        if(node != null){
            TreeNode current = this.root;
            if(current == null){
                this.root = node;
                return true;
            }

            int compare;
            //Basic algorithm: if node < current attach with left else right
            while(current != null){
                compare = current.compareTo(node);

                //if node < current attach with left
                if(compare > 0){
                    if(current.left() != null)
                        current = current.left();
                    else{
                        current.setLeft(node);
                        return true;
                    }
                }
                //if node > current attach with right
                if(compare < 0){
                    if(current.right() != null)
                        current = current.right();
                    else{
                        current.setRight(node);
                        return true;
                    }
                }
                //if added item already present
                if(compare == 0){
                    System.out.println(node.getValue().toString() + " already present");
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(TreeNode node) {
        if(node != null){
            TreeNode current = this.root;
            TreeNode parent = current;

            int compare;
            while(current != null){
                compare = current.compareTo(node);

                if(compare < 0){
                    //if item searched for greater than the current move to the right
                    parent = current;
                    current = current.right();
                }else if(compare > 0){
                    //if item searched for smaller than the current move to the left
                    parent = current;
                    current = current.left();
                }else{
                    performRemoval(current , parent);
                    return true;
                }
            }
        }
        return false;
    }

    public void performRemoval(TreeNode removingNode , TreeNode parent) {

        //if removingNode have only one branch
        if(removingNode.right() == null){
            //no right branch present
            //attach parent with the left branch of removingNode
            if(parent.right() == removingNode){
                //if removingNode is with right branch of parent
                //attach right branch of parent with removingNode's left branch
                parent.setRight(removingNode.left());
                removingNode.setLeft(null);
            }
            else if(parent.left() == removingNode){
                //if removingNode is with left branch of parent
                //attach left branch of parent with removingNode's left branch
                parent.setLeft(removingNode.left());
                removingNode.setLeft(null);
            }
            else{
                //removingNode == parent i.e. removingNode is the root and contain no right branch
                //set root to the left TreeNode of the removingNode
                setRoot(removingNode.left());
                removingNode.setLeft(null);
            }
        }
        else if (removingNode.left() == null){
            //removingNode has no left branch
            //attach parent with the right branch of removingNode
            if(parent.right() == removingNode){
                //if removingNode is with right branch of parent
                //attach right branch of parent with removingNode's right branch
                parent.setRight(removingNode.right());
                removingNode.setRight(null);
            }
            else if(parent.left() == removingNode){
                //if removingNode is with left branch of parent
                //attach left branch of parent with removingNode's right branch
                parent.setLeft(removingNode.right());
                removingNode.setRight(null);
            }
            else{
                //removingNode == parent i.e. removingNode is the root and contain no left branch
                //set root to the right TreeNode of the removingNode
                //this.root = removingNode.right();
                setRoot(removingNode.right());
                removingNode.setLeft(null);
            }
        }
        else
        {
            //removing node contain both right and left branch
            /*
                Basic Algorithm:
                1.FIND THE NODE WHICH IS JUST LARGER THAN THE REMOVING NODE AND INTER CHANGE THE VALUE
                  AND DETACH THAT NODE FROM THAT NODE'S PARENT (IT MAY CONTAIN ROOT ALSO)

                    1.1. GO TO THE VERY NEXT ELEMENT OF THE RIGHT BRANCH OF REMOVING NODE
                    1.2. FROM THAT GO TO THE LAST LEFT NODE, THIS WILL GIVE THE REQUIRED NODE

                    NOTE: THE LAST LEFT NODE OF ADJACENT RIGHT BRANCH MAY CONTAIN A RIGHT BRANCH
                          SO AFTER VALUE INTERCHANGE ATTACH LEFTMOST PARENT WITH THE RIGHT BRANCH OF
                          THE LAST LEFT NODE
            */
            TreeNode current = removingNode.right();
            TreeNode leftmostParent = removingNode;

            while(current.left() != null){
                leftmostParent = current;
                current = current.left();
            }

            removingNode.setValue(current.getValue());

            if(leftmostParent == removingNode){
                removingNode.setRight(current.right());
            }else{
                leftmostParent.setLeft(current.right());
            }
        }
    }

    @Override
    public void traverse(TreeNode root) {
        if(root != null){
            traverse(root.left());
            System.out.println(root.getValue().toString());
            traverse(root.right());
        }
    }
}
