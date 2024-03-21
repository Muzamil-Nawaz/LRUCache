package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    @Test
    void init() {
        LRUCache LRUCache = new LRUCache(5);
        assertEquals(LRUCache.length, 5);
        assertNotEquals(LRUCache.length, 6);
    }

    @Test
    void put(){
        LRUCache LRUCache = new LRUCache(2);
        LRUCache.put(1,1);
        assertEquals(1, LRUCache.get(1));
        LRUCache.put(2,2);
        assertEquals(2, LRUCache.get(2));
        LRUCache.put(3,3);
        assertEquals(-1, LRUCache.get(1));
    }
    @Test
    void combinedTest(){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        assertEquals(1, lRUCache.get(1));
        lRUCache.put(3, 3);
        assertEquals(-1, lRUCache.get(2));
        lRUCache.put(4, 4);
        assertEquals(-1, lRUCache.get(1));
        assertEquals(3, lRUCache.get(3));
        assertEquals(4, lRUCache.get(4));
    }
}