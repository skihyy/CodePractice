package com.yuyang.he.lc.linkedlist;

import com.yuyang.he.vo.ListNode;

/**
 * @author yuyanghe
 * @date 2017年2月28日
 * @version 1.0
 * @since 2017年2月28日
 */
public class LC445_Add_Two_Numbers_II
{

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode("319210852"), l2 = new ListNode("216196648");

        System.out.println(new LC445_Add_Two_Numbers_II().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if (null == l1)
            return l2;
        else if (null == l2)
            return l1;

        ListNode l1r = reverse_hard(l1), l2r = reverse_hard(l2);
        boolean isTen = false;
        ListNode res = null, cur = null, tmp = null;
        while (null != l1r || null != l2r)
        {
            if (null == res)
            {
                cur = res = new ListNode(l1r.val + l2r.val);
                if (10 <= res.val)
                {
                    res.val -= 10;
                    isTen = true;
                }
            }
            else
            {
                if (null != l1r && null != l2r)
                    tmp = new ListNode(l1r.val + l2r.val);
                else if (null == l2r)
                    tmp = new ListNode(l1r.val);
                else
                    tmp = new ListNode(l2r.val);
                if (isTen)
                {
                    tmp.val += 1;
                    isTen = false;
                }
                if (10 <= tmp.val)
                {
                    tmp.val -= 10;
                    isTen = true;
                }
                cur.next = tmp;
                cur = cur.next;
            }
            if (null != l1r)
                l1r = l1r.next;
            if (null != l2r)
                l2r = l2r.next;
        }
        if (isTen)
            cur.next = new ListNode(1);

        return reverse_hard(res);
    }

    private ListNode reverse_hard(ListNode l)
    {
        ListNode t = l, res = null, tmp = null;
        while (null != t)
        {
            tmp = new ListNode(t.val);
            tmp.next = res;
            res = tmp;
            t = t.next;
        }
        return res;
    }

}
