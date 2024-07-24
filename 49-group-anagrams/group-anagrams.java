class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedArray = new String(strArray);
            if(!map.containsKey(sortedArray)){
                map.put(sortedArray, new ArrayList<>());
            }
            map.get(sortedArray).add(str);
        }
        return new ArrayList<>(map.values());
    }
}