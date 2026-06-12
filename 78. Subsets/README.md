# 78. Subsets

### Difficulty: Medium

## Description
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

&nbsp;
Example 1:


Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]


Example 2:


Input: nums = [0]
Output: [[],[0]]


&nbsp;
Constraints:


	1 &lt;= nums.length &lt;= 10
	-10 &lt;= nums[i] &lt;= 10
	All the numbers of&nbsp;nums are unique.

## Submission Details
- **Status**: Accepted
- **Runtime**: 1
- **Memory**: 44452000
- **Language**: java

## Code
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, 0, ans, new HashSet<>(), new ArrayList<>());
        return ans;
    }
    private void fun(int[] arr, int idx, List<List<Integer>> ans, Set<List<Integer>> set , List<Integer> curr){
        if(idx == arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        fun(arr, idx+1, ans, set, curr);
        curr.add(arr[idx]);
        fun(arr, idx+1, ans, set, curr);
        curr.remove(curr.size()-1);
    }
}
```
