package com.yuyang.he.lc.bitmanipulation;

public class LC393_UTF_8_Validation
{

    public static void main(String[] args)
    {
        System.out.println(new LC393_UTF_8_Validation().validUtf8(new int[] { 197, 130, 1 }));
    }
    
    // Space: O(1)
    // Time: O(n)
    public final boolean validUtf8(final int[] data) {
        if(null == data || 0 == data.length)
            return false;
        for(int i = 0; i < data.length; i++) { 
            int utfParts = 1; // at least it is 1
            // first, check which UTF-8 it belongs to
            // 0xxxxxxx <= 127
            // 110xxxxx 10xxxxxx the 1st one starts at 192, so (111) = 224 if 224 & part != 192, it's not utf-8
            // 1110xxxx 10xxxxxx 10xxxxxx the 1st one & 224
            // 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx the 1st one & 240
            if(240 == (248 & data[i]))
                utfParts = 4;
            else if(224 == (240 & data[i]))
                utfParts = 3;
            else if(192 == (224 & data[i]))
                utfParts = 2;
            else if(127 < data[i]) // if it is not a valid one-byte 0xxxxxxx utf-8
                return false;
            
            // only check 2nd, 3rd and 4th part
            // each of them should start at 10xxxxxx
            int k = 1;
            for(; k < utfParts; k++)
                if(data.length <= i + k || 128 != (192 & data[i + k]))
                    return false;
            
            i += k - 1;
        }
        return true;
    }

}
