class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int count=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String s = q.poll();
                char[] arr = s.toCharArray();
                if(s.equals(endWord)) return count;
                int n = arr.length;
                for(int j=0; j<n; j++){
                    char or = arr[j];
                    for(char ch='a'; ch<= 'z'; ch++){
                        arr[j] = ch;
                        String newStr = new String(arr);
                        if(set.contains(newStr)){
                            q.offer(newStr);
                            set.remove(newStr);
                        }
                    }
                    arr[j] = or;
                }
            }
            count++;
        }
        return 0;
    }
}