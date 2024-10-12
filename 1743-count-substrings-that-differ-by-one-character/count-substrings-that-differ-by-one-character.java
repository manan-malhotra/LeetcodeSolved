class Solution {
    public int countSubstrings(String s, String t) {
        int ans =0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<t.length();j++)
            {
                int count =0;
                for(int k=0;i+k<s.length()&&j+k<t.length();k++)
                {
                    if(s.charAt(i+k)!=t.charAt(j+k))
                    {
                        count++;
                    }
                    if(count==1)
                     ans++;
                }
            }
            
        }
        return ans;
    }
}