package List;

public interface Operation {
    Node getRoot();
    boolean setRoot(Node item);
    boolean add(Node item);
    boolean remove(Object item);
    void traverse(Node root);
}
