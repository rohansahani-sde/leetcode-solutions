class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> st = new Stack<>();
         for(int x: asteroids){
            if(x > 0){
                st.push(x);
            }
            else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -x){
                    st.pop();
                }

                if(st.isEmpty() || st.peek() < 0){
                    st.push(x);
                }
                if(st.peek() == -x ){
                    st.pop();
                }
            }
         }
         int[] ans = new int[st.size()];
         int i = st.size()-1;
         while(!st.isEmpty()){
            ans[i--] = st.pop();
         }
         return ans;

    }

}



