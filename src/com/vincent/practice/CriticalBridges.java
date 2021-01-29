package com.vincent.practice;

import java.util.ArrayList;
import java.util.List;

public class CriticalBridges {

    private int[] ids;
    private int[] lows;
    private boolean[] isVisited;
    private List<List<Integer>> graph;
    private int n;
    private int id = 0;

    public static void main(String[] args) {
        List<List<Integer>> graph = buildGraph(9);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 2, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 6, 7);
        addEdge(graph, 7, 8);
        addEdge(graph, 8, 5);

    }

    public CriticalBridges(List<List<Integer>> graph, int n) {
        this.graph = graph;
        this.ids = new int[n];
        this.lows = new int[n];
        this.isVisited = new boolean[n];
        this.n = n;
        this.id = 0;
    }

    public List<Integer> findBridges() {
        List<Integer> bridges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i, -1, graph, bridges);
            }
        }
        return bridges;
    }

    public void dfs(int current,int parent, List<List<Integer>> graph, List<Integer> bridges) {
        isVisited[current] = true;
        ids[current] = lows[current] = id;
        id++;
        for (int to : graph.get(current)) {
            if (to == parent) continue;
            if (!isVisited[to]) {
                dfs(to, current, graph, bridges);
                lows[current] = Math.min(lows[current], lows[to]);
                if (ids[current] < lows[to]) {
                    bridges.add(current);
                    bridges.add(to);
                }
            } else {
                lows[current] = Math.min(lows[current], ids[to]);
            }
        }
    }

    public static List<List<Integer>> buildGraph(int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        return graph;
    }

    public static  void addEdge(List<List<Integer>> graph, int from, int to) {
        graph.get(from).add(to);
        graph.get(to).add(from);
    }
}
