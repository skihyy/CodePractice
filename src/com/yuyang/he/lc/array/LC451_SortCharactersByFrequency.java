package com.yuyang.he.lc.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author yuyanghe
 * @date 2017年1月17日
 * @version 1.0
 * @since 2017年1月17日
 */
public class LC451_SortCharactersByFrequency
{
    public static void main(String[] args)
    {
        System.out.println(new LC451_SortCharactersByFrequency().frequencySort("raaeaedere"));
    }

    public String frequencySort(String s)
    {
        char[] cc = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : cc)
        {
            if (map.containsKey(c))
            {
                map.put(c, map.get(c) + 1);
            }
            else
            {
                map.put(c, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<Map.Entry<Character, Integer>>(100,
                new Comparator<Map.Entry<Character, Integer>>()
                {
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2)
                    {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });
        for(Map.Entry<Character, Integer> entry : set)
        {
            queue.add(entry);
        }
        
        StringBuilder sb = new StringBuilder();
        int f = -1;
        char c = 1;
        Map.Entry<Character, Integer> entry = null;
        while(!queue.isEmpty())
        {
            entry = queue.poll();
            f = entry.getValue();
            c = entry.getKey();
            
            for(int i = 0; i < f; i++)
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
