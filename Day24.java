import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class LowestCommonAncestorBT {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();

            if (i < arr.length && arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = buildTree(arr);

        int[][] tests = {
            {5, 1},   
            {5, 4},  
            {6, 4},  
            {7, 8}    
        };

        System.out.println("LCA Test Cases (Tree 1):");
        for (int[] t : tests) {
            TreeNode p = findNode(root, t[0]);
            TreeNode q = findNode(root, t[1]);
            TreeNode ans = lowestCommonAncestor(root, p, q);
            System.out.println("LCA of " + t[0] + " and " + t[1] + " = " + ans.val);
        }

        Integer[] arr2 = {1, 2};
        TreeNode root2 = buildTree(arr2);
        TreeNode p2 = findNode(root2, 1);
        TreeNode q2 = findNode(root2, 2);
        TreeNode ans2 = lowestCommonAncestor(root2, p2, q2);

        System.out.println("\nLCA Test Case (Tree 2):");
        System.out.println("LCA of 1 and 2 = " + ans2.val);
    }
}
