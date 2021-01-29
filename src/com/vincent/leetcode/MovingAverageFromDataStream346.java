package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream346 {

    public static void main(String[] args) {

    }

    class MovingAverageFromDataStream {
        private int size;
        private Queue<Integer> streams;
        private int total;
        private int average;

        public MovingAverageFromDataStream(int size) {
            this.size = size;
            streams = new LinkedList<>();
            this.total = 0;
            this.average = 0;
        }

        public int next(int input) {
            streams.add(input);
            total += input;
            if (streams.size() > 3) {
                int temp = streams.poll();
                total -= temp;
            }
            average = total/streams.size();

            return average;
        }
    }


}
