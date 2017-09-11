package com.yuyang.he.test;

public class Test
{

    public static void main(String[] args)
    {
        /*
         * ListNode head = new ListNode(1); head.next = new ListNode(2);
         * head.next.next = new ListNode(3); head.next.next.next = new
         * ListNode(4); head.next.next.next.next = new ListNode(5);
         * System.out.println(reverseSecondHalfList(head));
         */
        int[][] m = { { 1, 2, 3 }, { 4, 5, 6 } }, n = rotate(m);
        for(int i = 0; i < n.length; i++)
        {
            for(int j = 0; j < n[0].length; j++)
            {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] matrix)
    {
        if (null == matrix || 0 == matrix.length)
        {
            return null;
        }
        int[][] a = new int[matrix[0].length][matrix.length];

        int col = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++, col--)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                a[j][col] = matrix[i][j];
            }
        }

        int row = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++)
        {
            row = matrix[0].length - 1;
            for (int j = 0; j < matrix[0].length; j++)
            {
                a[j][i] = matrix[i][row--];
            }
        }
        
        return a;
    }

    public static ListNode reverseSecondHalfList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = null;
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            if (null == slow)
            {
                slow = head;
            }
            else
            {
                slow = slow.next;
            }
        }
        // ListNode pre = slow.next;
        ListNode pre = slow.next;
        ListNode cur = pre.next;
        while (cur != null)
        {
            pre.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = pre.next;
        }
        return head;
    }

    static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int val)
        {
            this.val = val;
        }

        public String toString()
        {
            ListNode tmp = this;
            StringBuilder sb = new StringBuilder();

            while (null != tmp)
            {
                sb.append(tmp.val + " ");
                tmp = tmp.next;
            }
            return sb.toString();
        }
    }

}
