package com.yuyang.he.lc.graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author yuyanghe
 * @date 2017年1月18日
 * @version 1.0
 * @since 2017年1月18日
 */
public class LC406_QueueReconstructionByHeight
{
    public static void main(String[] args)
    {
        int[][] people = { { 8, 2 }, { 4, 2 }, { 4, 5 }, { 2, 0 }, { 7, 2 }, { 1, 4 }, { 9, 1 }, { 3, 1 }, { 9, 0 },
                { 1, 0 } };
        new LC406_QueueReconstructionByHeight().reconstructQueue(people);
    }

    public int[][] reconstructQueue(int[][] people)
    {
        if (null == people || 1 >= people.length || 2 != people[0].length)
        {
            return people;
        }

        Queue<int[]> queue = new PriorityQueue<int[]>(10, new Comparator<int[]>()
        {
            public int compare(int[] o1, int[] o2)
            {
                return new Integer(o1[0]).compareTo(new Integer(o2[0]));
            }
        });
        int[][] res = new int[people.length][2];
        int[] tmp = null;
        int curIndex = 0, numOfPeopleAtThisHeight = 0, curCount = 0;

        while (res.length > curIndex)
        {
            for (int[] person : people)
            {
                if (numOfPeopleAtThisHeight == person[1])
                {
                    queue.add(person);
                    curCount++;
                }
            }

            while (!queue.isEmpty())
            {
                tmp = queue.poll();
                res[curIndex][0] = tmp[0];
                res[curIndex++][1] = tmp[1];
            }

            numOfPeopleAtThisHeight = curCount;
            curCount = 0;
        }

        return res;
    }
}
