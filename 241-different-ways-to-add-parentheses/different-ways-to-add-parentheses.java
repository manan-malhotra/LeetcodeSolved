class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for(int indx = 0; indx<expression.length(); indx++){
            char ch = expression.charAt(indx);
            if(ch == '+' || ch == '-' || ch == '*'){
                String leftPart = expression.substring(0,indx);
                String rightPart = expression.substring(indx+1);
                List<Integer> leftList = diffWaysToCompute(leftPart);
                List<Integer> rightList = diffWaysToCompute(rightPart);
                for(int l : leftList){
                    for(int r : rightList){
                        if(ch == '+'){
                            res.add((l + r));
                        }else if(ch == '-'){
                            res.add((l - r));
                        }else if(ch == '*'){
                            res.add((l * r));
                        }
                    }
                }
            }
        }
        if(res.size() == 0) res.add(Integer.valueOf(expression));
        return res;
    }
}