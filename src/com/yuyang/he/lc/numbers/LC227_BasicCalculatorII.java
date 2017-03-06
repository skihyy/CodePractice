package com.yuyang.he.lc.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC227_BasicCalculatorII
{

    public static void main(String[] args)
    {
        System.out.println(new LC227_BasicCalculatorII().calculate("1*3"));
    }

    public int calculate(String s)
    {
        int len = s.length();
        Stack<String> stack = new Stack<String>();
        char c = '/';
        StringBuilder sb = new StringBuilder();
        boolean needCompute = false;
        int i1 = -1, i2 = -1;
        String op = null;
        for (int i = 0; i < len; i++)
        {
            c = s.charAt(i);
            if (' ' == c)
                continue;
            if ('0' <= c && '9' >= c)
            {
                sb.append(c);
                continue;
            }

            // now it is a operator, not a number
            stack.add(sb.toString());
            sb.setLength(0);

            if (needCompute)
            {
                needCompute = false;
                i2 = Integer.parseInt(stack.pop());
                op = stack.pop();
                i1 = Integer.parseInt(stack.pop());
                switch (op)
                {
                    case "*":
                        i1 *= i2;
                        break;
                    case "/":
                        i1 /= i2;
                        break;
                }
                stack.add(Integer.toString(i1));
            }

            // put operator into stack
            stack.add(Character.toString(c));
            if ('*' == c || '/' == c)
                needCompute = true;
        }

        // put the last number
        stack.add(sb.toString());
        
        if (needCompute)
        {
            needCompute = false;
            i2 = Integer.parseInt(stack.pop());
            op = stack.pop();
            i1 = Integer.parseInt(stack.pop());
            switch (op)
            {
                case "*":
                    i1 *= i2;
                    break;
                case "/":
                    i1 /= i2;
                    break;
            }
            stack.add(Integer.toString(i1));
        }
        
        List<String> list = new ArrayList<String>();
        while (!stack.isEmpty())
            list.add(stack.pop());

        int size = list.size(), res = 0 == size ? 0 : Integer.parseInt(list.get(size - 1));
        for (int i = size - 2; i >= 0; i -= 2)
        {
            op = list.get(i);
            i2 = Integer.parseInt(list.get(i - 1));
            switch (op)
            {
                case "+":
                    res += i2;
                    break;
                case "-":
                    res -= i2;
                    break;
            }
        }
        return res;
    }

}
