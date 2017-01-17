package com.yuyang.he.lc.amazon;

public class RoundRobin
{

    public static void main(String[] args)
    {
        // int[] a = { 0, 2, 4, 5 }, b = { 7, 4, 1, 4 };
        // int[] a = { 0, 1, 3, 9 }, b = { 2, 1, 7, 5 };
        int[] a = { 0, 1, 4 }, b = { 5, 2, 3 };
        System.out.println(new RoundRobin().waitingTime(a, b, 3));
    }

    public float waitingTime(int[] requestTimes, int[] executionTimes, int interval)
    {
        if (null == requestTimes || 0 == requestTimes.length || null == executionTimes || 0 == executionTimes.length
                || requestTimes.length != executionTimes.length)
        {
            return 0;
        }

        int[] workingTimes = new int[executionTimes.length], lastActiveEndTime = new int[executionTimes.length];
        for (int i = 0; i < executionTimes.length; i++)
        {
            workingTimes[i] = executionTimes[i];
            lastActiveEndTime[i] = requestTimes[i];
        }

        // current work index
        int curIndex = 0, curTime = 0, waitingTime = 0;
        while (true)
        {
            curIndex = (curIndex + 1) % requestTimes.length;

            if (checkForCompletion(workingTimes))
            {
                break;
            }

            // must has received the job in order to start
            if (curTime >= requestTimes[curIndex] && 0 < executionTimes[curIndex])
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
                waitingTime += checkWaitingTime(requestTimes, workingTimes, lastActiveEndTime, curTime, curIndex);
                lastActiveEndTime[curIndex] = curTime;
            }
        }

        return ((float) waitingTime) / requestTimes.length;
    }

    private int checkWaitingTime(int[] requestTimes, int[] workingTimes, int[] lastActiveEndTime, int curTime,
            int curIndex)
    {
        int waitingTime = 0;

        for (int i = 0; i < requestTimes.length; i++)
        {
            if (i != curIndex && curTime >= requestTimes[i] && 0 < workingTimes[i])
            {
                waitingTime += (curTime - lastActiveEndTime[i]);
                lastActiveEndTime[i] = curTime;
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
