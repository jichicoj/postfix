package Stack.Lists;

public interface Lists<E> {
    /**
     * Add an item to the stack. Will be popped next.
     * @param item
     */
    void add(E item);

    /**
     * If the Stack.Stack is not empty, the most recent item will be removed and returned.
     * @return Item
     */
    E remove();

    /**
     * Get the current Item on the Stack.Stack (without popping it).
     * @return Item
     */
    E peek();

    /**
     * Check if the Stack.Stack is empty.
     * @return Boolean indicating if the Stack.Stack is empty
     */
    boolean empty();

    /**
     * Get the size of the Stack.Stack.
     * @return Integer indicating the size of the Stack.Stack
     */
    int size();
}
