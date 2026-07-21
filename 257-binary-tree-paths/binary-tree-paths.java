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
    public List<String> binaryTreePaths(TreeNode root) {
         List<String> res = new ArrayList<>();

         if( root != null) dfs(root,"",res);
         return res;
    }
    public void dfs(TreeNode node, String s, List<String> res)
{
  String cp = s.isEmpty() ? String.valueOf(node.val) :s + "->" + node.val;
      if( node.left  == null &&  node.right == null){ res.add(cp);
      return;

}
if(node.left != null) dfs(node.left, cp, res);
if(node.right != null) dfs(node.right, cp, res);
}
}


