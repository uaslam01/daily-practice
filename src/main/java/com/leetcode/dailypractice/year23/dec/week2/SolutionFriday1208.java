https://leetcode.com/problems/construct-string-from-binary-tree/
606. Construct String from Binary Tree
Easy
3.1K
3.6K
Companies
Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.

 

Example 1:


Input: root = [1,2,3,4]
Output: "1(2(4))(3)"
Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
Example 2:


Input: root = [1,2,3,null,4]
Output: "1(2()(4))(3)"
Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-1000 <= Node.val <= 1000
Accepted
279.3K
Submissions
412.9K
Acceptance Rate
67.6%
Seen this question in a real interview before?
1/4https://leetcode.com/problems/construct-string-from-binary-tree/

class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        dfs(root, result);

        return result.toString();        
    }

    private void dfs(TreeNode node, StringBuilder result) {
        if (node == null) {
            return;
        }

        result.append(node.val);

        if (node.left != null || node.right != null) {
            result.append("(");
            dfs(node.left, result);
            result.append(")");

            if (node.right != null) {
                result.append("(");
                dfs(node.right, result);
                result.append(")");
            }
        }
    }    
}