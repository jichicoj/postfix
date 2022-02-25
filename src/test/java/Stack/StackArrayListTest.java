/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 *
 * @author cindy
 */
public class StackArrayListTest {
    
    public StackArrayListTest() {
    }
    
     Stack<Double> stack;
    @BeforeEach
    void setUp() {
        stack = new StackVector<Double>();
    }

    @Test
    void remove() {
        stack.add(5.27);
        stack.add(7.97);

        assertEquals(Optional.of(7.97), stack.remove());
    }

    @Test
    void peek() {
        stack.add(5.27);
        stack.add(7.97);

        assertEquals(Optional.of(7.97), stack.peek());
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