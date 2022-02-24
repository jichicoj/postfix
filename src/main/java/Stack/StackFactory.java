package Stack;

public class StackFactory<E> {
    public Stack<E> getStack(String stack, String list) {
        switch (stack) {
            case "A":
                return new StackArrayList<E>();
            case "L":
                return new StackList<E>(list);
            default:
                return new StackVector<E>();
        }
    }
}
