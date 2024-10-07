class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int ans = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        int n = seats.length;
        for(int i=0; i<n;i++){
            ans += Math.abs(seats[i]-students[i]);
        }
        return Math.abs(ans);
    }
}
// 12 12 14 19 19
// 02 07 17 19 20
// 10 05 03 00 01 
