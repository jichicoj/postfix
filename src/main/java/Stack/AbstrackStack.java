package Stack;

abstract public class AbstrackStack<E> implements Stack<E> {
    public boolean empty () {
        return size() == 0;
    }
}
