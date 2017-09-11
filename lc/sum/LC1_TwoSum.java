package com.yuyang.he.lc.sum;

import java.util.HashMap;
import java.util.Map;
/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC1_TwoSum
{
    public int [] twoSum(int [] t, int target)
    {
        int [] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
        
        for(int i = 0 ; i < t.length; ++i)
        {
            if(map.containsKey(target - t[i]))
            {
                res[0] = i;
                res[1] = map.get(target - t[i]);
                break;
            }
            else
            {
                map.put(t[i], i);
            }
        }
        
        return res;
    }
}
