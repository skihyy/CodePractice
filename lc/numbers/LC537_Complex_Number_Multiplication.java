package com.yuyang.he.lc.numbers;

public class LC537_Complex_Number_Multiplication
{

    public static void main(String[] args)
    {
        System.out.println(new LC537_Complex_Number_Multiplication().complexNumberMultiply("78+-76i", "-86+72i"));
    }
    
    public final String complexNumberMultiply(final String a, final String b) {
        final int [] n1 = helper(a), n2 = helper(b);
        final int real = n1[0] * n2[0] - n1[1] * n2[1], comp = n1[1] * n2[0] + n2[1] * n1[0];
        final StringBuilder sb = new StringBuilder();
        sb.append(real);
        sb.append("+");
        sb.append(comp);
        sb.append('i');
        return sb.toString();
    }
    
    private int [] helper(String n) {
        final String [] parts = n.split("\\+");
        parts[1] = parts[1].substring(0, parts[1].length() - 1);
        return new int[] {Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }

}
