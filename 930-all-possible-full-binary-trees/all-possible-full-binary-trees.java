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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode>  res = new ArrayList<>();
        if(n == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for(int i =1; i <  n;i++){
             List<TreeNode> lST = allPossibleFBT(i);
            List<TreeNode> rST = allPossibleFBT(n - i - 1);
            for(TreeNode l : lST) {
                for(TreeNode r : rST) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
            
        return res;
        
    }
}