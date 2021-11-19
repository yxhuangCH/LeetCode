package com.yxhuang.tree;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class TreeDeleteNode_450 {

    /**
     * 450. 删除二叉搜索树中的节点
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     * <p>
     * 一般来说，删除节点可分为两个步骤：
     * <p>
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * 输入：root = [5,3,6,2,4,null,7], key = 3
     * 输出：[5,4,6,2,null,null,7]
     * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
     * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
     * 另一个正确答案是 [5,2,6,null,4,null,7]。
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * 输入: root = [5,3,6,2,4,null,7], key = 0
     * 输出: [5,3,6,2,4,null,7]
     * 解释: 二叉树不包含值为 0 的节点
     * 示例 3:
     * <p>
     * 输入: root = [], key = 0
     * 输出: []
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30, null, new TreeNode(40));
        root.right = new TreeNode(70, new TreeNode(60), new TreeNode(80));
        TreeNode result = deleteNode(root, 50);
        System.out.println("result=" + result.val);
    }

    // 第一步，确定递归函数和返回值
    public static TreeNode deleteNode(TreeNode root, int key) {
        // ① 都没找到，返回
        if (root == null) {
            return null;
        }
        // 第二步，确定每层的逻辑
        if (root.val == key) {
            // ②、左右为空，则删除返回
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) { // ③ 左空，右不空，则返回 right
                return root.right;
            } else if (root.left != null && root.right == null) { // ④ 左不空，右空，则返回 left
                return root.left;
            } else {
                // ⑤ 左右孩⼦节点都不为空，则将删除节点的左⼦树放到删除节点的右⼦树的最左⾯节点的左孩⼦的位置
                // 并返回删除节点右孩⼦为新的根节点

                // 找到 right 的最左侧的点
                TreeNode lastLeftNode = root.right;
                while (lastLeftNode.left != null) {
                    lastLeftNode = lastLeftNode.left;
                }
                lastLeftNode.left = root.left; // 右⼦树的最左⾯节点的左孩⼦的位置
                return root.right; // 返回
            }
        } else {
            if (key > root.val) {
                root.right = deleteNode(root.right, key);
            }
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            }
        }

        return root;
    }

}
