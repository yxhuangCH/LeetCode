package com.yxhuang.tree;

/**
 * 530. 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class TreeGetMinimumDifference_530 {

    /**
     * 530. 二叉搜索树的最小绝对差
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     *
     * 差值是一个正数，其数值等于两值之差的绝对值。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [4,2,6,1,3]
     * 输出：1
     * 示例 2：
     *
     *
     * 输入：root = [1,0,48,null,null,12,49]
     * 输出：1
     * @param args
     */

    public static void main(String[] args) {

    }

    int mMinValue = Integer.MAX_VALUE;
    TreeNode mPreNode = null;  // 上一个节点
    public int getMinimumDifference(TreeNode root) {
        /**
         中序遍历:
         利用性质: 从小到大的  任意两节点的差只需要遍历相邻节点的差即可(而且不用绝对值 (大-小)肯定>0)
         */
        dfs(root);
        return mMinValue;
    }

    public void dfs(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        // 左子树
        dfs(treeNode.left);
        if (mPreNode != null){
            mMinValue = Math.min(mMinValue, treeNode.val - mPreNode.val);  // 这里是关键
        }
        mPreNode = treeNode;
        //  右子树
        dfs(treeNode.right);
    }

}
