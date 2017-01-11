package com.yuyang.he.lc.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC15_ThreeSum
{

    public static void main(String[] args)
    {
        int[] a = { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
        System.out.println(new LC15_ThreeSum().threeSum(a));
    }

    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int low = -1, high = -1, sum = -1;

        for (int i = 0; i < nums.length - 2; i++)
        {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1]))
            {
                low = i + 1;
                high = nums.length - 1;
                sum = nums[i] * -1;

                while (low < high)
                {
                    if (nums[low] + nums[high] == sum)
                    {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[low + 1])
                        {
                            low++;
                        }

                        while (low < high && nums[high - 1] == nums[high])
                        {
                            high--;
                        }
                    }
                    else if (nums[low] + nums[high] < sum)
                    {
                        low++;
                    }
                    else
                    {
                        high--;
                    }
                }
            }
        }

        return res;
    }
}
