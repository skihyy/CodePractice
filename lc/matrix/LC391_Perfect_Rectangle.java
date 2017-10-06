package com.yuyang.he.lc.matrix;

import java.util.HashSet;
import java.util.Set;

public class LC391_Perfect_Rectangle
{

    public static void main(String[] args)
    {
        System.out.println(new LC391_Perfect_Rectangle().isRectangleCover(new int[][] {{1,1,3,3}, {3,1,4,2}, {3,2,4,4}, {1,3,2,4}, {2,3,3,4}}));
    }

    public final boolean isRectangleCover(int[][] rectangles) {
        if(null == rectangles || 0 == rectangles.length || 0 == rectangles[0].length)
            return false;
        // find out the coordinates of the large rectangle
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, top =  Integer.MIN_VALUE, bottom = Integer.MAX_VALUE, area = 0;
        // every points should exactly appear twice
        Set<String> set = new HashSet<> ();
        for(final int [] rectangle : rectangles) {
            left = Math.min(left, rectangle[0]);
            bottom = Math.min(bottom, rectangle[1]);
            right = Math.max(right, rectangle[2]);
            top = Math.max(top, rectangle[3]);
            
            // coordinates should appear twice except the corners
            // first time add in
            // second time remove it
            final String leftBottom = rectangle[0] + "," + rectangle[1], rightTop = rectangle[2] + "," + rectangle[3], leftTop = rectangle[0] + "," + rectangle[3], rightBottom = rectangle[2] + "," + rectangle[1];
            if(!set.add(leftBottom))
                set.remove(leftBottom);
            if(!set.add(rightTop))
                set.remove(rightTop);
            if(!set.add(leftTop))
                set.remove(leftTop);
            if(!set.add(rightBottom))
                set.remove(rightBottom);
            
            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
        }
        
        // area should the same
        return 4 == set.size() && set.contains(left + "," + top) && set.contains(left + "," + bottom) && set.contains(right + "," + top) && set.contains(right + "," + bottom)  && area == (right - left) * (top - bottom);
    }
}
