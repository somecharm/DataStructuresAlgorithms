import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void hashFun() {
        HashTable ht=new HashTable(7,3);
        assertEquals(1,ht.hashFun("a"));
        assertEquals(2,ht.hashFun("ab"));
        assertEquals(2,ht.hashFun("aa"));
        assertEquals(6,ht.hashFun("aavvdf"));
    }

    @Test
    void seekSlot() {
        HashTable ht=new HashTable(7,3);
        assertEquals(1,ht.seekSlot("a"));
        assertEquals(1,ht.seekSlot("12345678"));
    }
    @Test
    void putBusy() {
        HashTable ht=new HashTable(3,2);
        assertEquals(1,ht.put("a"));
        assertEquals(2,ht.put("aa"));
        assertEquals(0,ht.put("ab"));
        assertEquals(-1,ht.put("ac"));
    }

    @Test
    void put() {
        HashTable ht=new HashTable(7,3);
        assertEquals(1,ht.put("a"));
        assertEquals(4,ht.put("12345678"));
    }

    @Test
    void find() {
        HashTable ht=new HashTable(7,3);
        assertEquals(1,ht.put("a"));
        assertEquals(4,ht.put("12345678"));
        assertEquals(4,ht.find("12345678"));
        assertEquals(-1,ht.find("1"));
    }
    @Test
    void findBusy() {
        HashTable ht=new HashTable(3,2);
        assertEquals(1,ht.put("a"));
        assertEquals(0,ht.put("1"));
        assertEquals(2,ht.put("12"));
        assertEquals(-1,ht.find("5"));
    }
}