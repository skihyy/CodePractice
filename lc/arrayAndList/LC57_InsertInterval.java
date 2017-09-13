package com.yuyang.he.lc.arrayAndList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC57_InsertInterval
{
    public static void main(String[] args)
    {
        LC57_InsertInterval lc57 = new LC57_InsertInterval();
        System.out.println(lc57.insert(
                new ArrayList<Interval>(Arrays.asList(lc57.new Interval(1, 2), lc57.new Interval(3, 5),
                        lc57.new Interval(12, 16), lc57.new Interval(8, 10), lc57.new Interval(6, 7))),
                lc57.new Interval(4, 9)));
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval)
    {
        intervals.add(newInterval);
        List<Interval> tmp = intervals.stream().sorted((i1, i2) -> Integer.compare(i1.start, i2.start))
                .collect(Collectors.toList());

        for (int i = 0; i < tmp.size() - 1;)
        {
            Interval pre = tmp.get(i), cur = tmp.get(i + 1);
            if (pre.end >= cur.start)
            { // overlap
                tmp.get(i).end = Math.max(cur.end, pre.end);
                tmp.remove(i + 1);
            }
            else
                i++;
        }

        return tmp;
    }

    class Interval
    {
        int start, end;

        Interval(int x, int y)
        {
            start = x;
            end = y;
        }

        public String toString()
        {
            return "[" + start + "," + end + "]";
        }
    }
}
