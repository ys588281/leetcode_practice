package com.vincent.practice;

import java.util.ArrayList;
import java.util.List;

public class CriticalArticulationPoints {

    private int[] ids;
    private int[] lows;
    private boolean[] isVisited;
    private int n;
    private int id = 0;
    private int outEdge = 0;
    private List<List<Integer>> graph;
    private boolean[] isArticulationPoints;

    public static void main(String[] args) {
        List<List<Integer>> graph = buildGraph(4);
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 0, 3);

        CriticalArticulationPoints c = new CriticalArticulationPoints(4, graph);
        boolean[] results = c.findArticulationPoints();
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }

    public CriticalArticulationPoints(int n, List<List<Integer>> graph) {
        this.graph = graph;
        this.n = n;
        this.ids = new int[n];
        this.lows = new int[n];
        this.isVisited = new boolean[n];
        this.isArticulationPoints = new boolean[n];
    }

    public boolean[] findArticulationPoints() {
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                System.out.println("isVisited not: " + i);
                outEdge = 0;
                dfs(i, i, -1);
                isArticulationPoints[i] = (outEdge > 1) ? true : false;
            }
        }
        return isArticulationPoints;
    }

    public void dfs(int root, int current, int parent) {
//        System.out.println(root + " " + current + " " + parent);
        if (parent == root) {
            System.out.println(root + " " + current + " " + parent);
            outEdge++;
        }
        isVisited[current] = true;
        ids[current] = lows[current] = id;
        id++;
        for (int to : graph.get(current)) {
            if (to == parent) continue;
            if (!isVisited[to]) {
                dfs(root, to, current);
                lows[current] = Math.min(lows[current], lows[to]);
                if (ids[current] <= lows[to]) {
                    isArticulationPoints[current] = true;
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
