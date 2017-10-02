package com.yuyang.he.lc.ood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC271_Encode_And_Decode_Strings
{

    public static void main(String[] args)
    {
        LC271_Encode_And_Decode_Strings lc271 = new LC271_Encode_And_Decode_Strings();
        String en = lc271.encode(new ArrayList<> ());
        System.out.println(lc271.decode(en));
        en = lc271.encode(Arrays.asList("",""));
        System.out.println(lc271.decode(en));
    }
    
    private final StringBuilder sb = new StringBuilder ();

    // Encodes a list of strings to a single string.
    public final String encode(final List<String> strs) {
        sb.setLength(0);
        for(final String s : strs) {
            if("".equals(s))
                sb.append("=");
            final char [] cc = s.toCharArray();
            for(final char c : cc) {
                sb.append((int) c);
                sb.append('_');
            }
            sb.append(',');
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public final List<String> decode(final String serilized) {
        final List<String> res = new ArrayList<> ();
        final String [] strs = serilized.split(",");
        for(final String str : strs) {
            final String [] ss = str.split("_");
            sb.setLength(0);
            for(String s : ss) 
                if(!s.isEmpty())
                    if("=".equals(s))
                        sb.append("");
                    else
                        sb.append((char)Integer.parseInt(s));
            res.add(sb.toString());
        }
        return res;
    }

}
