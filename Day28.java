import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class SymmetricTreeDynamic {

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val) &&
               isMirror(t1.left, t2.right) &&
               isMirror(t1.right, t2.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public static TreeNode buildTree(List<String> arr) {
        if (arr.size() == 0 || arr.get(0).equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr.get(0)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.size()) {
            TreeNode curr = queue.poll();

            if (i < arr.size() && !arr.get(i).equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr.get(i)));
                queue.add(curr.left);
            }
            i++;

            if (i < arr.size() && !arr.get(i).equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr.get(i)));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree nodes in level order (use 'null' for empty): ");
        String input = sc.nextLine();

        List<String> arr = new ArrayList<>();
        for (String s : input.trim().split("\\s+")) {
            if (!s.isEmpty()) arr.add(s);
        }

        TreeNode root = buildTree(arr);

        System.out.println("Is the tree symmetric? " + isSymmetric(root));
    }
}
