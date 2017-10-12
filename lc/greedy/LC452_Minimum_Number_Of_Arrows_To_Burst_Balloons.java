package com.yuyang.he.lc.greedy;

import java.util.Arrays;

public class LC452_Minimum_Number_Of_Arrows_To_Burst_Balloons
{

    public static void main(String[] args)
    {
        final int [][] r = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(new LC452_Minimum_Number_Of_Arrows_To_Burst_Balloons().findMinArrowShots(r));
    }
    
    // time O(nlogn) <- sort
    // space O(1)
    public int findMinArrowShots(int[][] points) {
        if(null == points || 0 == points.length)
            return 0;
        
        Arrays.sort(points, (i, j) -> i[0] == j[0] ? Integer.compare(i[1], j[1]) : Integer.compare(i[0], j[0]));
        // find intersections
        // same as meeting rooms
        int arrows = 1, lastEnd = points[0][1];
        for(int i = 1; i < points.length; i++)
            if(points[i][0] > lastEnd) {
                lastEnd = points[i][1];
                arrows++;
            } else
                lastEnd = lastEnd < points[i][1] ? lastEnd : points[i][1];
        return arrows;
    }

}
