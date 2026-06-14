# 46. Permutations

### Difficulty: Medium

## Description
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

&nbsp;
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:
Input: nums = [1]
Output: [[1]]

&nbsp;
Constraints:


	1 &lt;= nums.length &lt;= 6
	-10 &lt;= nums[i] &lt;= 10
	All the integers of nums are unique.

## Submission Details
- **Status**: Accepted
- **Runtime**: 1
- **Memory**: 45472000
- **Language**: java

## Code
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, ans, new ArrayList<>(), vis);
        return ans;

    }
    private void fun(int[] arr, List<List<Integer>> ans, List<Integer> l, boolean[] vis){
        if(l.size()  == arr.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<arr.length; i++){
            if(!vis[i]){
                l.add(arr[i]);
                vis[i] = true;
                fun(arr, ans, l, vis);
                l.remove(l.size()-1);
                vis[i] = false;
            }
        }
    }
}
```
