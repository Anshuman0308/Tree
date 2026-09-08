class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for( char c: s.toCharArray()){
            if( !st.isEmpty() && st.peek()  == c){
                st.pop();

            }else{
                st.push(c);
            }

        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pollLast());
        }
        return sb.toString();
        
    }
}