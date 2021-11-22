package com.yxhuang.tree;

/**
 * 669. 修剪二叉搜索树
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 */
public class TreeTrimBST_669 {

    /**
     * 669. 修剪二叉搜索树
     * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
     * <p>
     * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,0,2], low = 1, high = 2
     * 输出：[1,null,2]
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
     * 输出：[3,2,null,1]
     * 示例 3：
     * <p>
     * 输入：root = [1], low = 1, high = 2
     * 输出：[1]
     * 示例 4：
     * <p>
     * 输入：root = [1,null,2], low = 1, high = 3
     * 输出：[1,null,2]
     * 示例 5：
     * <p>
     * 输入：root = [1,null,2], low = 2, high = 4
     * 输出：[2]
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     *  递归法
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low){
            return trimBST(root.right, low, high);
        }

        if (root.val > high){
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

}
