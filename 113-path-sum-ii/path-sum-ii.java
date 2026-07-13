/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<List<Integer>> res = new ArrayList<>();
          List<Integer> path = new ArrayList<>();
          dfs(root, targetSum, path, res);
          return res;
    }
    public void dfs(TreeNode node, int target, List<Integer> path ,List<List<Integer>> res){
        if(node == null) return;
              path.add(node.val);
              target -= node.val;
              if(node.left == null && node.right == null && target == 0) {
                res.add(new ArrayList<>(path));
              }
              dfs(node.left, target, path, res);
              dfs(node.right, target, path, res);
              path.remove(path.size() -1);

}
}