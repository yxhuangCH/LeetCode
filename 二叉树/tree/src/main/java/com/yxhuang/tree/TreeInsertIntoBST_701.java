package com.yxhuang.tree;

/**
 * 701. 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class TreeInsertIntoBST_701 {

    /**
     * 701. 二叉搜索树中的插入操作
     * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
     * <p>
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [4,2,7,1,3], val = 5
     * 输出：[4,2,7,1,3,5]
     * 解释：另一个满足题目要求可以通过的树是：
     * <p>
     * 示例 2：
     * <p>
     * 输入：root = [40,20,60,10,30,50,70], val = 25
     * 输出：[40,20,60,10,30,50,70,null,null,25]
     * 示例 3：
     * <p>
     * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
     * 输出：[4,2,7,1,3,5]
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7);
        insertIntoBST2(root, 5);

    }

    /**
     * 递归法
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) { // 坑,如果已经到最后一个节点了，而且这个节点为空，则插入值就是这个新节点
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }


    /**
     * 迭代法
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertIntoBST2(TreeNode root, int val) {
        // 如果是一颗空树，则创建一个节点并返回
        if (root == null) {
            return new TreeNode(val);
        }

        // 找到插入的点的父节点
        TreeNode currentNode = root;
        TreeNode parentNode = root;
        while (currentNode != null) {
            parentNode = currentNode;
            if (currentNode.val > val) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        // 进行插入
        // 构建插入节点
        TreeNode insertNode = new TreeNode(val);
        if (val > parentNode.val) { // 插入到左边
            parentNode.right = insertNode;
        } else { // 插入到右边
            parentNode.left = insertNode;
        }

        return root;
    }

}
