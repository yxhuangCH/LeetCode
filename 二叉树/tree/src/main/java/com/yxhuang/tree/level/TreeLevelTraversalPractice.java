package com.yxhuang.tree.level;

import com.yxhuang.tree.TreeNode;

import java.util.*;

public class TreeLevelTraversalPractice {

    /**
     * 二叉树：[3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层序遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        levelTraversal1(root);

        System.out.println("---堆栈形式----");
        List<List<Integer>> resultList = levelTraversal2(root);
        for (List<Integer> list : resultList) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }


    // 自己写的递归版本
    private static void levelTraversal1(TreeNode root) {
        // 需要判空
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        List<List<Integer>> resultList = new ArrayList<>();
        recursiveLevelTraversal(rootList, resultList);
        for (List<Integer> list : resultList) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }


    private static void recursiveLevelTraversal(List<TreeNode> currentLevelList, List<List<Integer>> result) {
        // 判断条件
        if (currentLevelList.size() == 0) {
            return;
        }
        // 每一层需要判断的
        List<TreeNode> levelList = new ArrayList<>();
        List<Integer> levelResult = new ArrayList<>(currentLevelList.size());
        for (TreeNode node : currentLevelList) {
            levelResult.add(node.val);
            if (node.left != null) {
                levelList.add(node.left);
            }
            if (node.right != null) {
                levelList.add(node.right);
            }
        }
        result.add(levelResult);
        recursiveLevelTraversal(levelList, result);
    }

    // 使用队列的版本
    private static List<List<Integer>> levelTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 返回结果
        List<List<Integer>> result = new ArrayList<>();
        // 每一层的节点
        Queue<TreeNode> levelQueue = new ArrayDeque<TreeNode>();
        // 先添加第一层
        levelQueue.add(root);

        while (!levelQueue.isEmpty()) {
            // 每层的节点数量
            int levelNodeSize = levelQueue.size();
            // 每一层的节点
            List<Integer> levelNode = new ArrayList<>(levelNodeSize);
            for (int i = 0; i < levelNodeSize; i++) {
                TreeNode node = levelQueue.poll();
                if (node == null) {
                    break;
                }
                if (node.left != null) {
                    levelQueue.add(node.left);
                }
                if (node.right != null) {
                    levelQueue.add(node.right);
                }
                levelNode.add(node.val);
            }
            // 每一层的结果添加到结果中
            result.add(levelNode);
        }

        return result;
    }


}
