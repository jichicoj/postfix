package Stack.Lists;

public class ListFactory<E> {
    public Lists<E> getList(String entry) {
        if (entry.equals("S")) {
            return new SinglyList<E>();
        } else {
            return new DoubleList<E>();
        }
    }
}
