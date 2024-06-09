public class Solution {
    public boolean checkValidString(String s) {
/*
 Initialize leftMin and leftMax to 0.
 Iterate through each character in the string s.
 If the character is '(', increment both leftMin and leftMax by 1.
 If the character is ')', decrement both leftMin and leftMax by 1.
 If the character is '*', decrement leftMin by 1 and increment leftMax by 1.
 If leftMax becomes negative at any point, return False since it means there are more closing parentheses than opening ones.
If leftMin becomes negative, reset it to 0 since we can't have negative open parentheses count.
After iterating through the string, check if leftMin is 0. If it is, return True; otherwise, return False.
*/
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0;
        }
        
        return leftMin == 0;
    }
}