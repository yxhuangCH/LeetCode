package com.yxhuang.tree;

import java.util.Arrays;

public class TreeConstructMaximumBinaryTree {

    /**
     * 654. 最大二叉树
     * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
     *
     * 二叉树的根是数组 nums 中的最大元素。
     * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
     * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
     * 返回有给定数组 nums 构建的 最大二叉树 。
     *
     * 示例 1：
     *
     *
     * 输入：nums = [3,2,1,6,0,5]
     * 输出：[6,3,5,null,2,0,null,null,1]
     * 解释：递归调用如下所示：
     * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
     *     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
     *         - 空数组，无子节点。
     *         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
     *             - 空数组，无子节点。
     *             - 只有一个元素，所以子节点是一个值为 1 的节点。
     *     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
     *         - 只有一个元素，所以子节点是一个值为 0 的节点。
     *         - 空数组，无子节点。
     * 示例 2：
     *
     *
     * 输入：nums = [3,2,1]
     * 输出：[3,null,2,null,1]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode result = constructTree(nums);
        System.out.println(result.val);

    }

    private static TreeNode constructTree(int[] nums){
        // 空节点
        if (nums.length == 0){
            return null;
        }

        // 找到数组中最大的值和对应的下标
        int maxIndex = 0;
        int maxValue = nums[0];
        for (int i = 0; i < nums.length; i++){
             int value = nums[i];
             if (value > maxValue){
                 maxIndex = i;
                 maxValue = value;
             }
        }
        System.out.println("maxIndex:" + maxIndex + " maxValue: " + maxValue);

        // 创建节点
        TreeNode treeNode = new TreeNode(maxValue);

        // 处理左边
        int[] leftNums = Arrays.copyOfRange(nums, 0, maxIndex);
        // 处理右边
        int[] rightNums = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);

        treeNode.left = constructTree(leftNums);
        treeNode.right = constructTree(rightNums);

        return treeNode;
    }
}
