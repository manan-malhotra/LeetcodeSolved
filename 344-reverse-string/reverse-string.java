class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        f(0,n-1,s);
    }
    public void f(int l,int r,char[]s){
        if(l>=r) return;
        swap(l,r,s);
        l++;
        r--;
        f(l,r,s);
    }
    public void swap(int l,int r,char[]s){
        char temp = s[l];
        s[l]=s[r];
        s[r]=temp;
    }
}