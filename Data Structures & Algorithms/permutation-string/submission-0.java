class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        int l = 0;
        int r = s1.length();
        for (int i = l; i < r; i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        while (r <= s2.length()) {
            if (map1.equals(map2)) {
                return true;
            }

            // Left character remove/decrease
            char leftChar = s2.charAt(l);
            map2.put(leftChar, map2.get(leftChar) - 1);

            if (map2.get(leftChar) == 0) {
                map2.remove(leftChar);
            }

            // Right character add
            if (r < s2.length()) {
                char rightChar = s2.charAt(r);
                map2.put(rightChar, map2.getOrDefault(rightChar, 0) + 1);
            }

            l++;
            r++;
        }

        return false;
    }
}
