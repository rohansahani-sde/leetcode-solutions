# 987. Vertical Order Traversal of a Binary Tree

### Difficulty: Hard

## Description
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 
Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.

Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.


Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.


 
Constraints:


	The number of nodes in the tree is in the range [1, 1000].
	0 <= Node.val <= 1000

## Submission Details
- **Status**: Accepted
- **Runtime**: 4
- **Memory**: 44452000
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
    class Pair{
        TreeNode node;
        int col;
        int row;
        Pair(TreeNode node, int col, int row){
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, TreeMap<Integer, List<Integer>> > map = new TreeMap<>();
        
        bfs(root, map);

        for(TreeMap<Integer, List<Integer>> mp: map.values()){
            List<Integer> temp = new ArrayList<>();
            for(List<Integer> l: mp.values()){
                Collections.sort(l);
                for(int x: l) temp.add(x);

            }
            ans.add(temp);
        }
        return ans;
    }
    private void bfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>> > map){
        if(root == null)return;
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root, 0, 0));
        while(!que.isEmpty()){
            Pair curr = que.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(node.val);
             
               
            if(node.left != null) que.offer(new Pair(node.left, col-1, row+1));
            if(node.right != null) que.offer(new Pair(node.right, col+1, row+1));
            
        }
    }
}
```
