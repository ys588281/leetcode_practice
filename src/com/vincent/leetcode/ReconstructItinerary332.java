package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary332 {

    public static Map<String, PriorityQueue<String>> map = new HashMap<>();
    public static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        reconstructItinerary(new String[][]{
                {"JFK","SFO"},
                {"JFK","ATL"},
                {"SFO","ATL"},
                {"ATL","JFK"},
                {"ATL","SFO"}
        });
    }

    public static List<String> reconstructItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], t -> new PriorityQueue<>()).add(ticket[1]);
        }
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], t -> new PriorityQueue<>()).add(ticket[1]);
        }
        dfs("JFK");
        Collections.reverse(results);
        return results;
    }

    private static void dfs(String place) {
        PriorityQueue<String> queue = map.get(place);
        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll());
        }
        results.add(place);
    }
}
