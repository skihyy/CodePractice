package com.yuyang.he.lc.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a set of (x, y) pairs, find the k-th nearest point to the origin.
 * 
 * @author yuyanghe
 * @date 2017年1月16日
 * @version 1.0
 * @since 2017年1月16日
 */
public class KthNearestPoint
{
    public static void main(String[] args)
    {
        Point[] p = { new Point(0, -1), new Point(0, 1), new Point(0, 2), new Point(1, 1), new Point(2, 1) };
        Point o = new Point(0, 1);
        System.out.println(new KthNearestPoint().kNearestPoint(p, o, 3));
    }

    public Point kNearestPoint(Point[] points, Point origin, int k)
    {
        Queue<Point> queue = new PriorityQueue<Point>(10, new Comparator<Point>()
        {
            @Override
            public int compare(Point o1, Point o2)
            {
                int xDis1 = o1.x - origin.x, xDis2 = o2.x - origin.x, yDis1 = o1.y - origin.y, yDis2 = o2.y - origin.y,
                        dis1 = xDis1 * xDis1 + yDis1 * yDis1, dis2 = xDis2 * xDis2 + yDis2 * yDis2;
                if (dis1 == dis2)
                {
                    return 0;
                }
                else if (dis1 < dis2)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
        });

        for (Point p : points)
        {
            queue.add(p);
        }

        int size = queue.size();
        if(size < k)
        {
            k = size;
        }

        Point res = null;
        for (int i = 0; i < k; i++)
        {
            res = queue.poll();
        }

        return res;
    }

    static class Point
    {
        int x;
        int y;

        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(this.x);
            sb.append(',');
            sb.append(this.y);
            sb.append(')');
            return sb.toString();
        }
    }

}
