package com.yuyang.he.lc.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * @author yuyanghe
 * @date 2017年1月17日
 * @version 1.0
 * @since 2017年1月17日
 */
public class LC380_Insert_Delete_GetRandom_O1
{
    public static void main(String[] args)
    {
        LC380_Insert_Delete_GetRandom_O1 instance = new LC380_Insert_Delete_GetRandom_O1();
        System.out.println(instance.insert(0));
        System.out.println(instance.insert(1));
        System.out.println(instance.remove(0));
        System.out.println(instance.remove(1));
        System.out.println(instance.getRandom());
    }

    private int ct = 10000, capacity = 100, curLen = 0;
    private int[] ctList = new int[capacity];
    private Map<Integer, Integer> ct2keyMap, key2ctMap, key2posMap, pos2keyMap;

    /** Initialize your data structure here. */
    public LC380_Insert_Delete_GetRandom_O1() {
        ct2keyMap = new HashMap<Integer, Integer> ();
        key2ctMap = new HashMap<Integer, Integer> ();
        key2posMap = new HashMap<Integer, Integer> ();
        pos2keyMap = new HashMap<Integer, Integer> ();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already
     * contain the specified element.
     */
    public boolean insert(int val)
    {
        if (curLen == capacity)
        {
            capacity *= 2;
            int[] newCtList = new int[capacity];
            for (int i = 0; i < ctList.length; i++)
            {
                newCtList[i] = ctList[i];
            }
            ctList = newCtList;
        }
        if (key2ctMap.containsKey(val))
        {
            return false;
        }
        ctList[curLen] = ++ct;
        ct2keyMap.put(ct, val);
        key2ctMap.put(val, ct);
        pos2keyMap.put(curLen, val);
        key2posMap.put(val, curLen++);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the
     * specified element.
     */
    public boolean remove(int val)
    {
        if (!key2ctMap.containsKey(val))
        {
            return false;
        }

        Integer ct = key2ctMap.get(val);
        key2ctMap.remove(val);
        ct2keyMap.remove(ct);
        Integer pos = key2posMap.get(val);
        key2posMap.remove(val);
        pos2keyMap.remove(pos);
        curLen--;
        if (pos != curLen)
        {
            ctList[pos] = ctList[curLen];
            Integer moveVal = ct2keyMap.get(ctList[curLen]);
            key2posMap.put(moveVal, pos);
            pos2keyMap.put(pos, moveVal);
            pos2keyMap.remove(curLen);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom()
    {
        if(0 == curLen)
        {
            return 0;
        }
        int randomIndex = new Random().nextInt(curLen);
        Integer ct = ctList[randomIndex];
        return ct2keyMap.get(ct).intValue();
    }
}
