package com.yuyang.he.lc.arrayAndList;

import com.yuyang.he.vo.ListNode;

/**
 * @author yuyanghe
 * @date 2017年1月24日
 * @version 1.0
 * @since 2017年1月24日
 */
public class LC82_RemoveDuplicatesFromSortedListII
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);

        System.out.println(new LC82_RemoveDuplicatesFromSortedListII().deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head)
    {
        if (null == head || null == head.next)
        {
            return head;
        }

        ListNode fHead = new ListNode(5);
        fHead.next = head;
        
        ListNode pre = fHead, cur = head;
        
        while(null != cur)
        {
            while(null != cur.next && cur.val == cur.next.val)
            {
                cur = cur.next;
            }
            
            if(cur == pre.next)
            {
                pre = pre.next;
            }
            else
            {
                pre.next = cur.next;
            }
            
            cur = cur.next;
        }

        return fHead.next;
    }
}
