package com.yuyang.he.lc.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC648_Replace_Words
{

    public static void main(String[] args)
    {
        System.out.println(new LC648_Replace_Words().replaceWords(
                Arrays.asList("uxbiw", "pb", "zmeno", "bj", "tdjn", "fcomt", "rdd", "z", "d", "i", "gxmxj", "swga", "t",
                        "g", "bjoz", "siyi", "fpp", "gpied", "qjf", "h", "dorm", "zd", "gx", "viczg", "dewq", "tz",
                        "dwyxy", "o", "rtcq", "j"),
                "cfrbiqbqzveiczjn miwz hv uslvci vuhgzbulkiurzxkiqe nqg rccocvwfp sntmlrrdsqwpvem iyrw kbqwjkfichfrejx lhzylxmbptiwmn v nodg xijddmenifxaffhxxx hpltrapstesvkrnjoqdl mygwsjmgzzoixyo xcnyhbmpkpamtzdrjls wtuddincttwfnai cgxlvdww yqhnapyzkv nmrvpd poimszzov epmiddarizx tlhkwz pqq ardwiezm iowkiammwm ewlotixpfsbhkwphaiv ehitgi eczvbyheauzvho"));
    }

    public final String replaceWords(final List<String> dict, final String sentence)
    {
        if (0 == dict.size())
            return sentence;

        final StringBuilder sb = new StringBuilder();
        Collections.sort(dict);
        final int max = dict.stream().max(Comparator.comparingInt(String::length)).get().length(), min = dict.stream().min(Comparator.comparingInt(String::length)).get().length();
        final String[] words = sentence.split(" ");
        for (String word : words)
        {
            final int w_size = word.length();
            boolean append = false;
            for (int i = min; i <= max && i < w_size; i++)
            {
                final String prefix = word.substring(0, i);
                if (dict.contains(prefix))
                {
                    sb.append(prefix);
                    append = true;
                    break;
                }
            }
            if (!append)
                sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
