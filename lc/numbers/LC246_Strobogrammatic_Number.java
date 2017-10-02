package com.yuyang.he.lc.numbers;

public class LC246_Strobogrammatic_Number
{

    public static void main(String[] args)
    {
        System.out.println(new LC246_Strobogrammatic_Number().isStrobogrammatic("69"));
    }
    
    public final boolean isStrobogrammatic(final String num) {
        final char [] cc = num.toCharArray();
        int left = 0, right = cc.length - 1;
        while(left < right) {
            if(!('1' == cc[left] || '6' == cc[left] || '8' == cc[left] || '9' == cc[left]))
                return false;
            if(cc[left] != cc[right])
                if(!(('9' == cc[left] && '6' == cc[right]) || ('6' == cc[left] && '9' == cc[right])))
                    return false;
            left++;
            right--;
        }
        // check midian
        if(!(left == right && '1' == cc[left] || '8' == cc[left]))
            return false;
        return true;
    }

}
