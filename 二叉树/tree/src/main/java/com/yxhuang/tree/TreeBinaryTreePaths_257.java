package com.yxhuang.tree;


import java.util.*;

public class TreeBinaryTreePaths_257 {

    /**
     * 257. 二叉树的所有路径
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * <p>
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * <p>
     * 输出: ["1->2->5", "1->3"]
     * <p>
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * @param args
     */

    public static void main(String[] args) {
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        root2.left.left = null;
        root2.left.right = new TreeNode(5);
        List<String> result = binaryTreePaths(root2);
        for (String path : result) {
            System.out.println(path);
        }
    }

    // 使用递归算法
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        // 递归终止条件
        List<String> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        traversal(root, path, result);
        return result;
    }

    // 前序遍历
    private static void traversal(TreeNode root, LinkedList<Integer> path, List<String> result) {

        // 先将当前节点添加到 path
        path.add(root.val);

        // 终止条件，是当前节点是叶节点，也就是它的 left 和 right 都是空
        if (root.left == null && root.right == null) {
            StringBuilder spath = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                spath.append(path.get(i));
                spath.append("->");
            }
            // 记录最后一个节点（叶子节点）
            spath.append(path.get(path.size() - 1));
            // 收集一个路径
            result.add(spath.toString());
            return;
        }

        if (root.left != null) {
            traversal(root.left, path, result);
            path.remove(path.size() - 1);// 回溯 ???
        }

        if (root.right != null) {
            traversal(root.right, path, result);
            path.remove(path.size() - 1);// 回溯 ???
        }
    }
}
