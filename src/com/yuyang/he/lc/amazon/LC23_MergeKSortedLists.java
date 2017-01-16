package com.yuyang.he.lc.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author yuyanghe
 * @date 2017年1月15日
 * @version 1.0
 * @since 2017年1月15日
 */
public class LC23_MergeKSortedLists
{
    static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
        }

        public String toString()
        {
            StringBuilder sb = new StringBuilder("[");
            ListNode tmp = this;
            while (null != tmp.next)
            {
                sb.append(tmp.val);
                sb.append(",");
                tmp = tmp.next;
            }
            sb.append(tmp.val);
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args)
    {
        LC23_MergeKSortedLists s = new LC23_MergeKSortedLists();

        ListNode n1 = new LC23_MergeKSortedLists.ListNode(5), n2 = new LC23_MergeKSortedLists.ListNode(7),
                n3 = new LC23_MergeKSortedLists.ListNode(1);
        n1.next = new ListNode(5);
        n1.next.next = new ListNode(5);
        n2.next = new ListNode(9);
        n2.next.next = new ListNode(20);
        n3.next = new ListNode(9);
        n3.next.next = new ListNode(13);

        ListNode[] lists = { n1, n2, n3 };
        System.out.println(s.mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        if (null == lists || 0 == lists.length)
        {
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>()
        {
            @Override
            public int compare(ListNode o1, ListNode o2)
            {
                if (o1.val == o2.val)
                {
                    return 0;
                }
                else if (o1.val < o2.val)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
        });

        ListNode res = null, ptr = null;

        for (ListNode node : lists)
        {
            if (null != node)
            {
                queue.add(node);
            }
        }

        while (!queue.isEmpty())
        {
            if (null == res)
            {
                ptr = res = queue.poll();
            }
            else
            {
                ptr.next = queue.poll();
                ptr = ptr.next;
            }
            if (null != ptr.next)
            {
                queue.add(ptr.next);
            }
        }

        return res;
    }

}
