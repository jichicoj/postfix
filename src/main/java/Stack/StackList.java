package Stack;

import Stack.Lists.ListFactory;
import Stack.Lists.Lists;

public class StackList<E> extends AbstrackStack<E> {
    private Lists<E> data;
    private ListFactory<E> listFactory = new ListFactory<E>();

    public StackList (String type) {
        data = listFactory.getList(type);
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
        return data.remove();
    }

    /**
     * Get the current Item on the Stack.Stack (without popping it).
     *
     * @return Item
     */
    @Override
    public E peek() {
        return data.peek();
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
