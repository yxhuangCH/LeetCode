package com.yxhuang.tree;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class TreeBuildTree_105 {

    public static void main(String[] args) {

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println("result: " + treeNode.val);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return traversal(preorder, inorder);
    }

    private static TreeNode traversal(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        // 前序数组的第一个，就是当前的中间节点
        int nodeValue = preorder[0];
        TreeNode node = new TreeNode(nodeValue);

        // 叶子节点
        if (preorder.length == 1) {
            return node;
        }

        // 找到分割点
        int delimiterIndex;
        for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex++) {
            if (inorder[delimiterIndex] == nodeValue) {
                break;
            }
        }
        System.out.println("delimiterIndex " + delimiterIndex);

        // 切割中序数组
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, delimiterIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, delimiterIndex + 1, inorder.length);

        // 去掉第一个元素
        preorder = Arrays.copyOfRange(preorder, 1, preorder.length);

        // 切割前序数组
        int[] leftPreorder = Arrays.copyOfRange(preorder, 0, leftInorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length, preorder.length);

        // 设置左节点
        node.left = traversal(leftPreorder, leftInorder);
        node.right = traversal(rightPreorder, rightInorder);

        return node;
    }
}
