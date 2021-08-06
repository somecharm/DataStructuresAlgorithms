import java.util.*;

class BSTNode {
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int Level; // глубина узла

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {
    public BSTNode Root;

    public int[] BSTArray; // временный массив для ключей дерева

    public BalancedBST() {
        Root = null;
    }

    public void CreateFromArray(int[] a) {
        // создаём массив дерева BSTArray из заданного
        int size = 0, depth = 0;
        while (size < a.length) {
            size = (int) Math.pow(2, depth + 1) - 1;
            depth++;
        }
        BSTArray = new int[size];
        Arrays.sort(a);
        Generate(a, 0);
    }

    private void Generate(int[] a, int index) {
        int middle = a.length / 2;
        BSTArray[index] = a[middle];

        int[] left = Arrays.copyOfRange(a, 0, middle);
        int[] right = Arrays.copyOfRange(a, middle + 1, a.length);

        if (left.length > 0) {
            Generate(left, 2 * index + 1);
        }
        if (right.length > 0) {
            Generate(right, 2 * index + 2);
        }
    }

    public void GenerateTree() {
        // создаём дерево с нуля из массива BSTArray
        Root = AddNode(0, null);
    }

    public BSTNode AddNode(int index, BSTNode parent) {
        if (index >= BSTArray.length) return null;
        BSTNode Node = new BSTNode(BSTArray[index], parent);
        if (Node.Parent == null) {
            Node.Level = 1;
        } else {
            Node.Level = Node.Parent.Level + 1;
        }
        if (2 * index + 1 < BSTArray.length && BSTArray[2 * index + 1] > 0) {
            Node.LeftChild = AddNode(2 * index + 1, Node);
        }
        if (2 * index + 2 < BSTArray.length && BSTArray[2 * index + 2] > 0) {
            Node.RightChild = AddNode(2 * index + 2, Node);
        }
        return Node;
    }

    public boolean IsBalanced(BSTNode root_node) {
        if (root_node == null)
            return true;
        int left = MaxDepth(root_node.LeftChild);
        int right = MaxDepth(root_node.RightChild);
        // сбалансировано ли дерево с корнем root_node
        return Math.abs(left - right) <= 1;
    }

    int MaxDepth(BSTNode node) {
        if (node != null) {
            int left = node.Level;
            int right = node.Level;
            if (node.LeftChild != null) left = MaxDepth(node.LeftChild);
            if (node.RightChild != null) right = MaxDepth(node.RightChild);
            return Math.max(left, right);
        }
        return 0;
    }
}  