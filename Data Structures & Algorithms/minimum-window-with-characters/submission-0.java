class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Required frequency
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int have = 0;
        int needCount = need.size();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);

            // Add character to window
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Requirement for this character completed
            if (need.containsKey(c)
                    && window.get(c).equals(need.get(c))) {
                have++;
            }

            // Valid window -> shrink from left
            while (have == needCount) {

                // Update minimum window
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);

                // Remove left character
                window.put(
                    leftChar,
                    window.get(leftChar) - 1
                );

                // Requirement becomes incomplete
                if (need.containsKey(leftChar)
                        && window.get(leftChar) < need.get(leftChar)) {
                    have--;
                }

                l++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}