package Stack.Lists;

public class DoubleList<E> extends AbstractList<E> {
    /**
     * Add an item to the stack. Will be popped next.
     *
     * @param item
     */
    @Override
    public void add(E item) {

    }

    /**
     * If the Stack.Stack is not empty, the most recent item will be removed and returned.
     *
     * @return Item
     */
    @Override
    public E remove() {
        return null;
    }

    /**
     * Get the current Item on the Stack.Stack (without popping it).
     *
     * @return Item
     */
    @Override
    public E peek() {
        return null;
    }

    /**
     * Check if the Stack.Stack is empty.
     *
     * @return Boolean indicating if the Stack.Stack is empty
     */
    @Override
    public boolean empty() {
        return false;
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
