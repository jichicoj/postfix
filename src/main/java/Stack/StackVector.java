package Stack;

import java.util.Vector;

public class StackVector<E> extends AbstrackStack<E> {

    private Vector<E> data;

    /**
     * Constructor
     */
    public StackVector() {
        data = new Vector<E>();
    }

    /**
     * Add an item to the stack. Will be popped next.
     *
     * @param item
     */
    @Override
    public void add(E item) {
        data.add(item);
    }

    /**
     * If the Stack.Stack is not empty, the most recent item will be removed and returned.
     *
     * @return Item
     */
    @Override
    public E remove() {
        return data.remove(size() - 1);
    }

    /**
     * Get the current Item on the Stack.Stack (without popping it).
     *
     * @return Item
     */
    @Override
    public E peek() {
        return data.get(size() - 1);
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

    /**
     * Get the size of the Stack.Stack.
     *
     * @return Integer indicating the size of the Stack.Stack
     */
    @Override
    public int size() {
        return data.size();
    }
}
