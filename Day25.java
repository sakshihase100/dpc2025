import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
    public TreeNode buildTree(Integer[] arr) {
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

    public static void main(String[] args) {
        ValidateBST bstChecker = new ValidateBST();
        Integer[] arr1 = {2, 1, 3};
        TreeNode root1 = bstChecker.buildTree(arr1);
        System.out.println("Input: [2,1,3] -> " + bstChecker.isValidBST(root1)); 
        Integer[] arr2 = {5, 1, 4, null, null, 3, 6};
        TreeNode root2 = bstChecker.buildTree(arr2);
        System.out.println("Input: [5,1,4,null,null,3,6] -> " + bstChecker.isValidBST(root2)); 

       
        Integer[] arr3 = {10, 5, 15, null, null, 6, 20};
        TreeNode root3 = bstChecker.buildTree(arr3);
        System.out.println("Input: [10,5,15,null,null,6,20] -> " + bstChecker.isValidBST(root3)); 

        
        Integer[] arr4 = {1};
        TreeNode root4 = bstChecker.buildTree(arr4);
        System.out.println("Input: [1] -> " + bstChecker.isValidBST(root4)); 

        
        Integer[] arr5 = {2, 2, 2};
        TreeNode root5 = bstChecker.buildTree(arr5);
        System.out.println("Input: [2,2,2] -> " + bstChecker.isValidBST(root5)); 
    }
}
