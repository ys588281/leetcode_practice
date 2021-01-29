package com.vincent.amazon.oa;

import java.util.LinkedList;

public class CPURoundRobin {

    public static void main(String[] args) {
        System.out.println(CPURoundRobin(new int[]{0,1,4}, new int[]{5,2,3}, 3));
    }

    public static double CPURoundRobin(int[] arrive, int[] excute, int q) {
        LinkedList<Process> queue = new LinkedList<>();
        int curTime = 0;
        int waitTime = 0;
        int nextProIdx = 0;
        while (!queue.isEmpty() || nextProIdx < arrive.length) {
            if (!queue.isEmpty()) {
                Process cur = queue.poll();
                waitTime += curTime - cur.arriveTime;
                curTime += Math.min(cur.excuteTime, q);
                for (int i = nextProIdx; i < arrive.length; i ++) {
                    if (arrive[i] <= curTime) {
                        queue.offer(new Process(arrive[i], excute[i]));
                        nextProIdx = i + 1;
                    } else {
                        break;
                    }
                }
                if (cur.excuteTime > q) {
                    queue.offer(new Process(curTime, cur.excuteTime - q));
                }
            } else {
                queue.offer(new Process(arrive[nextProIdx], excute[nextProIdx]));
                curTime = arrive[nextProIdx ++];
            }
        }
        return (double)waitTime / arrive.length;
    }
}

class Process {
    int arriveTime;
    int excuteTime;

    public Process(int arriveTime, int executeTime) {
        this.arriveTime = arriveTime;
        this.excuteTime = executeTime;
    }
}
