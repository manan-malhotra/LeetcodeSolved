class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();
        if(k>n) return false;
        int i=0,j=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)-1);
        }
        int count = map.size();
        while(j!=n){
            map.put(s2.charAt(j),map.getOrDefault(s2.charAt(j),0)+1);
            int temp = map.get(s2.charAt(j));
            if(temp==1) count++;
            else if(temp==0) count--;
            if(j-i+1==k){
                if(count==0) return true;
                map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
                 temp = map.get(s2.charAt(i));
                if(temp==0) count--;
                else if(temp==-1) count++;
                i++;
            }
            j++;
        }
        return false;
    }
}