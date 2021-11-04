package com.yxhuang.tree;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 *  思路：
 *  **遇到二叉搜索树，一定要想到二叉搜索树的中序变量是递增序列**
 *  们验证是否为二叉搜索树的话，只要看它中序遍历的结果是不是递增的就可以了。
 *  我们用pre指针记录前一个节点，如果当前节点小于等于前一个节点，就返回false
 *
 */
public class TreeIsValidBST_98 {



    public static void main(String[] args) {

    }


    public boolean isValidBST(TreeNode root) {
        return traversalValidBST(root);
    }

    TreeNode mPre = null;
    // 第一步确定返回是 boolean
    public boolean traversalValidBST(TreeNode root){
        //
        if (root == null){
            return true;
        }

        // 访问左子树
        if (!traversalValidBST(root.left)){
            return false;
        }

        // 访问当前节点，中序遍历
        // 如果递增序列里的前一个节点 大于等于当前节点，说明不是递增序列，也就不是二叉搜索树
        if (mPre != null && mPre.val >= root.val){
            return false;
        }
        mPre = root;

        // 访问右子树
        return traversalValidBST(root.right);
    }
}
