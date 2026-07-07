class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        

        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            int pos = cars[i][0];
            int speed = cars[i][1];
            while(!st.isEmpty()){
                int top = st.peek();

                int nextPos = cars[top][0];
                int nextSpeed = cars[top][1];

                if(speed <= nextSpeed){
                    st.pop();   
                }
                else{
                    double time= (double) (nextPos - pos) / (speed - nextSpeed);
                    if(ans[top] == -1 || time <= ans[top]){
                        ans[i] = time;
                        break;
                    }
                    st.pop();
                }               
            }
            st.push(i);
        }
        return ans;
        
    }
}