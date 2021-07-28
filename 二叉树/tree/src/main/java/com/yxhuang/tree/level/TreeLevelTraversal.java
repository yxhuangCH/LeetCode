package com.yxhuang.tree.level;

import com.yxhuang.tree.TreeNode;

import java.util.*;

/**
 * 数的层遍历
 * <p>
 * 相关题目
 * 102.⼆叉树的层序遍历
 * 107.⼆叉树的层次遍历II
 * 199.⼆叉树的右视图
 * 637.⼆叉树的层平均值
 * 429.N叉树的前序遍历
 * 515.在每个树⾏中找最⼤值
 * 116. 填充每个节点的下⼀个右侧节点指针
 * 117.填充每个节点的下⼀个右侧节点指针II
 */
public class TreeLevelTraversal {

    public static void main(String[] args) {
//        level107();
//        level199();
        level637();
    }


    // 107.⼆叉树的层次遍历II
    // https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/

    /**
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其自底向上的层序遍历为：
     * <p>
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     */
    private static void level107() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println("---层序遍历----");
        List<List<Integer>> resultList = levelTraversal107(root);
        for (List<Integer> list : resultList) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }

    //
    private static List<List<Integer>> levelTraversal107(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 返回结果
        LinkedList<List<Integer>> result = new LinkedList<>();
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
            result.addFirst(levelNode);
        }

        return result;
    }

    /**
     * 示例 1:
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1,3,4]
     * 示例 2:
     * <p>
     * 输入: [1,null,3]
     * 输出: [1,3]
     * 示例 3:
     * <p>
     * 输入: []
     * 输出: []
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
     */
    private static void level199() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println("---层序遍历 level199----");
        List<Integer> resultList = levelTraversal199(root);
        for (Integer integer : resultList) {
            System.out.print(integer + " ");
        }
        System.out.println("");


    }

    private static List<Integer> levelTraversal199(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 返回结果
        List<Integer> result = new ArrayList<>();
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
            // 每一层的最后一个，也就是最右边，结果添加到结果中
            if (levelNode.size() > 0) {
                Integer lastValue = levelNode.get(levelNode.size() - 1);
                result.add(lastValue);
            }
        }

        return result;
    }

    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
     */
    private static void level637() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println("---层序遍历----");
        List<Double> resultList = levelTraversal637(root);
        for (Double f : resultList) {
            System.out.print(f + " ");
        }
    }

    private static List<Double> levelTraversal637(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 返回结果
        List<Double> result = new ArrayList<>();
        // 每一层的节点
        Queue<TreeNode> levelQueue = new ArrayDeque<>();
        // 先添加第一层
        levelQueue.add(root);

        while (!levelQueue.isEmpty()) {
            // 每层的节点数量
            int levelNodeSize = levelQueue.size();
            // 每一层的节点
            double levelArgValue = 0;
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
                levelArgValue = levelArgValue + node.val;
            }
            // 每一层的结果添加到结果中
            result.add(levelArgValue / levelNodeSize);
        }

        return result;
    }

}
