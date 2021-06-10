package Dynamic_programming.LeetCode;

import java.util.LinkedList;
import java.util.List;

public class Unique_BinarySearchTree_II {
    static List<TreeNode>[][] dp;
    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
    private static List<TreeNode> generateTrees(int n){
        dp = new LinkedList[n + 2][n + 2];
        return util(n, 1, n);
    }
    private static List<TreeNode> util(int n, int start, int end){
        if (dp[start][end] != null) return dp[start][end];

        List<TreeNode> result = new LinkedList<>();
        if (start == end) {
            result.add(new TreeNode(start));
            return dp[start][end] = result;
        }
        if (end < start){
            result.add(null);
            return dp[start][end] = result;
        }
        for (int i = start; i <= end; i++){
            List<TreeNode> left_list = util(n, start, i - 1);
            List<TreeNode> right_lidt = util(n, i + 1, end);
            for (TreeNode left: left_list){
                for (TreeNode right: right_lidt){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return dp[start][end] = result;
    }
}

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
