/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParent(root, null, parentMap);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);
        visited.add(target);

        int dist = 0;

        while (!q.isEmpty()) {

            if (dist == k) {
                List<Integer> res = new ArrayList<>();
                for (TreeNode node : q) {
                    res.add(node.val);
                }
                return res;
            }

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                TreeNode[] neighbors = {
                    node.left,
                    node.right,
                    parentMap.get(node)
                };

                for (TreeNode neigh : neighbors) {
                    if (neigh != null && !visited.contains(neigh)) {
                        visited.add(neigh);
                        q.offer(neigh);
                    }
                }
            }

            dist++;
        }

        return new ArrayList<>();
    }

    private void buildParent(TreeNode node,
                             TreeNode parent,
                             Map<TreeNode, TreeNode> parentMap) {

        if (node == null) return;

        parentMap.put(node, parent);

        buildParent(node.left, node, parentMap);
        buildParent(node.right, node, parentMap);
    }
}