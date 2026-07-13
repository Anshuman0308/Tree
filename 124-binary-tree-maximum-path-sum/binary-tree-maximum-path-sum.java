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
       int ms = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxsum(root);
        return ms;
    }
    public int maxsum(TreeNode node){
        if(node == null ) return 0;
        int lmax = Math.max(maxsum(node.left),0);
        int rmax = Math.max(maxsum(node.right),0);
        int s = node.val + lmax + rmax;
        ms = Math.max(ms,s);
        return node.val + Math.max(lmax,rmax);
    }
}