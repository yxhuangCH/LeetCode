package com.yxhuang.tree;

/**
 * 99. 恢复二叉搜索树
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class TreeRecoverTree_99 {

    static TreeNode sPreNode =null;
    static TreeNode sFirstNode = null;
    static TreeNode sSecondNode = null;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.left.right = new TreeNode(2);


        recoverTree(node);
        int temp = sFirstNode.val;
        sFirstNode.val = sSecondNode.val;
        sSecondNode.val = temp;
    }

    public static void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        // 左子树
        recoverTree(root.left);

        if (sPreNode != null && sPreNode.val > root.val){
            if(sFirstNode == null){
                sFirstNode = sPreNode;
            }
            sSecondNode = root;
        }
        sPreNode = root;
        recoverTree(root.right);
    }
}
