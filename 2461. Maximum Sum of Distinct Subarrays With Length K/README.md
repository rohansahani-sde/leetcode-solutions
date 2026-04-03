
# 2461. Maximum Sum of Distinct Subarrays With Length K

### Medium

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>. Find the maximum subarray sum of all the subarrays of <code>nums</code> that meet the following conditions:</p>

<ul>
	<li>The length of the subarray is <code>k</code>, and</li>
	<li>All the elements of the subarray are <strong>distinct</strong>.</li>
</ul>

<p>Return <em>the maximum subarray sum of all the subarrays that meet the conditions</em><em>.</em> If no subarray meets the conditions, return <code>0</code>.</p>

<p><em>A <strong>subarray</strong> is a contiguous non-empty sequence of elements within an array.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,5,4,2,9,9,9], k = 3
<strong>Output:</strong> 15
<strong>Explanation:</strong> The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,4,4], k = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


---
## 🚀 Submission Details
- **Status**: Accepted
- **Runtime**: 56 ms
- **Memory**: 99.4 MB

## 💻 Code
```java
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int j=0;
        long sum =0;
        long max = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(i-j+1 > k){
                map.put(nums[j], map.get(nums[j])-1);
                if(map.get(nums[j]) ==0) map.remove(nums[j]);
                sum -= nums[j++];
            }
            if(i-j+1 ==k && map.size() == k){
                max = Math.max(max, sum);
            }

        }
        return max;
    }
}
```
        