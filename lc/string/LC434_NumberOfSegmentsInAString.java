package com.yuyang.he.lc.string;

import java.util.Arrays;
/**
 * @author yuyanghe
 * @date 2017年2月7日
 * @version 1.0
 * @since 2017年2月7日
 */
public class LC434_NumberOfSegmentsInAString
{
    public static void main(String[] args)
    {
        String [] ss = ", , , ,        a, eaefa".split(" ");
        Arrays.stream(ss).filter(i -> 0 < i.trim().length()).forEach(i -> System.out.println("--" + i + "--"));
    }
    
    public int countSegments(String s) {
        String [] ss = s.split(" ");
        return (int) Arrays.stream(ss).filter(i -> 0 < s.trim().length()).count();
    }

}
