package Stack;

import Stack.Lists.ListFactory;
import Stack.Lists.Lists;

public class StackFactory<E> {
    public Stack<E> getStack(String stack, String list) {
        switch (stack) {
            case "A":
                return new StackArrayList<E>();
            default:
                return new StackVector<E>();
        }
    }
}
