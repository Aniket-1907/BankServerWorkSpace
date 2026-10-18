package com.cg.bankapp.practice;

import java.util.*;

public class LRUCache {

    private Map<Map.Entry<Integer,Integer>,Integer> map;
    private int currentCapacity;
    private final int MAXIMUM_CAPACITY;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.MAXIMUM_CAPACITY =capacity;
        currentCapacity=0;
    }

    public int get(int key) {

//        if(tempMap.containsKey(key)) {
//
//            return tempMap.get(key);
//        }
        return -1;
    }

    public void put(int key, int value) {
        if(MAXIMUM_CAPACITY !=currentCapacity){
            map.put(Map.entry(key,value),1);
        }
        else{

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */