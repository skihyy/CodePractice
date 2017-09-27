package com.yuyang.he.lc.ood;

import java.util.LinkedList;
import java.util.Queue;

public class LC346_Moving_Average_From_Data_Stream
{

    public static void main(String[] args)
    {
        LC346_Moving_Average_From_Data_Stream lc346 = new LC346_Moving_Average_From_Data_Stream(3);
        System.out.println(lc346.next(1));
        System.out.println(lc346.next(10));
        System.out.println(lc346.next(3));
        System.out.println(lc346.next(5));
    }
    
    private final Queue<Integer> window = new LinkedList<> ();
    private int curSum = 0;
    private int size;

    /** Initialize your data structure here. */
    public LC346_Moving_Average_From_Data_Stream(final int size) {
        this.size = size;
    }
    
    public final double next(final int val) {
        if(size == window.size()) 
            curSum -= window.poll();
        window.add(val);
        curSum += val;
        return curSum * 1.0 / window.size();
    }

}
