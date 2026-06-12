# 90. Subsets II

### Difficulty: Medium

## Description
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

&nbsp;
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

&nbsp;
Constraints:


	1 &lt;= nums.length &lt;= 10
	-10 &lt;= nums[i] &lt;= 10

## Submission Details
- **Status**: Accepted
- **Runtime**: 4
- **Memory**: 45076000
- **Language**: java

## Code
```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        fun(nums, 0, ans, set, new ArrayList<>());
        return ans;
    }
    private void fun(int[] arr, int idx, List<List<Integer>> ans, Set<List<Integer>> set, List<Integer> l){
        if(idx == arr.length){
            if(!set.contains(l)){
                set.add(l);
                ans.add(new ArrayList<>(l));
            }
            return;
        }
        l.add(arr[idx]);
        fun(arr, idx+1, ans, set, l);
        l.remove(l.size()-1);
        fun(arr, idx+1, ans, set, l);
    }
}
```
