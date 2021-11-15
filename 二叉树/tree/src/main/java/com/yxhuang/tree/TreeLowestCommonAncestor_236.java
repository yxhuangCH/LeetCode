package com.yxhuang.tree;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class TreeLowestCommonAncestor_236 {

    /**
     * 236. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出：3
     * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        return recursiveCommonAncestor(root, p, q);
    }

    // 第一步，确定函数及返回值
    private TreeNode recursiveCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 第二步，终止条件
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftNode = recursiveCommonAncestor(root.left, p, q);
        TreeNode rightNode = recursiveCommonAncestor(root.right, p, q);
        // 后序遍历
        // 处理每一层的逻辑
        // 如果找到左边节点和右边节点，则返回这个节点
        if (leftNode != null && rightNode != null) {
            return root;
        }

        // 因为要传递这上去，所以要返回
        // 左边节点没有，右边找到，则返回右边的
        if (leftNode == null && rightNode != null) {
            return rightNode;
        }

        if (leftNode != null && rightNode == null) {
            return leftNode;
        }
        // leftNode == null && rightNode == null
        return null;
    }
}
