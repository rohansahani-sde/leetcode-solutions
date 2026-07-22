# 111. Minimum Depth of Binary Tree

### Difficulty: Easy

## Description
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 
Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2


Example 2:


Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


 
Constraints:


	The number of nodes in the tree is in the range [0, 105].
	-1000 <= Node.val <= 1000

## Submission Details
- **Status**: Accepted
- **Runtime**: 2
- **Memory**: 82064000
- **Language**: java

## Code
```java
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return bfs(root);
    }
    private int bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int c =1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                c++;
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
            else{
                if(node.left == null && node.right == null) return c;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return c;
    }
}
```
