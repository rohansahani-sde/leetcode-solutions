# 442. Find All Duplicates in an Array

### Difficulty: Medium

## Description
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output

 
Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:
Input: nums = [1,1,2]
Output: [1]
Example 3:
Input: nums = [1]
Output: []

 
Constraints:


	n == nums.length
	1 <= n <= 105
	1 <= nums[i] <= n
	Each element in nums appears once or twice.

## Submission Details
- **Status**: Accepted
- **Runtime**: 4
- **Memory**: 61636000
- **Language**: java

## Code
```java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] feq = new int[n+1];
        for(int i=0; i<n; i++){
            feq[nums[i]]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            if(feq[i] == 2){
                ans.add(i);
            }
        }
        return ans;


    }
}
```
