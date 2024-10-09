class Solution {
    public String reversePrefix(String word, char ch) {
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()){
                sb.append(c);
                if(c==ch && !found) {
                    sb=sb.reverse();
                    found = true;
                }
        }
        return sb.toString();
    }
}