# 113. Path Sum II

### Difficulty: Medium

## Description
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 
Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22


Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []


Example 3:


Input: root = [1,2], targetSum = 0
Output: []


 
Constraints:


	The number of nodes in the tree is in the range [0, 5000].
	-1000 <= Node.val <= 1000
	-1000 <= targetSum <= 1000

## Submission Details
- **Status**: Accepted
- **Runtime**: 1
- **Memory**: 45588000
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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        fun(root, 0, new ArrayList<>(), targetSum);
        return ans;
    }
    private void fun(TreeNode root, int sum, List<Integer>  curr, int k){
        if(root == null) return;
        curr.add(root.val);
         sum += root.val;
         if(root.left == null && root.right ==null && sum ==k)ans.add(new ArrayList<>(curr));

         fun(root.left, sum, curr, k);
         fun(root.right, sum, curr, k);
        
        curr.remove(curr.size()-1);


        
    }
}
```
