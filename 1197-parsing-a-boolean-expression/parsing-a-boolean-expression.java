class Solution {
    public boolean parseBoolExpr(String expression) {
        if(expression.charAt(0) == 't'){
            return true;
        }
        if(expression.charAt(0) == 'f'){
            return false;
        }
        if(expression.charAt(0)=='!'){
            return !parseBoolExpr(expression.substring(2,expression.length()-1));
        }
        return parseList(expression.substring(2,expression.length()-1),expression.charAt(0)=='|');
        
    }

    private boolean parseList(String expression, boolean operator){
        int parenParity = 0;
        int prevIdx = 0;
        int idx = 0;
        while(idx<expression.length()){
            if(expression.charAt(idx)=='('){
                parenParity++;
            }
            else if(expression.charAt(idx)==')'){
                parenParity--;
            }
            else if(expression.charAt(idx)==',' && parenParity==0){
                if(parseBoolExpr(expression.substring(prevIdx,idx))==operator){
                    return operator;
                }
                prevIdx=idx+1;
            }
            idx++;
        }
        if(parseBoolExpr(expression.substring(prevIdx,idx))==operator){
            return operator;
        }
        return !operator;
    }
}