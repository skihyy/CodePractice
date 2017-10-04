package com.yuyang.he.lc.string;

public class LC681_Next_Closest_Time
{

    public static void main(String[] args)
    {
        System.out.println(new LC681_Next_Closest_Time().nextClosestTime("23:59"));
    }

    private String result = "";
    private int diff = 1440, hr, min; // one day is 1440 min
    
    public final String nextClosestTime(final String time) {
        final int [] digit = new int[4];
        final String [] times = time.split(":");
        final int hour = Integer.parseInt(times[0]), minute = Integer.parseInt(times[1]);
        digit[0] = hour / 10;
        digit[1] = hour % 10;
        digit[2] = minute / 10;
        digit[3] = minute % 10;
        hr = hour;
        min = minute;
        dfs(digit, 0, new int[4]);
        return result;
    }
    
    private void dfs(final int [] digit, final int cur, final int[] now) {
        for(int i = 0; i < 4; i++) {
            now[cur] = digit[i];
            if(1 == cur) {
                final int hour = 10 * now[0] + now[1];
                if(0 <= hour && 23 >= hour)
                    dfs(digit, 2, now);
            } else if(3 == cur) {
                final int minute = 10 * now[2] + now[3];
                if(0 <= minute && 59 >= minute) {
                    final int hour = 10 * now[0] + now[1], newDiff = diff(hour, minute);
                    result = diff > newDiff ? getTime(hour, minute) : result;
                    diff = Math.min(diff, newDiff);
                }
            } else 
                dfs(digit, cur + 1, now);
        }
    }
    
    private int diff(final int hour, final int minute) {
        final int diff = 60 * (hour - hr) + minute - min;
        return 0 == diff ? 1440 : 0 > diff ? diff + 1440 : diff;
    }
    
    private String getTime(final int hour, final int minute) {
        return 10 > hour ? "0" + hour + ":" + minute : hour + ":" + minute;
    }

}
