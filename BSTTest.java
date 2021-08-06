import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void findNodeByKey() {
        BST<Integer> bst = new BST<>(new BSTNode<Integer>(8, 8, null));
        bst.AddKeyValue(4, 4);
        //find present
        BSTFind<Integer> find = bst.FindNodeByKey(4);
        assertTrue(find.NodeHasKey);
        assertEquals(4, find.Node.NodeKey);
        //find left absent
        find = bst.FindNodeByKey(2);
        assertFalse(find.NodeHasKey);
        assertEquals(bst.Root.LeftChild, find.Node);
        assertTrue(find.ToLeft);
        //find right absent
        find = bst.FindNodeByKey(5);
        assertFalse(find.NodeHasKey);
        assertEquals(bst.Root.LeftChild, find.Node);
        assertFalse(find.ToLeft);
    }

    @Test
    void addKeyValue() {
        BST<Integer> bst = new BST<>(null);
        assertFalse(bst.FindNodeByKey(8).NodeHasKey);
        assertNull(bst.Root);
        assertTrue(bst.AddKeyValue(8, 8));
        assertEquals(8, bst.Root.NodeKey);
        //add left child
        assertFalse(bst.FindNodeByKey(4).NodeHasKey);
        assertTrue(bst.AddKeyValue(4, 4));
        assertEquals(4, bst.Root.LeftChild.NodeKey);
        assertNull(bst.Root.RightChild);
        assertNull(bst.Root.Parent);
        //add right child
        assertFalse(bst.FindNodeByKey(12).NodeHasKey);
        assertTrue(bst.AddKeyValue(12, 12));
        assertEquals(12, bst.Root.RightChild.NodeKey);
        //try to add present
        assertTrue(bst.FindNodeByKey(4).NodeHasKey);
        assertFalse(bst.AddKeyValue(4, 4));
    }

    @Test
    void finMinMax() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.AddKeyValue(12, 12));
        assertTrue(bst.AddKeyValue(2, 2));
        assertTrue(bst.AddKeyValue(6, 6));
        assertTrue(bst.AddKeyValue(1, 1));
        assertTrue(bst.AddKeyValue(3, 3));
        assertTrue(bst.AddKeyValue(5, 5));
        assertTrue(bst.AddKeyValue(7, 7));

        assertEquals(12, bst.FinMinMax(bst.Root, true).NodeKey);
        assertEquals(7, bst.FinMinMax(bst.FindNodeByKey(4).Node, true).NodeKey);
        assertEquals(3, bst.FinMinMax(bst.FindNodeByKey(2).Node, true).NodeKey);

        assertEquals(1, bst.FinMinMax(bst.Root, false).NodeKey);
        assertEquals(1, bst.FinMinMax(bst.FindNodeByKey(4).Node, false).NodeKey);
        assertEquals(5, bst.FinMinMax(bst.FindNodeByKey(6).Node, false).NodeKey);


    }

    @Test
    void deleteNodeByKey() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.AddKeyValue(12, 12));
        assertTrue(bst.AddKeyValue(2, 2));
        assertTrue(bst.AddKeyValue(6, 6));
        assertTrue(bst.AddKeyValue(1, 1));
//        assertTrue(bst.AddKeyValue(3, 3));
        assertTrue(bst.AddKeyValue(5, 5));
        assertTrue(bst.AddKeyValue(7, 7));


        assertTrue(bst.DeleteNodeByKey(5));
        assertFalse(bst.FindNodeByKey(5).NodeHasKey);
        assertNull(bst.FindNodeByKey(6).Node.LeftChild);
        assertEquals(7, bst.FindNodeByKey(6).Node.RightChild.NodeKey);

        /*assertTrue(bst.DeleteNodeByKey(7));
        assertFalse(bst.FindNodeByKey(7).NodeHasKey);
        assertNull(bst.FindNodeByKey(6).Node.RightChild);
        assertEquals(5,bst.FindNodeByKey(6).Node.LeftChild.NodeKey);*/

        assertTrue(bst.DeleteNodeByKey(6));
        assertFalse(bst.FindNodeByKey(6).NodeHasKey);
        assertEquals(7, bst.FindNodeByKey(4).Node.RightChild.NodeKey);
        assertEquals(4, bst.FindNodeByKey(7).Node.Parent.NodeKey);
        assertNull(bst.FindNodeByKey(7).Node.LeftChild);
        assertNull(bst.FindNodeByKey(7).Node.RightChild);

        assertTrue(bst.DeleteNodeByKey(2));
        assertFalse(bst.FindNodeByKey(2).NodeHasKey);
        assertEquals(1, bst.FindNodeByKey(4).Node.LeftChild.NodeKey);
        assertEquals(4, bst.FindNodeByKey(1).Node.Parent.NodeKey);
        assertNull(bst.FindNodeByKey(1).Node.LeftChild);
        assertNull(bst.FindNodeByKey(1).Node.RightChild);
    }

    @Test
    void deleteNodeByKey2() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.AddKeyValue(12, 12));
        assertTrue(bst.AddKeyValue(2, 2));
        assertTrue(bst.AddKeyValue(6, 6));
        assertTrue(bst.AddKeyValue(1, 1));
        assertTrue(bst.AddKeyValue(3, 3));
        assertTrue(bst.AddKeyValue(5, 5));
        assertTrue(bst.AddKeyValue(7, 7));

        assertTrue(bst.FindNodeByKey(2).NodeHasKey);
        assertTrue(bst.DeleteNodeByKey(2));
        assertFalse(bst.FindNodeByKey(2).NodeHasKey);
        assertEquals(3, bst.FindNodeByKey(4).Node.LeftChild.NodeKey);
        assertEquals(6, bst.FindNodeByKey(4).Node.RightChild.NodeKey);
        assertNull(bst.FindNodeByKey(3).Node.RightChild);
        assertEquals(1, bst.FindNodeByKey(3).Node.LeftChild.NodeKey);
        assertEquals(4, bst.FindNodeByKey(3).Node.Parent.NodeKey);
        assertEquals(3, bst.FindNodeByKey(1).Node.Parent.NodeKey);
    }


    @Test
    void deleteNodeByKey4() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.AddKeyValue(12, 12));
        assertTrue(bst.AddKeyValue(2, 2));
        assertTrue(bst.AddKeyValue(6, 6));
        assertTrue(bst.AddKeyValue(1, 1));
        assertTrue(bst.AddKeyValue(3, 3));
//        assertTrue(bst.AddKeyValue(5, 5));
        assertTrue(bst.AddKeyValue(7, 7));

        assertTrue(bst.FindNodeByKey(4).NodeHasKey);
        assertTrue(bst.DeleteNodeByKey(4));
        assertFalse(bst.FindNodeByKey(4).NodeHasKey);
        assertEquals(6, bst.Root.LeftChild.NodeKey);
        assertEquals(12, bst.Root.RightChild.NodeKey);
        assertEquals(2, bst.FindNodeByKey(6).Node.LeftChild.NodeKey);
        assertEquals(7, bst.FindNodeByKey(6).Node.RightChild.NodeKey);
        assertEquals(8, bst.FindNodeByKey(6).Node.Parent.NodeKey);
        assertEquals(6, bst.FindNodeByKey(7).Node.Parent.NodeKey);
        assertEquals(6, bst.FindNodeByKey(2).Node.Parent.NodeKey);
    }

    @Test
    void deleteNodeByKey5() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.AddKeyValue(12, 12));
        assertTrue(bst.AddKeyValue(2, 2));
        assertTrue(bst.AddKeyValue(6, 6));
        assertTrue(bst.AddKeyValue(1, 1));
        assertTrue(bst.AddKeyValue(3, 3));
        assertTrue(bst.AddKeyValue(5, 5));
        assertTrue(bst.AddKeyValue(7, 7));

        assertTrue(bst.FindNodeByKey(4).NodeHasKey);
        assertTrue(bst.DeleteNodeByKey(4));
        assertFalse(bst.FindNodeByKey(4).NodeHasKey);
        assertEquals(5, bst.Root.LeftChild.NodeKey);
        assertEquals(12, bst.Root.RightChild.NodeKey);
        assertEquals(2, bst.FindNodeByKey(5).Node.LeftChild.NodeKey);
        assertEquals(6, bst.FindNodeByKey(5).Node.RightChild.NodeKey);
        assertEquals(8, bst.FindNodeByKey(5).Node.Parent.NodeKey);
        assertEquals(5, bst.FindNodeByKey(6).Node.Parent.NodeKey);
        assertEquals(5, bst.FindNodeByKey(2).Node.Parent.NodeKey);
    }

    @Test
    void count() {
        BST<Integer> bst = new BST<>(null);
        assertEquals(0, bst.Count());
        assertTrue(bst.AddKeyValue(8, 8));
        assertEquals(1, bst.Count());
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.AddKeyValue(12, 12));
        assertTrue(bst.AddKeyValue(2, 2));
        assertEquals(4, bst.Count());
        assertTrue(bst.AddKeyValue(6, 6));
        assertTrue(bst.AddKeyValue(1, 1));
        assertTrue(bst.AddKeyValue(3, 3));
        assertEquals(7, bst.Count());
        assertTrue(bst.AddKeyValue(5, 5));
        assertTrue(bst.AddKeyValue(7, 7));
        assertEquals(9, bst.Count());
        assertTrue(bst.DeleteNodeByKey(4));
        assertEquals(8, bst.Count());
        assertTrue(bst.DeleteNodeByKey(2));
        assertTrue(bst.DeleteNodeByKey(12));
        assertTrue(bst.DeleteNodeByKey(3));
        assertEquals(5, bst.Count());
    }

    @Test
    void deleteRoot() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertEquals(8, bst.Root.NodeKey);
        assertTrue(bst.DeleteNodeByKey(8));
        assertFalse(bst.FindNodeByKey(8).NodeHasKey);
        assertEquals(0, bst.Count());
        assertNull(bst.Root);
    }

    @Test
    void deleteRoot1() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertEquals(8, bst.Root.NodeKey);
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.DeleteNodeByKey(8));
        assertFalse(bst.FindNodeByKey(8).NodeHasKey);
        assertEquals(1, bst.Count());
        assertEquals(4, bst.Root.NodeKey);
    }

    @Test
    void deleteRoot2() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.AddKeyValue(12, 12));
        assertEquals(8, bst.Root.NodeKey);
        assertTrue(bst.DeleteNodeByKey(8));
        assertFalse(bst.FindNodeByKey(8).NodeHasKey);
        assertEquals(2, bst.Count());
        assertEquals(12, bst.Root.NodeKey);
        assertEquals(4, bst.FindNodeByKey(12).Node.LeftChild.NodeKey);
    }

    @Test
    void wideAllNodes() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.AddKeyValue(12, 12));
        assertTrue(bst.AddKeyValue(2, 2));
        assertTrue(bst.AddKeyValue(6, 6));
        assertTrue(bst.AddKeyValue(1, 1));
        assertTrue(bst.AddKeyValue(3, 3));
        assertTrue(bst.AddKeyValue(5, 5));
        assertTrue(bst.AddKeyValue(7, 7));
        assertTrue(bst.AddKeyValue(10, 10));
        assertTrue(bst.AddKeyValue(14, 14));
        assertTrue(bst.AddKeyValue(9, 9));
        assertTrue(bst.AddKeyValue(11, 11));
        assertTrue(bst.AddKeyValue(13, 13));
        assertTrue(bst.AddKeyValue(15, 15));

        ArrayList<BSTNode<Integer>> list = bst.WideAllNodes();
        for (BSTNode<Integer> i : list) {
            System.out.println(i.NodeKey);
        }
    }

    @Test
    void deepAllNodes() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.AddKeyValue(12, 12));
        assertTrue(bst.AddKeyValue(2, 2));
        assertTrue(bst.AddKeyValue(6, 6));
        assertTrue(bst.AddKeyValue(1, 1));
        assertTrue(bst.AddKeyValue(3, 3));
        assertTrue(bst.AddKeyValue(5, 5));
        assertTrue(bst.AddKeyValue(7, 7));

        ArrayList<BSTNode<Integer>> list = bst.DeepAllNodes(2);
        for (BSTNode<Integer> i : list) {
            System.out.println(i.NodeKey);
        }
    }

}
