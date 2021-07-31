package com.yxhuang.tree.level;

import com.yxhuang.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 树的最大深度
 */
public class TreeMaxDepth {
    /**
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        int result = maxDepth(root);
        System.out.println("result " + result);

        int result2 = maxDepth2(root);
        System.out.println("result2 " + result2);
    }

    // 递归法
    public static int maxDepth(TreeNode node) {
        // 递归终止条件
        if (node == null) {
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        if (node.left == null && node.right != null) {
            return 1 + rightDepth;
        }

        if (node.right == null && node.left != null) {
            return 1 + leftDepth;
        }
        int result = 1 + Math.max(leftDepth, rightDepth);
        return result;
    }

    // 迭代算法，使用层序遍历
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        // 每一层的节点
        Queue<TreeNode> levelQueue = new ArrayDeque<TreeNode>();
        // 先添加第一层
        levelQueue.add(root);

        while (!levelQueue.isEmpty()) {
            // 每层的节点数量
            int levelNodeSize = levelQueue.size();
            // 每一层的节点
            List<Integer> levelNode = new ArrayList<>(levelNodeSize);
            for (int i = 0; i < levelNodeSize; i++) {
                TreeNode node = levelQueue.poll();
                if (node == null) {
                    break;
                }
                if (node.left != null) {
                    levelQueue.add(node.left);
                }
                if (node.right != null) {
                    levelQueue.add(node.right);
                }
                levelNode.add(node.val);
            }
            // 每一层的结果添加到结果中
            result++;
        }
        return result;
    }

}
