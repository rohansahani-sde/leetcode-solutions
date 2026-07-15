# 30. Substring with Concatenation of All Words

### Difficulty: Hard

## Description
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.


	For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.


Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

 
Example 1:


Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.


Example 2:


Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.


Example 3:


Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].


 
Constraints:


	1 <= s.length <= 104
	1 <= words.length <= 5000
	1 <= words[i].length <= 30
	s and words[i] consist of lowercase English letters.

## Submission Details
- **Status**: Accepted
- **Runtime**: 176
- **Memory**: 47388000
- **Language**: java

## Code
```java
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
       int len = words[0].length() * words.length;
       int wordLen = words[0].length();
       int n = s.length(); 

       Map<String, Integer> map = new HashMap<>();
       for(String str: words) map.put(str, map.getOrDefault(str, 0)+1 );

       for(int i=0; i<wordLen; i++){
        Map<String, Integer> curr = new HashMap<>();
        int l =i, r = i;
        int count=0;
        while(r + wordLen <= n){
            String str = s.substring(r, r+wordLen);
            System.out.println(str);
            r += wordLen;
            if(!map.containsKey(str)){
               count=0;
               l = r;
               curr.clear();
               continue;
            }
            curr.put(str, curr.getOrDefault(str, 0) +1 );
            count++;
            while(curr.get(str) > map.get(str)){
                String temp = s.substring(l, l+wordLen);
                curr.put(temp, curr.get(temp) -1);
                l += wordLen;
                count--;
            }
            if(count == words.length) ans.add(l);


        }
       }



        return ans;
    }
    // private boolean check(String s, int len, Map<String, Integer> map){
    //     Map<String, Integer> mp = new HashMap<>(map);
    //     int n = s.length();
    //     for(int i=0; i<n; i+= len){
    //         String str = s.substring(i, i+len);

    //         if (!mp.containsKey(str)) return false;

    //         mp.put(str, mp.get(str) - 1);
    //         if (mp.get(str) == 0) {
    //             mp.remove(str);
    //         }



    //     }
    //      return mp.isEmpty();
        
    // }
}
```
