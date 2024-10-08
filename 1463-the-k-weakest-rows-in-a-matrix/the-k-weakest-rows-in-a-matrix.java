class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> soldierCount = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            int count = countSoldiers(mat[i]);
            soldierCount.add(new int[]{count, i});
        }

        soldierCount.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = soldierCount.get(i)[1];
        }

        return result;
    }

    private int countSoldiers(int[] row) {
        int count = 0;
        for (int val : row) {
            if (val == 1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}