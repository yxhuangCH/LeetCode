package com.yxhuang.tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class TreeSortedArrayToBST_108 {


    /**
     * 108. 将有序数组转换为二叉搜索树
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * <p>
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     * <p>
     * 示例 2：
     * <p>
     * <p>
     * 输入：nums = [1,3]
     * 输出：[3,1]
     * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST(nums);
        System.out.println("node " + node.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int lowIndex, int heightIndex) {
        if (lowIndex >= heightIndex) {
            return null;
        }
        int midIndex = lowIndex + (heightIndex - lowIndex) / 2; // 避免溢出
        int midValue = nums[midIndex];
        System.out.println("lowIndex = " + lowIndex + "heightIndex=" + heightIndex +
                "midIndex =" + midIndex + " midValue=" + midValue);
        TreeNode node = new TreeNode(midValue);

        node.left = sortedArrayToBST(nums, lowIndex, midIndex - 1); // 注意边界是 midIndex - 1
        node.right = sortedArrayToBST(nums, midIndex + 1, heightIndex); // 注意边界是 midIndex + 1

        return node;
    }
}
