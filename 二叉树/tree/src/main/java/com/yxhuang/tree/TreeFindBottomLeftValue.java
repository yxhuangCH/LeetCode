package com.yxhuang.tree;

import java.util.*;

public class TreeFindBottomLeftValue {

    public static void main(String[] args) {
        /**
         * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
         *
         * 假设二叉树中至少有一个节点。
         *
         *  
         *
         * 示例 1:
         *
         *
         *
         * 输入: root = [2,1,3]
         * 输出: 1
         * 示例 2:
         *
         *
         *
         * 输入: [1,2,3,4,null,5,6,null,null,7]
         * 输出: 7
         *  
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println("---层序遍历----");
        int result = findBottomLeftValue(root);
        System.out.println("---层序遍历 结果----" + result);
    }


    public static int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeList = new ArrayDeque<>();
        nodeList.add(root);
        int result = 0;
        while (!nodeList.isEmpty()) {
            int levelSize = nodeList.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodeList.poll();
                if (node == null) {
                    break;
                }

                // 难点，如何判断是最后一行的左值
                if (i == 0) { // i = 0
                    result = node.val;
                    System.out.println("result: " + result);
                }

                if (node.left != null) {
                    nodeList.add(node.left);
                }
                if (node.right != null) {
                    nodeList.add(node.right);
                }
            }
        }
        return result;
    }
}
