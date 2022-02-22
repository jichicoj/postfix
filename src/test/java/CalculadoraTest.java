import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void calculate() throws Exception {
        assertEquals(9, calculator.calculate("9 8 * 9 - 7 /"));
    }
}