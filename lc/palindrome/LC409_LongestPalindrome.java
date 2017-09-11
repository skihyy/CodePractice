package com.yuyang.he.lc.palindrome;

import java.util.Arrays;

/**
 * @author yuyanghe
 * @date 2017年1月13日
 * @version 1.0
 * @since 2017年1月13日
 */
public class LC409_LongestPalindrome
{
    public static void main(String[] args)
    {
        System.out.println(new LC409_LongestPalindrome().longestPalindrome(
                "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public int longestPalindrome(String s) {
        int [] cts = new int[128];
        Arrays.fill(cts, 0);
        
        char [] cc = s.toCharArray();
        
        for(char c : cc)
        {
            cts[c]++;
        }
        
        int curCt = 0;
        
        for(int i : cts)
        {
            curCt += (i / 2) * 2;
        }
        
        return s.length() == curCt ? curCt : curCt + 1;
    }
}
