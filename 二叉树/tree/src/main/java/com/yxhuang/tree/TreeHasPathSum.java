package com.yxhuang.tree;

public class TreeHasPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        boolean result = hasPathSumTraversal(root, 28 - root.val);
        System.out.println("---层序遍历 结果----" + result);

    }

    // 1. 确定递归函数和返回值
    public static boolean hasPathSumTraversal(TreeNode node, int count) {
        if (node == null) {
            return false;
        }

        // 2. 终止条件
        // ① 如果是叶节点，并且 count == 0 表示有路径
        // 并且 count != 0 表示无路径
        if (node.left == null && node.right == null) {
            return count == 0;
        }

        // 3. 处理每层的逻辑
        if (node.left != null) {
            count -= node.left.val;
            if (hasPathSumTraversal(node.left, count)) { // 如果有路径，返回
                return true;
            }
            count += node.left.val;// 回溯
        }
        if (node.right != null) {
            count -= node.right.val;
            if (hasPathSumTraversal(node.right, count)) { // 如果有路径，返回
                return true;
            }
            count += node.right.val;// 回溯
        }

        return false;
    }
}
