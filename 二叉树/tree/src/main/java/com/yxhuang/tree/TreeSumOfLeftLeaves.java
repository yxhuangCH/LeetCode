package com.yxhuang.tree;

import java.util.*;

public class TreeSumOfLeftLeaves {

    /**
     * 404. 左叶子之和
     * 计算给定二叉树的所有左叶子之和。
     * <p>
     * 示例：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
//        int result = sumOfLeftLeaves2(root);
        int result = sumOfLeftLeaves3(root);
        System.out.println("result : "+ result);
    }

    // 层序遍历
    // 这是最早的写法，是错误的，没有对左叶子，而不是二叉树的左侧节点
    @Deprecated
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;

        Queue<TreeNode> levelQueue = new ArrayDeque<>();
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            TreeNode node = levelQueue.poll();
            TreeNode leftNode = node.left;
            if (leftNode != null) {
                result = result + leftNode.val;
                levelQueue.add(leftNode);
            }
            TreeNode rightNode = node.right;
            if (rightNode != null) {
                levelQueue.add(rightNode);
            }
        }

        return result;
    }

    /**
     *  此时就要通过节点的⽗节点来判断其左孩⼦是不是左叶⼦了
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;

        Queue<TreeNode> levelQueue = new ArrayDeque<>();
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            TreeNode node = levelQueue.poll();

            // 重点，判断左侧节点
            if (node.left != null && node.left.left ==  null && node.left.right == null){
                result += node.left.val;
            }

            // 添加节点
            TreeNode leftNode = node.left;
            if (leftNode != null) {
                levelQueue.add(leftNode);
            }
            TreeNode rightNode = node.right;
            if (rightNode != null) {
                levelQueue.add(rightNode);
            }
        }

        return result;
    }

    /**
     * 使用递归
     *  采取后序遍历， 左右中
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves3(TreeNode root){
        //　终止条件
        if (root == null){
            return  0;
        }

        int leftSum = sumOfLeftLeaves3(root.left);
        int rightSum = sumOfLeftLeaves3(root.right);

        // ???
        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            midValue = root.left.val;
        }
        return midValue + leftSum + rightSum;
    }


}
