class Solution {
    public int totalNQueens(int n) {
        int[] ans = new int[1];
        List<String> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        for(int j=0;j<n;j++){
            sb.append(".");
        }
        for(int i=0;i<n;i++){
            temp.add(sb.toString());
        }
        solve(ans,temp,0);
        return ans[0];
    }
    public void solve(int[] ans, List<String> temp, int i){
        if(i==temp.size()){
            ans[0]++;
            return;
        }
        for(int j=0;j<temp.size();j++){
            if(isValid(temp,i,j)){
                StringBuilder newRow=new StringBuilder(temp.get(i));
                newRow.setCharAt(j,'Q');
                temp.set(i,newRow.toString());
                solve(ans,temp,i+1);
                newRow.setCharAt(j,'.');
                temp.set(i,newRow.toString());
            }
        }
    }
    public boolean isValid(List<String> temp, int row,int col){
        for(int i=row;i>=0;i--){
            if(temp.get(i).charAt(col)=='Q'){
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (temp.get(i).charAt(j) == 'Q')
                return false;
        }

        for (int i = row, j = col; i >= 0 && j < temp.size(); i--, j++) {
            if (temp.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
}