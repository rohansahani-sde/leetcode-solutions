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