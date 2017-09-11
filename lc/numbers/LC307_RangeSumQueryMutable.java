package com.yuyang.he.lc.numbers;

/**
 * @author yuyanghe
 * @date 2017年3月9日
 * @version 1.0
 * @since 2017年3月9日
 */
public class LC307_RangeSumQueryMutable
{
    public static void main(String[] args)
    {
        int[] a = { 1, 3, 5 };
        LC307_RangeSumQueryMutable instance = new LC307_RangeSumQueryMutable(a);
        instance.update(1, 2);
        System.out.println(instance.sumRange(2, 2));
    }

    // binary index tree
    private int[] nums;
    private int[] tree;

    public LC307_RangeSumQueryMutable(int[] nums)
    {
        this.nums = nums;
        tree = new int[nums.length + 1];
        int treePos = -1;
        // start from position 1
        // 0 will lead to exception
        for (int i = 1; i < tree.length; i++)
        {
            treePos = lowBit(i);
            for (int j = i - treePos + 1; j <= i; j++)
                tree[i] += nums[j - 1];
        }
    }

    // return 2^k, where k is the length of 0 in binary i on the right side
    private int lowBit(int i)
    {
        return i & (-i);
    }

    // i is (i + 1)th element in the tree since tree[0] is not used
    public void update(int i, int val)
    {
        int diff = val - nums[i];
        nums[i] = val;
        i++;
        while (tree.length > i)
        {
            tree[i] += diff;
            i += lowBit(i);
        }
    }

    /**
     * @param i don't plus one since i should be included in the result, so now i is actually the previous one
     * @param j need to plus one to include the tail
     * @return
     */
    public int sumRange(int i, int j)
    {
        return sum(++j) - sum(i);
    }

    private int sum(int i)
    {
        int sum = 0;
        while (0 < i)
        {
            sum += tree[i];
            i -= lowBit(i);
        }
        return sum;
    }
}
