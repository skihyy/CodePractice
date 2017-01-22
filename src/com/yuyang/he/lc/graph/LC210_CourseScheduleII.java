package com.yuyang.he.lc.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC210_CourseScheduleII
{

    public static void main(String[] args)
    {
        int[][] a = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 }, { 1, 4 } };
        int[] b = new LC210_CourseScheduleII().findOrder(5, a);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < b.length - 1; i++)
        {
            sb.append(b[i]);
            sb.append(',');
        }
        sb.append(b[b.length - 1]);
        sb.append(']');
        System.out.println(sb.toString());
    }

    public int[] findOrder(int numCourse, int[][] prerequisites)
    {
        int[] inDegrees = new int[numCourse];
        for (int i = 0; i < prerequisites.length; i++)
        {
            inDegrees[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < inDegrees.length; i++)
        {
            if (0 == inDegrees[i])
            {
                queue.add(i);
            }
        }

        List<Integer> courseOrder = new ArrayList<Integer>(numCourse);
        Integer curCourse = null;
        while (!queue.isEmpty())
        {
            curCourse = queue.poll();
            courseOrder.add(curCourse);

            for(int [] course : prerequisites)
            {
                if(curCourse == course[1])
                {
                    inDegrees[course[0]]--;
                    
                    if(0 == inDegrees[course[0]])
                    {
                        queue.add(course[0]);
                    }
                }
            }
        }

        int[] res = new int[numCourse];
        if (numCourse == courseOrder.size())
        {
            for (int i = 0; i < res.length; i++)
            {
                res[i] = courseOrder.get(i);
            }
        }
        return res;
    }

}
