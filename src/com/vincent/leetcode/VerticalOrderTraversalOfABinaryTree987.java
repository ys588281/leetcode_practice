package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderTraversalOfABinaryTree987 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> verticalOrderTraversalOfABinaryTree(TreeNode root) {
        if (root == null) return null;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int idx = 0;
        List<Integer> current = new ArrayList<>();
        current.add(root.val);
        map.put(0, current);

        dfs(root.left, map, idx - 1);
        dfs(root.right, map, idx + 1);
        List<List<Integer>> results = new ArrayList<>();
        for (Integer key : map.keySet()) {
            results.add(map.get(key));
        }
        return results;
    }

    public static void dfs(TreeNode root, Map<Integer, List<Integer>> map, int idx) {
        if (root == null) return;
        if (map.containsKey(idx)) {
            List<Integer> current = map.get(idx);
            current.add(root.val);
            map.put(idx, current);
        } else {
            List<Integer> current = new ArrayList<>();
            current.add(root.val);
            map.put(idx, current);
        }
        dfs(root.left, map, idx - 1);
        dfs(root.right, map, idx + 1);
    }
}
