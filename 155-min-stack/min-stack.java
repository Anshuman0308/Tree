class MinStack {

    Stack<Long> st = new Stack<>();
    long min;

    public MinStack() {
    }

    public void push(int value) {

        long val = value;

        if (st.isEmpty()) {
            st.push(val);
            min = val;
        } 
        else if (val < min) {
            st.push(2 * val - min);
            min = val;
        } 
        else {
            st.push(val);
        }
    }

    public void pop() {

        long top = st.peek();

        if (top < min) {
            min = 2 * min - top;
        }

        st.pop();
    }

    public int top() {

        long top = st.peek();

        if (top < min) {
            return (int) min;
        }

        return (int) top;
    }

    public int getMin() {
        return (int) min;
    }
}