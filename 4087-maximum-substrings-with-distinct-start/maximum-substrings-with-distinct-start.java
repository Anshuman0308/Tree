class Solution {
    public int maxDistinct(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        return mp.size();
    }
}
