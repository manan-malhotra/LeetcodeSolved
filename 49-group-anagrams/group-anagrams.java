class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedStr = new String(strArr);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr,new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        for(List<String> temp : map.values()){
            ans.add(temp);
        }
        return ans;
    }
}