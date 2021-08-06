import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class aBSTTest {

    @Test
    void findKeyIndex() {
        aBST aBST = new aBST(3);
        assertEquals(0,aBST.AddKey(50));
        assertEquals(1,aBST.AddKey(25));
        assertEquals(2,aBST.AddKey(75));
        assertEquals(0,aBST.FindKeyIndex(50));
        assertEquals(1,aBST.FindKeyIndex(25));
        assertEquals(2,aBST.FindKeyIndex(75));
        assertEquals(-3,aBST.FindKeyIndex(20));
        assertEquals(-4,aBST.FindKeyIndex(37));
        assertEquals(4,aBST.AddKey(37));
        assertEquals(9,aBST.AddKey(31));
        assertEquals(10,aBST.AddKey(43));
        assertEquals(5,aBST.AddKey(62));
        assertEquals(6,aBST.AddKey(84));
        assertEquals(11,aBST.AddKey(55));
        assertEquals(14,aBST.AddKey(92));
        for (Integer node : aBST.Tree) {
            System.out.println(node);
        }
    }

    @Test
    void addKey() {
        aBST aBST = new aBST(1);
        assertEquals(0,aBST.AddKey(50));
        assertEquals(1,aBST.AddKey(25));
        assertEquals(1,aBST.AddKey(25));
        assertEquals(2,aBST.AddKey(75));
        assertEquals(-1,aBST.AddKey(100));
        assertNull(aBST.FindKeyIndex(100));
    }
}