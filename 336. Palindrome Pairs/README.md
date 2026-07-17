# 336. Palindrome Pairs

### Difficulty: Hard

## Description
You are given a 0-indexed array of unique strings words.

A palindrome pair is a pair of integers (i, j) such that:


	0 <= i, j < words.length,
	i != j, and
	words[i] + words[j] (the concatenation of the two strings) is a palindrome.


Return an array of all the palindrome pairs of words.

You must write an algorithm with O(sum of words[i].length) runtime complexity.

 
Example 1:


Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]


Example 2:


Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]


Example 3:


Input: words = ["a",""]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["a","a"]


 
Constraints:


	1 <= words.length <= 5000
	0 <= words[i].length <= 300
	words[i] consists of lowercase English letters.

## Submission Details
- **Status**: Accepted
- **Runtime**: 1358
- **Memory**: 61892000
- **Language**: java

## Code
```java
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map =new HashMap<>();
        int n = words.length;
        for(int i=0; i<n; i++){
            map.put(words[i], i);
        }
        if(map.containsKey("")){
            int idx = map.get("");
            for(int i=0; i<n; i++){
                if(i == idx) continue;
                if(isPalindrome(words[i])){
                    ans.add(Arrays.asList(idx, i));
                    ans.add(Arrays.asList(i, idx));
                }
            }
        }
        for(int i=0; i<n; i++){
            String rev = reverse(words[i]);
            if(map.containsKey(rev)){
                int idx = map.get(rev);
                if(idx == i) continue;
                ans.add(Arrays.asList(i, idx));
            }
        }

        for(int i=0; i<n; i++){
            String str = words[i];
            for(int j=1; j<str.length(); j++){
                String left = str.substring(0, j);
                String right = str.substring(j);
                if(isPalindrome(left)){
                    String revRight = reverse(right);
                    if(map.containsKey(revRight)){
                        int idx = map.get(revRight);
                        if(idx == i)continue;
                        ans.add(Arrays.asList( idx , i ));
                    }
                }
                if(isPalindrome(right)){
                    String revLeft = reverse(left);
                    if(map.containsKey(revLeft)){
                        int idx = map.get(revLeft);
                        if(idx == i)continue;
                        ans.add(Arrays.asList( i, idx ));

                    }
                }
            }
        }
        
        return ans;
        
    }
    private String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    private boolean isPalindrome(String s){
        int n = s.length();
        int i=0, j=n-1;
        while( i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
```
