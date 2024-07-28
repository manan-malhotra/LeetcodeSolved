class Solution {
    public int numberOfSubstrings(String s) {
        int output = 0;
        int prefix[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(i == 0) prefix[i] = (s.charAt(i) == '1')? 1:0;
            else prefix[i] = prefix[i-1] + ((s.charAt(i) == '1')? 1:0);
        }
        for(int i=0;i<s.length();i++){
            int count = 0,one = 0;
            for(int j=i;j<s.length();j++){
                one = prefix[j]-((i == 0)?0:prefix[i-1]); //count of one
                count = j-i+1-one;  //count of zero
                if(count*count > one)  j+=((count*count)-one-1);  //jump where next soltuion is possible
                if(count*count <= one) {
                    int kl = (int)Math.sqrt(one);
                    output++;
                    if(kl>count){  //again jump where zero can be greater than one.
                        output += (j+(kl-count))>=s.length()?(s.length()-j-1):(kl-count); //condition added just to ensure not to exceed the s.length()
                        j = j+(kl-count);
                    }
                }
            }
        }
        return output;
    }
}