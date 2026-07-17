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
    public List<Integer> largestValues(TreeNode root) {
         List<Integer> res = new ArrayList<>();
         Queue<TreeNode>  q = new LinkedList<>();
         q.offer(root);
         if(root == null) return res;

         while(!q.isEmpty()){
         int ls = q.size();
                   int max = Integer.MIN_VALUE;
         for(int i =0;i < ls; i++){


           TreeNode node =  q.poll();
        max = Math.max(max, node.val);

            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
         }
            res.add(max);
         }
         return res;      
    }
}