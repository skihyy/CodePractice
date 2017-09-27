package com.yuyang.he.lc.string;

public class LC340_Longest_Substring_With_At_Most_K_Distinct_Characters
{

    public static void main(String[] args)
    {
        System.out.println(new LC340_Longest_Substring_With_At_Most_K_Distinct_Characters().lengthOfLongestSubstringKDistinct("ecema", 2));
    }
    
    // Space: O(1)
    // Time: O(n)
    public final int lengthOfLongestSubstringKDistinct(final String s, final int k) {
        if(null == s || s.isEmpty() || 0 == k)
            return 0;
        final char [] cc = s.toCharArray();
        // ascii[i] = the occurence time of i-th ascii character in the current sliding window
        final int [] ascii = new int[256];
        int left = 0, right = 0, max = 0, curChars = 0;
        while(right < cc.length) {
            if(0 == ascii[cc[right]]) // a new character occurs
                curChars++;
            ascii[cc[right++]]++;
            while(curChars > k) { // eliminate current characters
                ascii[cc[left]]--;
                if(0 == ascii[cc[left++]]) // this character has been removed
                    curChars--;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

}
