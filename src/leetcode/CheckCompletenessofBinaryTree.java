package leetcode;
import java.util.*;

class CheckCompletenessofaBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static ArrayList<Integer> arr;
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            arr.add(temp.val);
            if (temp.left != null) queue.add(temp.left);
            else if (temp.val != -1) queue.add(new TreeNode(-1, null, null));
            if (temp.right != null) queue.add(temp.right);
            else if (temp.val != -1) queue.add(new TreeNode(-1, null, null));
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        arr = new ArrayList<>();
        bfs(root);
        boolean is_poss = true;
        for (int elem : arr) {
            if (elem == -1) {
                if (is_poss) {
                    is_poss = false;
                }
            }
            if (!is_poss && elem != -1) return false;
        }
        return true;
    }
}