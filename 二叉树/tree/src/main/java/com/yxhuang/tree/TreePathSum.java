package com.yxhuang.tree;


import java.util.*;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class TreePathSum {

    private static List<List<Integer>> mSumPathList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        List<List<Integer>> result = pathSum(root, 28);
        for (List<Integer> mPath : result) {
            for (Integer integer : mPath) {
                System.out.println("---层序遍历 结果----integer: " + integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> pathList = new LinkedList<>();
        pathList.add(root.val);
        findPath(root, targetSum - root.val, pathList);
        return mSumPathList;
    }

    public static void findPath(TreeNode root, int targetSum, LinkedList<Integer> pathList) {
        // 返回
        if (root == null) {
            return;
        }
        // 处理每层的路径
        // 如果是节点
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                mSumPathList.add(new ArrayList<>(pathList));
            }
            return;
        }

        // 如果不是节点
        // 左节点
        if (root.left != null) {
            targetSum -= root.left.val;  // 处理节点
            pathList.add(root.left.val);
            findPath(root.left, targetSum, pathList);
            targetSum += root.left.val;  // 回溯
            pathList.pollLast();
        }

        if (root.right != null) {
            targetSum -= root.right.val; // 处理节点
            pathList.add(root.right.val);
            findPath(root.right, targetSum, pathList);
            targetSum += root.right.val; // 回溯
            pathList.pollLast();
            return;
        }
    }
}
