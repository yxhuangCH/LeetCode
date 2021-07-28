package com.yxhuang.tree;

public class Tree1 {
    // 101. 对称二叉树
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * <p>
     *       1
     *      / \
     *     2   2
     *    / \ / \
     *   3  4 4  3
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);


        boolean result = compare(root.left, root.right);
        System.out.println("result " + result);

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

        return false;
    }

}
