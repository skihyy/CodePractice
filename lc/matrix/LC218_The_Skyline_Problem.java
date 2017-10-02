package com.yuyang.he.lc.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class LC218_The_Skyline_Problem
{

    public static void main(String[] args)
    {
        List<int[]> l = new LC218_The_Skyline_Problem()
                 .getSkyline(new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5,
                 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } });
                //.getSkyline(new int[][] { { 0, Integer.MAX_VALUE, Integer.MAX_VALUE } });
        l.forEach(i ->
        {
            System.out.println(i[0] + " " + i[1]);
        });
    }

    public final List<int[]> getSkyline(final int[][] buildings)
    {
        final Map<Integer, List<int[]>> map = new TreeMap<>(); // ordered by
                                                               // left and right
                                                               // points
        for (final int[] b : buildings)
        {
            map.putIfAbsent(b[0], new ArrayList<>());
            map.get(b[0]).add(b);
            map.putIfAbsent(b[1], new ArrayList<>());
            map.get(b[1]).add(b);
        }

        // height from high to low
        final Queue<int[]> queue = new PriorityQueue<>((i, j) -> Integer.compare(j[2], i[2]));
        final List<int[]> result = new ArrayList<>();
        final Set<Map.Entry<Integer, List<int[]>>> set = map.entrySet();
        for (final Map.Entry<Integer, List<int[]>> e : set)
        {
            final int horizontal = e.getKey();
            final List<int[]> coordinations = e.getValue();
            for (final int[] c : coordinations)
            {
                if (c[0] == horizontal) // right edge
                    queue.add(c);
                else
                    queue.remove(c);
            }
            if (queue.isEmpty())
                result.add(new int[] { horizontal, 0 });
            else
            {
                final int height = queue.peek()[2];
                if (result.isEmpty() || result.get(result.size() - 1)[1] != height)
                    result.add(new int[] { horizontal, height });
            }
        }

        return result;
    }

}
