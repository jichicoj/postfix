package Stack.Lists;

public class DoubleList<E> extends AbstractList<E> {
    /**
     * Add an item to the stack. Will be popped next.
     *
     * @param item
     */
    @Override
    public void add(E item) {
        Node newNode = new Node(item);
        newNode.next = null;
        newNode.previous = null;
        if(head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            newNode.previous = temp;
        }
    }

    /**
     * Check if the Stack.Stack is empty.
     *
     * @return Boolean indicating if the Stack.Stack is empty
     */
    @Override
    public boolean empty() {
        return size() == 0;
    }
}
