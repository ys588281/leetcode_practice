package com.vincent.leetcode;

import java.util.List;

public class NTreeNode {

    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {}

    public NTreeNode(int val) {
        val = val;
    }

    public NTreeNode(int val, List<NTreeNode> children) {
        val = val;
        children = children;
    }
}
