package com.yuyang.he.lc.amazon;

/**
 * @author yuyanghe
 * @date 2017年1月17日
 * @version 1.0
 * @since 2017年1月17日
 */
public class ShortestJobFirst
{
    public static void main(String[] args)
    {
        // int[] a = { 0, 2, 4, 5 }, b = { 7, 4, 1, 4 };
        // int[] a = { 0, 1, 3, 9 }, b = { 2, 1, 7, 5 };
        int[] a = { 0, 1, 4 }, b = { 5, 2, 3 };
        System.out.println(new ShortestJobFirst().waitingTime(a, b, 3));
    }

    public float waitingTime(int[] requestTimes, int[] executionTimes, int interval)
    {
        if (null == requestTimes || 0 == requestTimes.length || null == executionTimes || 0 == executionTimes.length
                || 0 >= interval || requestTimes.length != executionTimes.length)
        {
            return -1;
        }

        int[] workingTimes = new int[executionTimes.length], lastActiveEndTimes = new int[requestTimes.length];
        for (int i = 0; i < requestTimes.length; i++)
        {
            workingTimes[i] = executionTimes[i];
            lastActiveEndTimes[i] = requestTimes[i];
        }

        int curTime = 0, waitingTime = 0, curIndex = 0;
        while (true)
        {
            curIndex = pickShortestJob(curTime, requestTimes, workingTimes);

            if (checkForCompletion(workingTimes))
            {
                break;
            }

            if (curTime >= requestTimes[curIndex] && 0 != workingTimes[curIndex])
            {
                if (0 <= workingTimes[curIndex] - interval)
                {
                    curTime += interval;
                    workingTimes[curIndex] -= interval;
                }
                else
                {
                    curTime += workingTimes[curIndex];
                    workingTimes[curIndex] = 0;
                }
                waitingTime += checkWaitingTime(curTime, requestTimes, workingTimes, lastActiveEndTimes, curIndex);
                lastActiveEndTimes[curIndex] = curTime;
            }
        }

        return ((float) waitingTime) / requestTimes.length;
    }

    private int pickShortestJob(int curTime, int[] requestTimes, int[] remainTimes)
    {
        int curIndex = 0;
        for(int i = 0; i < requestTimes.length; i++)
        {
            if(curTime > requestTimes[i] && 0 < remainTimes[i])
            {
                curIndex = i;
                break;
            }
        }
        
        int curMinTime = remainTimes[curIndex];
        
        for (int i = 0; i < requestTimes.length; i++)
        {
            if (curMinTime > remainTimes[i] && curTime >= requestTimes[i] && 0 < remainTimes[i])
            {
                curMinTime = remainTimes[i];
                curIndex = i;
            }
        }
        return curIndex;
    }

    private int checkWaitingTime(int curTime, int[] requestTimes, int [] remainTimes, int[] lastActiveEndTimes, int curIndex)
    {
        int waitingTime = 0;
        for (int i = 0; i < lastActiveEndTimes.length; i++)
        {
            if (curIndex != i && curTime >= requestTimes[i] && 0 < remainTimes[i])
            {
                waitingTime += curTime - lastActiveEndTimes[i];
                lastActiveEndTimes[i] = curTime;
            }
        }
        return waitingTime;
    }

    private boolean checkForCompletion(int[] remainTimes)
    {
        for (int i = 0; i < remainTimes.length; i++)
        {
            if (0 != remainTimes[i])
            {
                return false;
            }
        }
        return true;
    }
}
