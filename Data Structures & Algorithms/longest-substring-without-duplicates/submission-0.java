class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxfreq = 0;
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.get(s.charAt(r)) > 1) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            maxfreq = Math.max(maxfreq, r - l + 1);
        }
        return maxfreq;
    }
}
