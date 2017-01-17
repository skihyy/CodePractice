package com.yuyang.he.lc.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC146_LRUCache
{
    public static void main(String[] args)
    {
        LC146_LRUCache cache = new LC146_LRUCache(1);
        cache.set(2, 1);
        System.out.println(cache.get(2));
        cache.set(3, 2);
        //cache.set(1, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    // last count is auto increasing as id in the database
    // capacity is the capacity of the cache
    private int lastCount = 10000, capacity = 0;
    // count list used to store id
    // so that every time to delete one, just use list.remove(0)
    private List<Integer> countList;
    // keyMap => key is last count, value is the key of data
    // krMap => reverse way of keyMap in order for quick search
    // valueMap => key value is the data pair
    private Map<Integer, Integer> keyMap, krMap, valueMap;

    public LC146_LRUCache(int capacity)
    {
        this.capacity = capacity;
        countList = new ArrayList<Integer>();
        keyMap = new HashMap<Integer, Integer>();
        krMap = new HashMap<Integer, Integer>();
        valueMap = new HashMap<Integer, Integer>();
    }

    public int get(int key)
    {
        if (!valueMap.containsKey(key))
        {
            return -1;
        }

        update(key);
        return valueMap.get(key);
    }

    public void set(int key, int value)
    {
        if(valueMap.containsKey(key))
        {
            update(key);
            valueMap.put(key, value);
        }
        else
        {
            // remove the oldest one
            if(countList.size() == capacity)
            {
                Integer oldestCount = countList.get(0);
                countList.remove(0);
                Integer oldKey = keyMap.get(oldestCount);
                keyMap.remove(oldestCount);
                krMap.remove(oldKey);
                valueMap.remove(oldKey);
            }
            
            // insert
            countList.add(++lastCount);
            keyMap.put(lastCount, key);
            krMap.put(key, lastCount);
            valueMap.put(key, value);
        }
    }

    /**
     * Used to flush the count based on the given key.
     * @param key
     */
    private void update(int key)
    {
        Integer count = krMap.get(key);
        countList.remove(count);
        countList.add(++lastCount);
        krMap.put(key, lastCount);
        keyMap.remove(count);
        keyMap.put(lastCount, key);
    }
}
