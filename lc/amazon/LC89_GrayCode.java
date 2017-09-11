package com.yuyang.he.lc.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyanghe
 * @date 2017年1月15日
 * @version 1.0
 * @since 2017年1月15日
 */
public class LC89_GrayCode
{
    public static void main(String [] args)
    {
        System.out.println(new LC89_GrayCode().grayCode(2));
    }
    
    public List<Integer> grayCode(int n) {
        if(0 > n)
        {
            return null;
        }
        
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        int tmp = 0;
        
        for(int i = 0; i < n; i++)
        {
            tmp = 1 << i;
            
            for(int j = res.size() - 1; j >= 0; j--)
            {
                res.add(tmp | res.get(j));
            }
        }
        
        return res;
    }
}
