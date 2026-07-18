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
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, List<int []>> coloumnMap = new TreeMap<>();
       
        Queue<TreeNode> nq = new LinkedList<>();

        Queue<int []> cq = new LinkedList<>();
        nq.offer(root);
        cq.offer(new int[]{0, 0} );
        while(!nq.isEmpty()){
           
                TreeNode node = nq.poll();
                 int[] coq = cq.poll();
                 int row = coq[0], col = coq[1];
               // Map + computeif absent + arraylist
                coloumnMap.computeIfAbsent( col,k -> new ArrayList<>()).add(new int[]{row, node.val});
                 if(node.left != null){
                     nq.offer(node.left);
                     cq.offer(new int[] { row +1, col -1 });
               }
               if(node.right != null){ 
                   nq.offer(node.right);
                   cq.offer(new int[] { row +1, col +1 });
               }
               
        }

            
            for(List<int []> col : coloumnMap.values()){
                col.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] -b[1]);
                List<Integer> colval =  new ArrayList<>();
                  for(int[] entry : col) colval.add(entry[1]);
                  res.add(colval);
            }
            return res;

            }
}
        