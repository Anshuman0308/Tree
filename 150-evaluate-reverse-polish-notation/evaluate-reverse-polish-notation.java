class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String T: tokens) {
            switch(T){
                case "+":
                case "-":
                case "*":
                case "/":
                int b = st.pop();
                int a = st.pop();
                st.push(apply0p(a, b, T));
                break;
                default:
                st.push(Integer.parseInt(T));

            }
        }
        return st.pop();
    }

public int apply0p(int a, int b, String op){
    switch(op){
       
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;





    }
    return 0;
}
}