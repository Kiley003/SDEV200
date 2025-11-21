import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class Module4Exercise(3){
    public static void main(String[] args) {

    }
    private static class twoWayLinkedList<E> extends AbstractSequentialList<E>{
        private Node<E> head, tail;

        @Override
        public ListIterator<E> listIterator(int index) {
            return new ListIterator<E>() {

                private Node<E> current = head;
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public E next() {
                    E e = current.element;
                    current = current.next;
                    index++;
                    return e;
                }

                @Override
                public boolean hasPrevious() {
                    return current.previous != null;
                }

                @Override
                public E previous() {
                    current = current.previous;
                    E e = current.element;
                    return e;
                }
                @Override
                public int nextIndex() {
                    return index + 1;
                }
                @Override
                public int previousIndex() {
                    return 0;
                @Override
                public void remove() {

                }

                @Override
                public void set(E e) {
                @Override
                public void add(E e) {

                }
            }
        }

        @Override
        public int size() {
            return 0;
        }

        private static class Node<E> {
            E element;
            Node<E> next;
            Node<E> previous;

            public Node(E e) {
                element = e;
            }
        }
    }
}
