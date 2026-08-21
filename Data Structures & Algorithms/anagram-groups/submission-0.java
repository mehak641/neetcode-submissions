class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String , List<String>> map = new HashMap<>();
        for( int i = 0; i < strs.length ;i++){
            char [] b = strs[i].toCharArray();
            Arrays.sort(b);
            String key = new String (b);
            if(!map.containsKey(key)){
                map.put(key , new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        res.addAll(map.values());
        return res;        
    }
}
