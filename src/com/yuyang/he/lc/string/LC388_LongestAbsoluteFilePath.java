package com.yuyang.he.lc.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyanghe
 * @date 2017年2月23日
 * @version 1.0
 * @since 2017年2月23日
 */
public class LC388_LongestAbsoluteFilePath
{

    public static void main(String[] args)
    {
        System.out.println(
                new LC388_LongestAbsoluteFilePath().lengthLongestPath("dir\n\tfile.txt"));
    }

    public int lengthLongestPath(String input)
    {
        int res = 0;
        String[] paths = input.split("\n");
        List<String> dirs = new ArrayList<String>();
        for (int i = 0; i < paths.length; i++)
        {
            // length of \t
            //int tLen = 0 == i ? 0 : paths[i].length() - paths[i].trim().length();
            int tLen = paths[i].lastIndexOf("\t") + 1;
            if (0 == tLen)
                dirs.clear();
            else
                dirs = dirs.subList(0, tLen);

            if (paths[i].contains(".")) // is a file
            {
                int len = dirs.stream().map(s -> s.length()).reduce(0, Integer::sum) + paths[i].trim().length();
                res = Math.max(len, res);
            }
            else // a directory
                dirs.add(paths[i].trim() + "/");
        }
        return res;
    }

}
