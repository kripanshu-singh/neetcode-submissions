class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            String curr = strs[i];
            char[] charArray = curr.toCharArray();
            Arrays.sort(charArray);
            String signature = new String(charArray);

            if(!map.containsKey(signature)){
                map.put(signature, new ArrayList<>());
            }

            map.get(signature).add(curr);
        }
        return new ArrayList<>(map.values());
    }
}
