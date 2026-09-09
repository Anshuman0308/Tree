class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int rslt[] = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i =0;i < n;i++){
            while(!st.isEmpty() && temperatures[st.peek() ] < temperatures[i]){
                int idx = st.pop();
                rslt[idx] = i - idx;

            }
            st.push(i);

        } 
        return rslt;
        
    }
}