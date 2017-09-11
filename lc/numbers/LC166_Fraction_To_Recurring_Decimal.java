package com.yuyang.he.lc.numbers;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuyanghe
 * @date 2017年3月9日
 * @version 1.0
 * @since 2017年3月9日
 */
public class LC166_Fraction_To_Recurring_Decimal
{
    public static void main(String[] args)
    {
        System.out.println(new LC166_Fraction_To_Recurring_Decimal().fractionToDecimal(4, 7));
    }

    public String fractionToDecimal(int numerator, int denominator)
    {
        // use Long, otherwise case -1 / Integer.MIN_VALUE will be wrong
        long lnumerator = numerator, ldenominator = denominator, reminder = lnumerator % ldenominator;
        if (0 == reminder)
            return String.valueOf(lnumerator / ldenominator);
        // consider long division situation
        // using hashmap to store possibilities
        // if long division, the numberator will definitely be repeating
        // map -> store current result and numerator
        Map<Long, Integer> map = new LinkedHashMap<Long, Integer>();
        // sb - build result
        // nsb - build numerator
        StringBuilder sb = new StringBuilder();
        if (0 > lnumerator * ldenominator)
        {
            sb.append('-');
            // reminder is computed at 1st line, so it may be negative
            if (0 > reminder)
                reminder *= -1;
            if (0 > lnumerator)
                lnumerator *= -1;
            else
                ldenominator *= -1;
        }
        // whole number part
        long wholeNumber = lnumerator / ldenominator;
        sb.append(wholeNumber);
        sb.append('.');
        // this position will be used for find the position of long devision
        int curPos = sb.length();
        while (0 != reminder && !map.containsKey(reminder))
        {
            map.put(reminder, curPos++);
            // simple mathematical division method
            lnumerator = reminder * 10;
            wholeNumber = lnumerator / ldenominator;
            reminder = lnumerator % ldenominator;
            sb.append(wholeNumber);
        }

        if (0 == reminder)
            return sb.toString();
        // the position of start of long division
        int devisionPos = map.get(reminder);
        sb.insert(devisionPos, '(');
        sb.insert(sb.length(), ')');
        return sb.toString();
    }
}
