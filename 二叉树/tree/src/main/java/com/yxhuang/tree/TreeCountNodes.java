package com.yxhuang.tree;

public class TreeCountNodes {

    /**
     * 222. 完全二叉树的节点个数
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     * <p>
     * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,2,3,4,5,6]
     * 输出：6
     * 示例 2：
     * <p>
     * 输入：root = []
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：root = [1]
     * 输出：1
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        int result = countNodes(root);
        System.out.println("result " + result);

    }

    private static int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }


}
