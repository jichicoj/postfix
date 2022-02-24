package Stack.Lists;

public class SinglyList<E> extends AbstractList<E> {
    /**
     * Add an item to the stack. Will be popped next.
     *
     * @param num
     */
    @Override
    public void add(E num) {
        Node newNode = new Node(num);
        newNode.next = null;
        if(head == null) {
            head = newNode;
            setHead(head);
        } else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        System.out.println(head);
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
