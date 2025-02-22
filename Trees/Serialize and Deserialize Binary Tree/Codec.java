import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    private List<String> nodes;
    private int index;

    private void dfs(TreeNode root) {
        if (root == null) {
            nodes.add("N");
            return;
        }

        nodes.add(Integer.toString(root.val));
        dfs(root.left);
        dfs(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        nodes = new LinkedList<>();
        dfs(root);

        return String.join(",", nodes);
    }

    private TreeNode buildTree(String[] nodeList) {
        if (nodeList[index].equals("N")) {
            index += 1;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodeList[index]));
        index += 1;

        root.left = buildTree(nodeList);
        root.right = buildTree(nodeList);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] deserializedNodes = data.split(",");
        index = 0;
        TreeNode root = buildTree(deserializedNodes);
        return root;
    }
}

// This solution doesn't work is the tree has duplicate values. Testcase 39/53
class Codec2 {

    private StringBuilder preorder;
    private StringBuilder inorder;

    private void buildInorder(TreeNode root) {
        if (root == null)
            return;
        buildInorder(root.left);
        inorder.append(root.val).append(",");
        buildInorder(root.right);
    }

    private void buildPreorder(TreeNode root) {
        if (root == null)
            return;
        preorder.append(root.val).append(",");
        buildPreorder(root.left);
        buildPreorder(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preorder = new StringBuilder();
        inorder = new StringBuilder();

        buildInorder(root);
        buildPreorder(root);

        return preorder.toString() + "|" + inorder.toString();
    }

    private TreeNode createTreeFromPreorderAndInorder(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;

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
        root.left = createTreeFromPreorderAndInorder(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, pivot + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, pivot + 1, inorder.length);
        root.right = createTreeFromPreorderAndInorder(rightPreorder, rightInorder);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] components = data.split("\\|");
        String preorderStr = components[0];
        String inorderStr = components[1];

        if (preorder.isEmpty() || inorder.isEmpty())
            return null;

        int[] preorderNodes = Arrays.stream(preorderStr.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] inorderNodes = Arrays.stream(inorderStr.split(",")).mapToInt(Integer::parseInt).toArray();

        return createTreeFromPreorderAndInorder(preorderNodes, inorderNodes);

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
