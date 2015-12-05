/**
 * Created by chelsea on 12/3/15.
 */
public class ClassNotes<E> {
    public void printAllChildren(Node node) {
        Node current = node.firstChild;

        while (current != null) {
            System.out.println(node.next);

        }
    }

    private class Node {
        E item;
        Node firstChild;
        Node next;
    }
}
