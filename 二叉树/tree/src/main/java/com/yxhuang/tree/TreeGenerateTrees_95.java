package com.yxhuang.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class TreeGenerateTrees_95 {

    /**
     * 95. 不同的二叉搜索树 II
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     * 示例 1：
     * <p>
     * <p>
     * 输入：n = 3
     * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：[[1]]
     *
     * @param args
     */
    public static void main(String[] args) {

    }


    // 第一步，确定递归函数，返回值是List<TreeNode>
    private static List<TreeNode> createTrees(int start, int end) {
        System.out.println("createTrees start " + start + " end " + end);
        List<TreeNode> curRes = new LinkedList<>();
        // 终止条件
        if (start > end) {
            curRes.add(null);
            return curRes;
        }

        // 将树一个个变量作为根节点
        // 每次遍历中，将左边的数组和右边的数组分别进行构建子树，并连到当前根节点上
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodeList = createTrees(start, i - 1);
            List<TreeNode> rightNodeList = createTrees(i + 1, end);

            // 连到当前根节
            for (TreeNode leftNode : leftNodeList) {
                for (TreeNode rightNode : rightNodeList) {
                    // 构建当前节点并把左右节点放置进去
                    curRes.add(new TreeNode(i, leftNode, rightNode));
                }
            }

        }
        return curRes;
    }
}
