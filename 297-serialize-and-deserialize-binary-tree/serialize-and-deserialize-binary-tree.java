/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        ser(root,s);
        return s.toString();
    }
    public void  ser(TreeNode node,StringBuilder s){
        if( node == null){
       s.append("#,");
        return;
        }
        s.append(node.val).append(",");
        ser(node.left,s);
        ser(node.right,s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
          return dser(q);
    }
    public TreeNode dser(Queue <String> q){
    String qs = q.poll();
    if(qs.equals("#")) return null;
    TreeNode node = new TreeNode(Integer.parseInt(qs));
    node.left = dser(q);
    node.right = dser(q);
    return node;
    }
}
        
        
    


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));