class Solution {
    int mod = (int) 1e9 + 7;
public int maxProfit(int[] inventory, int orders) {
    long profit = 0;
    int k = smallestK(inventory, orders);

    for (int inv : inventory) {
        if (inv > k) {
            profit = (profit + 1L * (inv + k + 1) * (inv - k) / 2) % mod;
            orders -= inv - k;
        }
    }
    return (int) ((profit + 1L * orders * k) % mod);
}

int smallestK(int[] inventory, int target) {
    int max = Integer.MIN_VALUE;
    for (int inv : inventory) max = Math.max(max, inv);

    int left = 0, right = max;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (sum(inventory, mid) > target) left = mid + 1;
        else right = mid;
    }
    return left;
}

long sum(int[] inventory, int k) {
    long sum = 0;
    for (int i : inventory) {
        if (i > k) sum += i - k;
    }
    return sum;
}
}