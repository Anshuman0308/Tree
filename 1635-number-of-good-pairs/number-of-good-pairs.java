class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        int ans = 0;

        for (int num : nums) {
            ans += freq[num];
            freq[num]++;
        }

        return ans;
    }
}