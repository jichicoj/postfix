import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackVectorTest {

    Stack<Double> stack;
    @BeforeEach
    void setUp() {
        stack = new StackVector<Double>();
    }

    @Test
    void remove() {
        stack.add(5.27);
        stack.add(7.97);

        assertEquals(7.97, stack.remove());
    }

    @Test
    void peek() {
        stack.add(5.27);
        stack.add(7.97);

        assertEquals(7.97, stack.peek());
    }

    @Test
    void empty() {
        assertEquals(true, stack.empty());
    }

    @Test
    void size() {
        stack.add(5.27);
        stack.add(7.97);

        assertEquals(2, stack.size());
    }
}