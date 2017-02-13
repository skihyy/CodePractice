package com.yuyang.he.lc.numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author yuyanghe
 * @date 2017年2月9日
 * @version 1.0
 * @since 2017年2月9日
 */
public class LC386_LexicographicalNumbers
{
    public static void main(String[] args)
    {
        new LC386_LexicographicalNumbers().lexicalOrder(49999).stream().forEach(System.out::println);
    }

    public List<Integer> lexicalOrder(int n)
    {
        // too slow
        // return IntStream.range(1,
        // n+1).mapToObj(Integer::toString).sorted().collect(Collectors.toList()).stream()
        // .map(i -> Integer.parseInt(i)).collect(Collectors.toList());

        // too slow
        return IntStream.range(1, n + 1).boxed().sorted((i1, i2) -> (i1.toString().compareTo(i2.toString())))
                .collect(Collectors.toList());
    }

}
