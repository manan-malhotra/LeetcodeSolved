class Solution {
    public String reversePrefix(String word, char ch) {
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()){
            if(!found){
                sb.append(c);
                if(c==ch) {
                    found=true;
                    sb=sb.reverse();
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}