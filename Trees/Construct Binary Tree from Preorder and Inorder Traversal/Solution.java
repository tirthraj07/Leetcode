import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

@SuppressWarnings("all")
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int root_val = preorder[0];
        TreeNode root = new TreeNode(root_val);
        int pivot = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root_val) {
                pivot = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, pivot + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, pivot);

        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, pivot + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, pivot + 1, inorder.length);

        root.right = buildTree(rightPreorder, rightInorder);

        return root;

    }
}