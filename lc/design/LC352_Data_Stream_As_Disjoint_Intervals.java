package com.yuyang.he.lc.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC352_Data_Stream_As_Disjoint_Intervals
{

    public static void main(String[] args)
    {
        LC352_Data_Stream_As_Disjoint_Intervals test = new LC352_Data_Stream_As_Disjoint_Intervals();
        test.addNum(1);test.addNum(3);test.addNum(7);test.addNum(2);test.addNum(6);
        System.out.println(test.getIntervals());
    }

    private Set<Integer> set;

    public LC352_Data_Stream_As_Disjoint_Intervals() {
        set = new HashSet<> ();
    }

    public void addNum(int val)
    {
        set.add(val);
    }

    public List<Interval> getIntervals()
    {
        List<Interval> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(set);
        int size = set.size();
        if (0 != size)
        {
            Collections.sort(list);
            int start = list.get(0), end = start, cur = start;
            for (int i = 1; i < size; i++)
            {
                cur = list.get(i);
                if (1 == cur - end)
                {
                    end = cur;
                }
                else
                {
                    result.add(new Interval(start, end));
                    start = end = cur;
                }
            }
            result.add(new Interval(start, end));
        }

        return result;
    }

    class Interval
    {
        int start, end;

        Interval(int s, int e)
        {
            start = s;
            end = e;
        }
        
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
}
