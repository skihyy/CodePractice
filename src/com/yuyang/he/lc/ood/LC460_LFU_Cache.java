package com.yuyang.he.lc.ood;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yuyanghe
 * @date 2017年2月27日
 * @version 1.0
 * @since 2017年2月27日
 */
public class LC460_LFU_Cache
{
    public static void main(String[] args)
    {
        LC460_LFU_Cache cache = new LC460_LFU_Cache(2);

        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    Map<Integer, Integer> keyToVal = new HashMap<Integer, Integer>(), keyToFre = new HashMap<Integer, Integer>();
    Set<Integer> operationHistory = new LinkedHashSet<Integer>();
    int capacity;

    public LC460_LFU_Cache(int capacity)
    {
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if (keyToVal.containsKey(key))
        {
            refresh(key);
            return keyToVal.get(key);
        }
        return -1;
    }

    public void put(int key, int value)
    {
        if (0 >= this.capacity)
            return;

        if (keyToVal.size() == this.capacity && !keyToVal.containsKey(key))
        {
            int minFre = Integer.MAX_VALUE, minFreKey = -1, tmp = -1;
            for (Integer oh : operationHistory)
            {
                tmp = keyToFre.get(oh);
                if (minFre > tmp)
                {
                    minFre = tmp;
                    minFreKey = oh;
                }
            }
            operationHistory.remove(minFreKey);
            keyToVal.remove(minFreKey);
            keyToFre.remove(minFreKey);
        }
        keyToVal.put(key, value);
        refresh(key);
    }

    private void refresh(int key)
    {
        if (operationHistory.contains(key))
            operationHistory.remove(key);
        operationHistory.add(key);
        if (keyToFre.containsKey(key))
            keyToFre.put(key, keyToFre.get(key) + 1);
        else
            keyToFre.put(key, 1);
    }

}
