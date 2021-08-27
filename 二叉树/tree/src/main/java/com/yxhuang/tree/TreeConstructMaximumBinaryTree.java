package com.yxhuang.tree;

import java.util.Arrays;

public class TreeConstructMaximumBinaryTree {

    /**
     * 654. 最大二叉树
     * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
     * <p>
     * 二叉树的根是数组 nums 中的最大元素。
     * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
     * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
     * 返回有给定数组 nums 构建的 最大二叉树 。
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：nums = [3,2,1,6,0,5]
     * 输出：[6,3,5,null,2,0,null,null,1]
     * 解释：递归调用如下所示：
     * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
     * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
     * - 空数组，无子节点。
     * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
     * - 空数组，无子节点。
     * - 只有一个元素，所以子节点是一个值为 1 的节点。
     * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
     * - 只有一个元素，所以子节点是一个值为 0 的节点。
     * - 空数组，无子节点。
     * 示例 2：
     * <p>
     * <p>
     * 输入：nums = [3,2,1]
     * 输出：[3,null,2,null,1]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
//        TreeNode result = constructTree(nums);
//        System.out.println(result.val);

        TreeNode result2 = constructTree2(nums, 0, nums.length);
        System.out.println(result2.val);
    }

    // 这种接法每次都需要 copy 两次，导致内存和时间复杂度很高
    private static TreeNode constructTree(int[] nums) {
        // 空节点
        if (nums.length == 0) {
            return null;
        }

        // 找到数组中最大的值和对应的下标
        int maxIndex = 0;
        int maxValue = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value > maxValue) {
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

    // 可以考虑使用 两个 index 操纵原有数组
    private static TreeNode constructTree2(int[] nums, int leftIndex, int rightIndex) {
        // 空节点
        if (leftIndex  == rightIndex) {
            return null;
        }

        // 找到数组中最大的值的下标
        int maxIndex = maxIndex(nums, leftIndex, rightIndex);
        int maxValue = nums[maxIndex];
        System.out.println("maxIndex:" + maxIndex + " maxValue: " + maxValue);
        // 创建节点
        TreeNode treeNode = new TreeNode(maxValue);


        treeNode.left = constructTree2(nums, leftIndex, maxIndex);
        treeNode.right = constructTree2(nums, maxIndex + 1, rightIndex);

        return treeNode;
    }

    private static int maxIndex(int[] nums, int leftIndex, int rightIndex) {
        int maxIndex = leftIndex;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
