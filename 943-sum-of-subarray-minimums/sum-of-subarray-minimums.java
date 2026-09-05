class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int[] pse = new int[n];
        int[] nse = new int[n];

        Arrays.fill(pse, -1);
        Arrays.fill(nse, n);

        Stack<Integer> st = new Stack<>();

        // PSE
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // NSE
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        long ans = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {

            long left = i - pse[i];
            long right = nse[i] - i;

            ans = (ans + arr[i] * left * right) % MOD;
        }

        return (int) ans;
    }
}