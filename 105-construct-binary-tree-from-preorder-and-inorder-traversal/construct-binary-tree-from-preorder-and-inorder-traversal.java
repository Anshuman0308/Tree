class Solution {

    int preorderIndex = 0;
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int inLeft, int inRight) {

        if (inLeft > inRight)
            return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = indexMap.get(rootVal);

        root.left = build(preorder, inLeft, mid - 1);
        root.right = build(preorder, mid + 1, inRight);

        return root;
    }
}