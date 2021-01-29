package com.vincent.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph133 {

    public static void main(String[] args) {

    }

    public static Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Node dfsResult = dfs(node, map);
        return dfsResult;
    }

    private static Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node n : node.neighbors) {
            copy.neighbors.add(dfs(n, map));
        }
        return map.get(node);
    }

    public static Node bfs(Node node) {
        if (node == null) return null;
        Map<Node, Node> visiyed = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node head = new Node(node.val);
        visiyed.put(node, head);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (visiyed.containsKey(neighbor)) {
                    visiyed.get(current).neighbors.add(visiyed.get(neighbor));
                } else {
                    Node temp = new Node(neighbor.val);
                    queue.offer(temp);
                    visiyed.put(neighbor, temp);
                    visiyed.get(current).neighbors.add(temp);
                }
            }
        }
        return head;
    }
}
