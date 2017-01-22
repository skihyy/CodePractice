package com.yuyang.he.lc.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuyanghe
 * @date 2017年1月18日
 * @version 1.0
 * @since 2017年1月18日
 */
public class LC207_CourseSchedule
{
    public boolean canFinish(int numCourse, int[][] prerequisites)
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

        Integer curCourse = null;
        while (!queue.isEmpty())
        {
            curCourse = queue.poll();
            numCourse--;
            
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

        return 0 == numCourse;
    }

}
