package com.yuyang.he.vo;

public class ListNode
{
    public int val;
    public ListNode next;

    public ListNode(int x)
    {
        val = x;
    }

    public ListNode(String s)
    {
        char[] cc = s.toCharArray();
        ListNode tmp = this;
        for (int i = 0; i < cc.length; i++)
        {
            if (0 == i)
                val = cc[i] - '0';
            else
            {
                tmp.next = new ListNode(cc[i] - '0');
                tmp = tmp.next;
            }
        }
    }

    public String toString()
    {
        ListNode tmp = this;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (null != tmp.next)
        {
            sb.append(tmp.val);
            sb.append(',');
            tmp = tmp.next;
        }
        sb.append(tmp.val);
        sb.append(']');
        return sb.toString();
    }
}
