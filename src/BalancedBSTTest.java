import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBSTTest {

    @Test
    void createFromArray() {
        BalancedBST balancedBST = new BalancedBST();
        int[] a = {2, 5, 7, 4, 3, 1, 6, 8};
        balancedBST.CreateFromArray(a);
        System.out.println(Arrays.toString(balancedBST.BSTArray));
    }

    @Test
    void GenerateTree() {
        BalancedBST balancedBST = new BalancedBST();
        int[] a = {2, 5, 7, 4, 3, 1, 6, 8};
        balancedBST.CreateFromArray(a);
        System.out.println(Arrays.toString(balancedBST.BSTArray));
        balancedBST.GenerateTree();
        assertEquals(5,balancedBST.Root.NodeKey);
        assertNull(balancedBST.Root.Parent);
        assertEquals(3,balancedBST.Root.LeftChild.NodeKey);
        assertEquals(5,balancedBST.Root.LeftChild.Parent.NodeKey);
        assertEquals(7,balancedBST.Root.RightChild.NodeKey);
        assertEquals(5,balancedBST.Root.RightChild.Parent.NodeKey);

        assertEquals(2,balancedBST.Root.LeftChild.LeftChild.NodeKey);
        assertEquals(3,balancedBST.Root.LeftChild.LeftChild.Parent.NodeKey);
        assertEquals(1,balancedBST.Root.LeftChild.LeftChild.LeftChild.NodeKey);
        assertEquals(2,balancedBST.Root.LeftChild.LeftChild.LeftChild.Parent.NodeKey);
        assertEquals(4,balancedBST.Root.LeftChild.RightChild.NodeKey);

        assertEquals(6,balancedBST.Root.RightChild.LeftChild.NodeKey);
        assertEquals(7,balancedBST.Root.RightChild.LeftChild.Parent.NodeKey);
        assertEquals(8,balancedBST.Root.RightChild.RightChild.NodeKey);
        assertEquals(7,balancedBST.Root.RightChild.RightChild.Parent.NodeKey);

        assertEquals(1,balancedBST.Root.Level);
        assertEquals(2,balancedBST.Root.LeftChild.Level);
        assertEquals(2,balancedBST.Root.RightChild.Level);
        assertEquals(3,balancedBST.Root.LeftChild.LeftChild.Level);
        assertEquals(3,balancedBST.Root.LeftChild.RightChild.Level);
        assertEquals(3,balancedBST.Root.RightChild.LeftChild.Level);
        assertEquals(3,balancedBST.Root.RightChild.RightChild.Level);
        assertEquals(4,balancedBST.Root.LeftChild.LeftChild.LeftChild.Level);
    }

    @Test
    void isBalanced() {
        BalancedBST balancedBST = new BalancedBST();
        int[] a = {2, 5, 7, 4, 3, 1, 6, 8};
        balancedBST.CreateFromArray(a);
        System.out.println(Arrays.toString(balancedBST.BSTArray));
        balancedBST.GenerateTree();
        assertEquals(true,balancedBST.IsBalanced(balancedBST.Root));
    }
}