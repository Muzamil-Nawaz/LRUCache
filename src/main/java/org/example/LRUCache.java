package org.example;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    Integer length;

    Deque<Integer> keys;

    Map<Integer, Integer> entries;

    public LRUCache(Integer length){
        this.length = length;
        keys = new LinkedList();
        entries = new HashMap<>();
    }

    public void put(int key, int value){
        // if already not present, needs to be added
        if(!this.keys.contains(key)){
            // if size is already full, need to make room
            if(this.keys.size() == length){
                // removing last key & it's entry assuming it's least used
                Integer last = this.keys.removeLast();
                this.entries.remove(last);
            }
            // go ahead and add new key and it's entry
            this.keys.addFirst(key);
            this.entries.put(key, value);
        }
    }

    public Integer get(int key){
        // if key exists
        if(this.keys.contains(key)){
            // if it's already not first, need to make it first
            if(!this.keys.getFirst().equals(key)){
                // remove it from existing position, and add at first
                this.keys.remove(key);
                this.keys.addFirst(key);
            }
            return this.entries.get(key);
        }
        // if doesn't exist, return -1
        return  -1;
    }
}
