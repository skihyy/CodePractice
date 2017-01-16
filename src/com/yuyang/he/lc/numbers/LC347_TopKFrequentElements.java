package com.yuyang.he.lc.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuyanghe
 * @date 2017年1月16日
 * @version 1.0
 * @since 2017年1月16日
 */
public class LC347_TopKFrequentElements
{
    public static void main(String[] args)
    {
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
        
        for(int i : nums)
        {
            if(!map.containsKey(i))
            {
                map.put(i, 1);
            }
            else
            {
                map.put(i, map.get(i) + 1);
            }
        }
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
            
        });
        
        List<Integer> res = new ArrayList<Integer>();
        int ct = 0;
        for(Map.Entry<Integer,Integer> entry: list)
        {
            res.add(entry.getKey());
            ct++;
            if(k == ct)
            {
                break;
            }
        }
        return res;
    }
}
