package List;

public class Node {
    protected Node next;
    protected Node previous;//left node for search tree
    protected Object value;//right node for search tree

    public Node(Object value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    //getting next node in the list
    public Node next(){
        return this.next;
    }

    //getting previous node in the list
    public Node previous(){
        return this.previous;
    }

    //referencing to next node in the list
    public Node setNext(Node item){
        this.next = item;
        return this.next;
    }

    //referencing to previous node in the list
    public Node setPrevious(Node item){
        this.previous = item;
        return this.previous;
    }

    /*
        * return -1 if the item is null
        * return < 0 if item is greater than the current node, so needed to be placed later
        * return = 0 if item  = current node, no addition of this item will be done (addition code later)
        * return > 0 if item < current node  , addition of the item needed to be done before this node
        * It help to sort the list while adding
    */
    public int compareTo(Node item){

        if(item != null){
            return (this.value.toString()).compareTo(item.value.toString());
        }
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
