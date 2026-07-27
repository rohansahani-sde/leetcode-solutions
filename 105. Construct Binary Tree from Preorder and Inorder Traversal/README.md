# 105. Construct Binary Tree from Preorder and Inorder Traversal

### Difficulty: Medium

## Description
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 
Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]


Example 2:


Input: preorder = [-1], inorder = [-1]
Output: [-1]


 
Constraints:


	1 <= preorder.length <= 3000
	inorder.length == preorder.length
	-3000 <= preorder[i], inorder[i] <= 3000
	preorder and inorder consist of unique values.
	Each value of inorder also appears in preorder.
	preorder is guaranteed to be the preorder traversal of the tree.
	inorder is guaranteed to be the inorder traversal of the tree.

## Submission Details
- **Status**: Accepted
- **Runtime**: 1
- **Memory**: 46656000
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
     Map<Integer, Integer> map;
     int i=0;
    public TreeNode buildTree(int[] pre, int[] ino) {
        map = new HashMap<>();
        int n = pre.length;
        for(int i=0; i<n; i++){
            map.put(ino[i], i);
        }

        return fun(pre, ino, 0, n-1);
    }
    private TreeNode fun(int[] pre, int[] ino, int s, int e){
        if(s > e) return null;
        int idx = map.get(pre[i]);
        TreeNode node = new TreeNode(pre[i++]);
        node.left = fun(pre, ino, s, idx-1);
        node.right = fun(pre, ino, idx+1, e);

        return node;

    }
}
```
