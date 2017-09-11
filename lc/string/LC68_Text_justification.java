package com.yuyang.he.lc.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyanghe
 * @date 2017年1月19日
 * @version 1.0
 * @since 2017年1月19日
 */
public class LC68_Text_justification
{
    public static void main(String[] args)
    {
        String[] s = { "example", "of", "test","aaaaaaaaaaaaaaaaaaa" };
        List<String> res = new LC68_Text_justification().fullJustify(s, 20);

        for (int i = 0; i < res.size(); i++)
        {
            System.out.println("|" + res.get(i) + "|");
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth)
    {
        int curLen = 0, wordLen = 0, curRow = 0;
        int[] wordsPos = new int[words.length];
        for (int i = 0; i < words.length; i++)
        {
            wordLen = words[i].length();
            if (maxWidth >= curLen + wordLen)
            {
                curLen += wordLen + 1;
            }
            else
            {
                curRow++;
                curLen = wordLen + 1;
            }
            wordsPos[i] = curRow;
        }

        List<String> res = new ArrayList<String>();
        int left = 0, right = 0, numOfWordsInRow = 0, blks = maxWidth, moreBlks = 0;
        curRow = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= words.length; i++)
        {
            if (i != words.length && curRow == wordsPos[i])
            {
                right = i;
                blks -= words[i].length();
                numOfWordsInRow++;
                continue;
            }

            if (i == words.length || curRow != wordsPos[i])
            {
                if (1 < numOfWordsInRow)
                {
                    moreBlks = blks % (numOfWordsInRow - 1);
                    blks /= (numOfWordsInRow - 1);
                }
                for (int j = left; j <= right; j++)
                {
                    sb.append(words[j]);
                    if (right != j)
                    {
                        if (i != words.length)
                        {
                            for (int k = 0; k < blks; k++)
                            {
                                sb.append(' ');
                            }
                            if(0 < moreBlks)
                            {
                                sb.append(' ');
                                moreBlks--;
                            }
                        }
                        else
                        {
                            sb.append(' ');
                        }
                    }
                }
                wordLen = sb.length();
                for (int j = wordLen; j < maxWidth; j++)
                {
                    sb.append(' ');
                }

                res.add(sb.toString());
                sb.setLength(0);

                if (i != words.length)
                {
                    wordLen = words[i].length();
                    if (0 == maxWidth - wordLen)
                    {
                        blks = 0;
                    }
                    else
                    {
                        blks = maxWidth - wordLen;
                    }
                    numOfWordsInRow = 1;
                    left = right = i;
                    curRow++;
                }
            }
        }

        return res;
    }
}
