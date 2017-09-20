package com.yuyang.he.lc.palindrome;

public class LC680_Valid_Palindrone
{

    public static void main(String[] args)
    {
        String s = "lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul";
        System.out.println(new LC680_Valid_Palindrone().validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        return valid(s) || valid(new StringBuilder(s).reverse().toString());
    }
    
    private boolean valid(String s) {
        int left = 0, right = s.length() - 1;
        boolean remove = false;
        final char [] cc = s.toCharArray();
        while(left < right)
            if(cc[left] == cc[right]) {
                left++;
                right--;
            } else if(remove)
                return false;
            else {
                if(cc[left + 1] == cc[right]) {
                    left += 2;
                    right--;
                } else if(cc[left] == cc[right - 1]) {
                    left++;
                    right -= 2;
                } else
                    return false;
                remove = true;
            }
        
        return true;
    }
}
