package com.dkus.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anders.schwartz
 */

public class BinarySearchTreeTest {

    @Test
    public void TestInsertionAndSearch() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.put(5, "A");
        bst.put(2, "B");
        bst.put(7, "C");
        bst.put(1, "D");
        bst.put(6, "E");
        bst.put(3, "F");
        bst.put(8, "G");
        bst.put(4, "H");

        assertEquals(bst.get(5).getValue(), "A");
        assertEquals(bst.get(4).getValue(), "H");

        try {
            bst.put(-1, "test");
            fail("No exception was thrown from providing negative key");
        } catch (Exception e) {
        }
        try {
            bst.put(1, null);
            fail("No exception was thrown from providing null value");
        } catch (Exception e) {
        }
        try {
            bst.put(-1, null);
            fail("No exception was thrown from providing negative key and null value");
        } catch (Exception e) {
        }
    }

    @Test
    public void TestIsUnbalanced() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.put(6, "A");
        bst.put(2, "B");
        bst.put(8, "C");
        bst.put(1, "D");
        bst.put(7, "E");
        bst.put(3, "F");
        bst.put(9, "G");
        bst.put(4, "H");
        bst.put(5, "I");

        assertEquals(bst.isUnBalanced(), true);
    }

    @Test
    public void TestIsBalanced() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.put(5, "A");
        bst.put(2, "B");
        bst.put(7, "C");
        bst.put(1, "D");
        bst.put(6, "E");
        bst.put(3, "F");
        bst.put(8, "G");

        assertEquals(bst.isUnBalanced(), false);
    }

    @Test
    public void TestTraversal() throws Exception {
        // Strictly speaking not a proper unit test because of the lack of assertions. Should be an example of use instead
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.put(6, "A");
        bst.put(2, "B");
        bst.put(8, "C");
        bst.put(1, "D");
        bst.put(7, "E");
        bst.put(3, "F");
        bst.put(9, "G");
        bst.put(4, "H");
        bst.put(5, "I");

        bst.preOrderTraversal();
        bst.inOrderTraversal();
        bst.postOrderTraversal();
    }

    @Test
    public void TestSearching() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.put(6, "A");
        bst.put(2, "B");
        bst.put(8, "C");
        bst.put(1, "D");
        bst.put(7, "E");
        bst.put(3, "F");
        bst.put(9, "G");
        bst.put(4, "H");
        bst.put(5, "I");

        BinaryNode<String> node = bst.depthFirstSearch(5);
        assertEquals(node.getValue(), "I");

        node = bst.depthFirstSearch(4);
        assertEquals(node.getValue(), "H");


        node = bst.breadthFirstSearch(7);
        assertEquals(node.getValue(), "E");

        node = bst.breadthFirstSearch(5);
        assertEquals(node.getValue(), "I");
    }

    @Test
    public void TestMatchingSubtree() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.put(10, "A");
        bst.put(4, "B");
        bst.put(13, "C");
        bst.put(2, "D");
        bst.put(6, "E");
        bst.put(7, "H");
        bst.put(8, "J");
        bst.put(12, "L");
        bst.put(14, "M");
        bst.put(1, "F");
        bst.put(3, "G");
        bst.put(11, "N");
        bst.put(15, "O");
        bst.put(5, "I");
        bst.put(9, "K");

        bst.preOrderTraversal();

        BinarySearchTree<String> bst2 = new BinarySearchTree<>();
        bst2.put(13, "C");
        bst2.put(12, "L");
        bst2.put(14, "M");
        bst2.put(11, "N");
        bst2.put(15, "O");

        bst2.preOrderTraversal();

        boolean result = bst2.matchTrees(bst.get(10), bst2.get(13));
        assertEquals(result, true);
    }

    @Test
    public void TestMatchingAnotherSubtree() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.put(10, "A");
        bst.put(4, "B");
        bst.put(13, "C");
        bst.put(2, "D");
        bst.put(6, "E");
        bst.put(7, "H");
        bst.put(8, "J");
        bst.put(12, "L");
        bst.put(14, "M");
        bst.put(1, "F");
        bst.put(3, "G");
        bst.put(11, "N");
        bst.put(15, "O");
        bst.put(5, "I");
        bst.put(9, "K");

        BinaryNode<String> node = bst.findSmallestKeyInTree(bst.get(10));
        assertEquals(node.getKey(), 1);

        node = bst.findSmallestKeyInTree(bst.get(13));
        assertEquals(node.getKey(), 11);

        int deleteKey = 6;
        assertNotNull(bst.get(deleteKey));
        assertEquals(bst.deleteNode(bst.get(deleteKey)), true);
        assertNull(bst.get(deleteKey));

        deleteKey = 3;
        assertNotNull(bst.get(deleteKey));
        assertEquals(bst.deleteNode(bst.get(deleteKey)), true);
        assertNull(bst.get(deleteKey));
    }
}
