package List;

public class MyLinkedList implements Operation {

    protected Node root;

    public MyLinkedList() {
        this.root = null;
    }

    @Override
    public Node getRoot() {
        return this.root;
    }

    @Override
    public boolean setRoot(Node item) {
        if(this.root == null && item != null){
            this.root = item;
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Node item) {
        if(item !=null) {
            //System.out.println(item.getValue());
            Node current = this.root;
            int compare;

            if (current == null) {
                this.root = item;
                return true;
            }

            //addition when the list contain only one element
            if (current.next() == null && current.previous() == null) {
                compare = current.compareTo(item);
                if (compare == 0) {
                    System.out.println(item.getValue() + " already added");
                    return false;
                }
                if (compare > 0) {
                    current.setPrevious(item).setNext(current);
                    this.root = item;
                }
                else
                    current.setNext(item).setPrevious(current);

                return true;
            }

            //addition when the list contain more than 1 element
            while (current.next() != null){
                compare = current.compareTo(item);

                //no addition since already present
                if(compare == 0){
                    System.out.println(item.getValue() + " already added");
                    return false;
                }

                //list contain more than 1 items and new node addition done before the 1st one
                if(compare > 0 && current.previous() == null){
                    current.setPrevious(item).setNext(current);
                    this.root = item;
                    return true;
                }

                //addition of new node b/w 1st and last
                if(compare > 0 && current.previous() != null){
                    current.previous().setNext(item).setPrevious(current.previous());
                    current.setPrevious(item).setNext(current);
                    return true;
                }
                current = current.next();
            }

            //adding before or after last element
            compare = current.compareTo(item);
            if(current.next() == null && current.previous() != null){

                if(compare == 0){
                    System.out.println(item.getValue() + " already added");
                    return false;
                }

                //adding before last element
                if(compare > 0){
                    current.previous().setNext(item).setPrevious(current.previous());
                    current.setPrevious(item).setNext(current);
                    return true;
                }

                //adding after last element
                current.setNext(item).setPrevious(current);
                return true;

            }
            return false;
        }
        return false;
    }

    @Override
    public boolean remove(Object value) {
        if(value != null) {

            Node current = this.root;
            //No removal can be done in an empty list.
            if (current == null) {
                System.out.println("List is empty");
                return false;
            }

            boolean isPresent = current.getValue().equals(value);
            //list contain only one node that is to be deleted
            if(isPresent && current.next() == null &&  current.previous() == null){
                this.root = null;
                return true;
            }

            while(current.next() != null) {
                isPresent = current.getValue().equals(value);
                if(isPresent){
                    //if the node to be removed is the 1st item of the list
                    if(current.previous() == null){
                        this.root = current.next();
                        this.root.setPrevious(null);
                        current = null;
                        return true;
                    }

                    // if the node to be removed lies anywhere between 1st and last excluding those two
                    current.previous().setNext(current.next()).setPrevious(current.previous());
                    //current = null;
                    return true;
                }
                current = current.next();
            }

            //if the node to be removed is the last item of the list
            isPresent = current.getValue().equals(value);
            if(isPresent){
                current.previous().setNext(null);
                //current = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public void traverse(Node root) {
        Node current = root;
        if(current == null){
            System.out.println("List is empty");
            return;
        }

        while(current != null) {
            System.out.println(current.getValue().toString());
            current = current.next();
        }
        
    }
}
