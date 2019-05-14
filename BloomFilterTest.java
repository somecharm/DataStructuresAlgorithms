import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

    @Test
    void hash1() {
        BloomFilter bf = new BloomFilter(32);
        System.out.println(Integer.toBinaryString(bf.hash1("0123456789")));
        System.out.println(Integer.toBinaryString(bf.hash1("1234567890")));
        System.out.println(Integer.toBinaryString(bf.hash1("2345678901")));
        System.out.println(Integer.toBinaryString(bf.hash1("3456789012")));
        System.out.println(Integer.toBinaryString(bf.hash1("4567890123")));
        System.out.println(Integer.toBinaryString(bf.hash1("5678901234")));
        System.out.println(Integer.toBinaryString(bf.hash1("6789012345")));
        System.out.println(Integer.toBinaryString(bf.hash1("7890123456")));
        System.out.println(Integer.toBinaryString(bf.hash1("8901234567")));
        System.out.println(Integer.toBinaryString(bf.hash1("9012345678")));
    }

    @Test
    void hash2() {
        BloomFilter bf = new BloomFilter(32);
        System.out.println(Integer.toBinaryString(bf.hash2("0123456789")));
        System.out.println(Integer.toBinaryString(bf.hash2("1234567890")));
        System.out.println(Integer.toBinaryString(bf.hash2("2345678901")));
        System.out.println(Integer.toBinaryString(bf.hash2("3456789012")));
        System.out.println(Integer.toBinaryString(bf.hash2("4567890123")));
        System.out.println(Integer.toBinaryString(bf.hash2("5678901234")));
        System.out.println(Integer.toBinaryString(bf.hash2("6789012345")));
        System.out.println(Integer.toBinaryString(bf.hash2("7890123456")));
        System.out.println(Integer.toBinaryString(bf.hash2("8901234567")));
        System.out.println(Integer.toBinaryString(bf.hash2("9012345678")));
    }

    @Test
    void add() {
        BloomFilter bf = new BloomFilter(32);
        bf.add("0123456789");
    }

    @Test
    void isValue() {
        BloomFilter bf = new BloomFilter(32);
        bf.add("0123456789");
        bf.add("5678901234");
        bf.add("9012345678");
        assertTrue(bf.isValue("5678901234"));
        assertTrue(bf.isValue("0123456789"));
        assertTrue(bf.isValue("9012345678"));
        assertFalse(bf.isValue("qwerty"));
    }
}