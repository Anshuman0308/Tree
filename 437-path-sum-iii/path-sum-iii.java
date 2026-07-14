/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> psc = new HashMap<>();
        psc.put(0L, 1);
        return dfs(root, 0L, targetSum, psc);
    }

    public int dfs(TreeNode node, long cs, int target, Map<Long, Integer> psc) {
        if (node == null) return 0;

        cs += node.val;

        int count = psc.getOrDefault(cs - target, 0);

        psc.put(cs, psc.getOrDefault(cs, 0) + 1);

        count += dfs(node.left, cs, target, psc);
        count += dfs(node.right, cs, target, psc);

        psc.put(cs, psc.get(cs) - 1);

        return count;
    }
}