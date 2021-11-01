package com.yxhuang.tree;

/**
 * 617. 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class TreeMergeTrees_617 {

    /**
     * 617. 合并二叉树
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     *
     * 示例 1:
     *
     * 输入:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * 输出:
     * 合并后的树:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     * 注意: 合并必须从两个树的根节点开始。
     * @param args
     */
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        return treeMergeTrees(root1, root2);
    }

    // 第一步：确定函数和返回值
    // 返回一个 TreeNode
    public static TreeNode treeMergeTrees(TreeNode root1, TreeNode root2){
        // 第二步：终止条件
        if (root1 == null && root2 == null){
            return null;
        }

        // 左数节点不为空，右数节点为空
        if (root1 != null && root2 == null){
            return root1;  // 这里注意返回 root1, 不是返回新的 TreeNode
        }
        // 左数节点为空，右数节点不为空
        if (root1 == null){
            return root2; // 这里注意返回 root2, 不是返回新的 TreeNode
        }

        // 第三步：处理好每一层的关系
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = treeMergeTrees(root1.left, root2.left);
        node.right = treeMergeTrees(root1.right, root2.right);

        return node;
    }

}
