// class Solution {
//     public int sumSubarrayranges(int[] arr) {

//         int n = arr.length;
//         int[] pse = new int[n];
//         int[] nse = new int[n];
//         int[] pge = new int[n];
//         int[] nge = new int[n];

//         Arrays.fill(pse, -1);
//         Arrays.fill(nse, n);

//         Stack<Integer> st = new Stack<>();

//         // PSE
//         for (int i = 0; i < n; i++) {

//             while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
//                 st.pop();
//             }

//             if (!st.isEmpty()) {
//                 pse[i] = st.peek();
//             }

//             st.push(i);
//         }

//         st.clear();
//         //pge
//         for (int i = 0; i < n; i++) {

//             while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
//                 st.pop();
//             }

//             if (!st.isEmpty()) {
//                 pge[i] = st.peek();
//             }

//             st.push(i);
//         }

//         st.clear();
//         //nge
//         for (int i = n - 1; i >= 0; i--) {

//             while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
//                 st.pop();
//             }

//             if (!st.isEmpty()) {
//                 nge[i] = st.peek();
//             }

//             st.push(i);
//         }
//          st.clear();

//         // NSE
//         for (int i = n - 1; i >= 0; i--) {

//             while (!st.isEmpty() && arr[st.peek()] => arr[i]) {
//                 st.pop();
//             }

//             if (!st.isEmpty()) {
//                 nse[i] = st.peek();
//             }

//             st.push(i);
//         }

//         long ans = 0;
//         int MOD = 1_000_000_007;

//         for (int i = 0; i < n; i++) {

//             long left = i - pse[i];
//             long right = nse[i] - i;

//             ans = (ans + arr[i] * left * right) % MOD;
//         }
//          for (int j = 0; j < n; j++) {

//             long left1 = i - pge[i];
//             long right1 = nge[i] - i;

//             ans1 = (ans + arr[i] * left * right) % MOD;
//         }

//         return (int) ans1 - ans;
//     }
// }
class Solution {
    public long subArrayRanges(int[] arr) {

        int n = arr.length;

        int[] pse = new int[n];
        int[] nse = new int[n];
        int[] pge = new int[n];
        int[] nge = new int[n];

        Arrays.fill(pse, -1);
        Arrays.fill(nse, n);
        Arrays.fill(pge, -1);
        Arrays.fill(nge, n);

        Stack<Integer> st = new Stack<>();

        // PSE - Previous Smaller Element
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // PGE - Previous Greater Element
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                pge[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // NGE - Next Greater Element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                nge[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // NSE - Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        long minSum = 0;
        long maxSum = 0;

        // Sum of subarray minimums
        for (int i = 0; i < n; i++) {

            long left = i - pse[i];
            long right = nse[i] - i;

            minSum += (long) arr[i] * left * right;
        }

        // Sum of subarray maximums
        for (int i = 0; i < n; i++) {

            long left = i - pge[i];
            long right = nge[i] - i;

            maxSum += (long) arr[i] * left * right;
        }

        return maxSum - minSum;
    }
}