package com.yuyang.he.lc.amazon;

public class LC92_ReverseLinkedListII
{

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);

        System.out.println(new LC92_ReverseLinkedListII().reverseBetween(head, 1, 1));
    }

    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        int ct = 1;
        ListNode res = null, tmp = head, resTmp = null, reverse = null, rTmp = null;

        while (null != tmp)
        {
            if (ct < m || ct > n)
            {
                if (n + 1 == ct)
                {
                    if (null == res)
                    {
                        res = resTmp = reverse;
                    }
                    else
                    {
                        resTmp.next = reverse;
                    }
                    reverse = null;

                    while (null != resTmp.next)
                    {
                        resTmp = resTmp.next;
                    }
                }

                if (null == res)
                {
                    resTmp = res = new ListNode(tmp.val);
                }
                else
                {
                    resTmp.next = new ListNode(tmp.val);
                    resTmp = resTmp.next;
                }
            }
            else
            {
                rTmp = new ListNode(tmp.val);
                if (null == reverse)
                {
                    reverse = rTmp;
                }
                else
                {
                    rTmp.next = reverse;
                    reverse = rTmp;
                }
            }
            ct++;
            tmp = tmp.next;
        }
        
        if(null == res)
        {
            res = reverse;
        }
        else
        {
            resTmp.next = reverse;
        }

        return res;
    }

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
            StringBuilder sb = new StringBuilder();
            ListNode tmp = this;

            sb.append('[');
            while (null != tmp.next)
            {
                sb.append(tmp.val);
                sb.append(",");
                tmp = tmp.next;
            }
            sb.append(tmp.val);
            sb.append(']');
            return sb.toString();
        }
    }
}
