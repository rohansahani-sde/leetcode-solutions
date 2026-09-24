# 49. Group Anagrams

### Difficulty: Medium

## Description
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 
Example 1:


Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:


	There is no string in strs that can be rearranged to form "bat".
	The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
	The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.



Example 2:


Input: strs = [""]

Output: [[""]]


Example 3:


Input: strs = ["a"]

Output: [["a"]]


 
Constraints:


	1 <= strs.length <= 104
	0 <= strs[i].length <= 100
	strs[i] consists of lowercase English letters.

## Submission Details
- **Status**: Accepted
- **Runtime**: 20
- **Memory**: 51056000
- **Language**: java

## Code
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map= new HashMap<>();
        for(String s: strs){
            int[] arr = new int[26];
            for(char ch: s.toCharArray()) arr[ch -'a']++;
            String key= Arrays.toString(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
```
