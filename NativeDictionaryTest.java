import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    @Test
    void isKey() {
        NativeDictionary nd = new NativeDictionary(7, Integer.class);
        nd.put("aaa", 0);
        nd.put("a", 1);
        nd.put("aab", 2);
        assertTrue(nd.isKey("aaa"));
        assertTrue(nd.isKey("a"));
        assertTrue(nd.isKey("aab"));
        assertFalse(nd.isKey("z"));
        assertFalse(nd.isKey("zz"));
    }

    @Test
    void put() {
        NativeDictionary nd = new NativeDictionary(7, Integer.class);
        nd.put("aaa", 0);
        nd.put("a", 1);
        nd.put("aab", 2);
        assertEquals(0, nd.get("aaa"));
        assertEquals(1, nd.get("a"));
        assertEquals(2, nd.get("aab"));
        nd.put("a", 7);
        assertEquals(7, nd.get("a"));
    }

    @Test
    void get() {
        NativeDictionary nd = new NativeDictionary(7, Integer.class);
        assertNull(nd.get("zzz"));
        nd.put("aaa", 0);
        assertEquals(0, nd.get("aaa"));
        nd.put("aab", 2);
        assertEquals(2, nd.get("aab"));
    }
}