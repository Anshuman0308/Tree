class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();
        for(char c: num.toCharArray()){
            while(k > 0 &&!st.isEmpty() && st.peek() > c){

                st.pop();
                k--;
            }
            st.push(c);
            }           
                while (k > 0 && !st.isEmpty()) {
                    st.pop();
                    k--;
                }
        
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty()) sb.append(st.pop());
                sb.reverse();
                while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
                return sb.length() == 0 ? "0" : sb.toString();
}
}
