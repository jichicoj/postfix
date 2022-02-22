package Stack.Lists;

public class SinglyList<E> extends AbstractList<E> {
    public class Node {
        private E value;
        private Node link;
    }

    Node top = null;
    /**
     * Add an item to the stack. Will be popped next.
     *
     * @param num
     */
    @Override
    public void add(E num) {
        Node temp = new Node();

        if (temp == null) {
            System.out.println("\nHeap Overflow");
            return;
        }

        temp.value = num;
        temp.link = top;
        top = temp;
    }

    /**
     * If the Stack.Stack is not empty, the most recent item will be removed and returned.
     *
     * @return Item
     */
    @Override
    public E remove() {
        if (top == null) {
            System.out.print("\nStack Underflow");
            return null;
        }

        if (top.link == null) {
            return null;
        }

        Node un_top = top;

        while (un_top.link.link != null) {
            un_top = un_top.link;
        }

        un_top.link = null;
        return top.value;
    }

    /**
     * Get the current Item on the Stack.Stack (without popping it).
     *
     * @return Item
     */
    @Override
    public E peek() {
        if (!empty()) {
            return top.value;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    /**
     * Check if the Stack.Stack is empty.
     *
     * @return Boolean indicating if the Stack.Stack is empty
     */
    @Override
    public boolean empty() {
        return top == null;
    }

    /**
     * Get the size of the Stack.Stack.
     *
     * @return Integer indicating the size of the Stack.Stack
     */
    @Override
    public int size() {
        return 0;
    }
}
