package com.yuyang.he.lc.amazon;

/**
 * @author yuyanghe
 * @date 2017年1月16日
 * @version 1.0
 * @since 2017年1月16日
 */
public class LC138_CopyListwithRandomPointer
{
    public static void main(String[] args)
    {
        System.out.println(new LC138_CopyListwithRandomPointer().copyRandomList(new RandomListNode(1)));
    }

    public RandomListNode copyRandomList(RandomListNode head)
    {
        if (null == head)
        {
            return null;
        }

        RandomListNode root = head, tmp = root;

        while (null != root)
        {
            tmp = root.next;
            root.next = new RandomListNode(root.label);
            root.next.next = tmp;
            root = root.next.next;
        }

        root = head;
        while (null != root)
        {
            root.next.random = null == root.random ? null : root.random.next;
            root = root.next.next;
        }

        RandomListNode ori = head;
        root = tmp = head.next;
        while(null != ori)
        {
            ori.next = ori.next.next;
            ori = ori.next;
            tmp.next = null == tmp.next ? null : tmp.next.next;
            tmp = tmp.next;
        }

        return root;
    }

    static class RandomListNode
    {
        int label;
        RandomListNode next = null, random = null;

        RandomListNode(int val)
        {
            label = val;
        }

        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            RandomListNode tmp = this;
            while (null != tmp.next)
            {
                sb.append(tmp.label);
                sb.append("(");
                if (null != tmp.random)
                {
                    sb.append(tmp.random.label);
                }
                sb.append("), ");
                tmp = tmp.next;
            }
            sb.append(tmp.label);
            sb.append("(");
            if (null != tmp.random)
            {
                sb.append(tmp.random.label);
            }
            sb.append(")]");
            return sb.toString();
        }
    }
}
