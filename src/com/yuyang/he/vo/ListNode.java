package com.yuyang.he.vo;

public class ListNode
{
    public int val;
    public ListNode next;

    public ListNode(int x)
    {
        val = x;
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
