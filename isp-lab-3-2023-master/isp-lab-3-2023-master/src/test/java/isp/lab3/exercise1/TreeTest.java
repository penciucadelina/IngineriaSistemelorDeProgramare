package isp.lab3.exercise1;

import isp.lab3.exercise1.Tree;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void testGrow() {
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        Tree tree3 = new Tree();

        tree1.grow(3);
        assertEquals(18, tree1.getHeight());

        tree2.grow(1);
        assertEquals(16, tree2.getHeight());

        tree3.grow(12);
        assertEquals(27, tree3.getHeight());
    }


    @Test
    public void testTesttoString() {
        //trebuie sa verifice valoarea initiala sa fie 15
        Tree tree1 = new Tree();

        String expected1 = "Height of the tree: 15 meters";
        String actual1 = tree1.toString();
        assertEquals(expected1, actual1);

        //15+3=18
        Tree tree2 = new Tree();
        tree2.grow(3);

        String expected2 = "Height of the tree: 18 meters";
        String actual2 = tree2.toString();
        assertEquals(expected2, actual2);

    }
}
