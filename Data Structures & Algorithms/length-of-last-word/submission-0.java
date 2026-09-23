class Solution {
    public int lengthOfLastWord(String s) {
        s = s.replaceAll("\\s+", " ").trim();

        int lastSpace = s.lastIndexOf(' ');
        if (lastSpace == -1) {
            return s.length(); 
        }
        return s.length() - lastSpace - 1;
    }
}
