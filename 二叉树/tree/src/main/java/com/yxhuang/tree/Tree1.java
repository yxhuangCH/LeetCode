package com.yxhuang.tree;

import java.util.*;

public class Tree1 {
    // 101. 对称二叉树

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * <p>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     *  
     * <p>
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * <p>
     *       1
     *      / \
     *     2   2
     *      \   \
     *      3    3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);

        root2.left.left = null;
        root2.left.right = new TreeNode(3);

        root2.right.left = new TreeNode(3);
        root2.right.right = null;


        boolean result = compare(root2.left, root2.right);
        System.out.println("result " + result);

        System.out.println("-------");

        boolean result2 = compare2(root2);
        System.out.println("result2 " + result2);

    }

    // 错误的思路，没有对每层做具体的判断
//    public static boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return false;
//        }
//        // 最后一层判断
//        if (root.left == null && root.right == null) {
//            return true;
//        }
//
//        boolean leftIsSymmetric = isSymmetric(root.left);
//        boolean rightIsSymmetric = isSymmetric(root.right);
//
//        return leftIsSymmetric && rightIsSymmetric;
//    }

    // 使用递归算法
    private static boolean compare(TreeNode left, TreeNode right) {
        // 终止条件
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        // 单层逻辑
        boolean outside = compare(left.left, right.right); // 最外的比较
        boolean inside = compare(left.right, right.left);  // 内存比较
        return outside && inside;
    }

    // 使用迭代算法
    private static boolean compare2(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 终止条件
            if (left == null && right == null) {
                continue;
            }

            if (left == null && right != null) {
                return false;
            }

            if (left != null && right == null) {
                return false;
            }

            if (left.val == right.val) {
                continue;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }

}
