package com.yuyang.he.lc.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author yuyanghe
 * @date 2017年1月15日
 * @version 1.0
 * @since 2017年1月15日
 */
public class LC155_MinStack
{
    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;
    private Queue<Integer> queue = null;

    /** initialize your data structure here. */
    public LC155_MinStack()
    {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        queue = new PriorityQueue<Integer>();
     }

    public void push(int x)
    {
        list.add(x);
        map.put(x, list.size() - 1);
        queue.add(x);
    }

    public void pop()
    {
        int index = list.size() - 1;
        Integer i = list.get(index);
        list.remove(index);
        map.remove(i);
        queue.remove(i);
    }

    public int top()
    {
        return list.get(list.size() - 1);
    }

    public int getMin()
    {
        return queue.peek();
    }
}
