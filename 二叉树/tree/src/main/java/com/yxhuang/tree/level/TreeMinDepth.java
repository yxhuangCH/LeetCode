package com.yxhuang.tree.level;

import com.yxhuang.tree.TreeNode;

/**
 * 树的最小深度
 */
public class TreeMinDepth {
    /**
     * 给定一个二叉树，找出其最小深度。
     * <p>
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * <p>
     * 说明：叶子节点是指没有子节点的节点。
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        int result = minDepth(root);
        System.out.println("result " + result);
    }

    // 递归法
    public static int minDepth(TreeNode node) {
        // 递归终止条件
        if (node == null) {
            return 0;
        }

        int leftDepth = minDepth(node.left);
        int rightDepth = minDepth(node.right);
        if (node.left == null && node.right != null) {
            return 1 + rightDepth;
        }

        if (node.right == null && node.left != null) {
            return 1 + leftDepth;
        }
        int result = 1 + Math.min(leftDepth, rightDepth);
        return result;
    }


}
