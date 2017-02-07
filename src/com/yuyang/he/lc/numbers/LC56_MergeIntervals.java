package com.yuyang.he.lc.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LC56_MergeIntervals
{

    public static void main(String[] args)

    {
        int[][] a = { { 362, 367 }, { 314, 315 }, { 133, 138 }, { 434, 443 }, { 202, 203 }, { 144, 145 }, { 229, 235 },
                { 205, 212 }, { 314, 323 }, { 128, 129 }, { 413, 414 }, { 342, 345 }, { 43, 49 }, { 333, 342 },
                { 173, 178 }, { 386, 391 }, { 131, 133 }, { 157, 163 }, { 187, 190 }, { 186, 186 }, { 17, 19 },
                { 63, 69 }, { 70, 79 }, { 386, 391 }, { 98, 102 }, { 236, 239 }, { 195, 195 }, { 338, 338 },
                { 169, 170 }, { 151, 153 }, { 409, 416 }, { 377, 377 }, { 90, 96 }, { 156, 165 }, { 182, 186 },
                { 371, 372 }, { 228, 233 }, { 297, 306 }, { 56, 61 }, { 184, 190 }, { 401, 403 }, { 221, 228 },
                { 203, 212 }, { 39, 43 }, { 83, 84 }, { 66, 68 }, { 80, 83 }, { 32, 32 }, { 182, 182 }, { 300, 306 },
                { 235, 238 }, { 267, 272 }, { 458, 464 }, { 114, 120 }, { 452, 452 }, { 372, 375 }, { 275, 280 },
                { 302, 302 }, { 5, 9 }, { 54, 62 }, { 237, 237 }, { 432, 439 }, { 415, 421 }, { 340, 347 },
                { 356, 358 }, { 165, 168 }, { 15, 17 }, { 259, 265 }, { 201, 204 }, { 192, 197 }, { 376, 383 },
                { 210, 211 }, { 362, 367 }, { 481, 488 }, { 59, 64 }, { 307, 315 }, { 155, 164 }, { 465, 467 },
                { 55, 60 }, { 20, 24 }, { 297, 304 }, { 207, 210 }, { 322, 328 }, { 139, 142 }, { 192, 195 },
                { 28, 36 }, { 100, 108 }, { 71, 76 }, { 103, 105 }, { 34, 38 }, { 439, 441 }, { 162, 168 },
                { 433, 433 }, { 368, 369 }, { 137, 137 }, { 105, 112 }, { 278, 280 }, { 452, 452 }, { 131, 132 },
                { 475, 480 }, { 126, 129 }, { 95, 104 }, { 93, 99 }, { 394, 403 }, { 70, 78 } };

        List<Interval> intervals = new ArrayList<Interval>();
        Arrays.asList(a).stream().forEach(i ->
        {
            intervals.add(new Interval(i[0], i[1]));
        }); 
        
        List<Interval> res = merge(intervals);
        res.stream().forEach(i ->
        {
            System.out.println(i.start + ", " + i.end);
        });
    }

    public static List<Interval> merge(List<Interval> intervals)
    {
        Map<Integer, Integer> tMap = intervals.stream().collect(Collectors.toMap(i -> i.start, i -> i.end, (i, j) -> i > j ? i : j));
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>(tMap);
        List<Interval> res = new ArrayList<Interval>();
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE, tmpLeft = -1, tmpRight = -1;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set)
        {
            if (Integer.MAX_VALUE == left && Integer.MAX_VALUE == right)
            {
                left = entry.getKey();
                right = entry.getValue();
            }
            else
            {
                tmpLeft = entry.getKey();
                tmpRight = entry.getValue();
                if (right < tmpLeft)
                {
                    res.add(new Interval(left, right));
                    left = tmpLeft;
                }
                right = right > tmpRight ? right : tmpRight;
            }
        }
        if (Integer.MAX_VALUE != left && Integer.MAX_VALUE != right)
            res.add(new Interval(left, right));
        return res;
    }

    static class Interval
    {
        int start;
        int end;

        Interval()
        {
        }

        Interval(int s, int e)
        {
            start = s;
            end = e;
        }

        public String toString()
        {
            return "[" + start + "," + end + "]";
        }
    }

}
