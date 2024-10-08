class Solution {
    public int[] kWeakestRows(int[][] arr, int k) {
                ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int res[] = new int[k];

        for (int i = 0; i < arr.length; i++) {
            int c = 0;
            ArrayList<Integer> rowList = new ArrayList<>(); 
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1)
                    c++;
            }
            rowList.add(c);
            rowList.add(i);
            list.add(rowList); 
        }

        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                Integer firstElement1 = list1.get(0);
                Integer firstElement2 = list2.get(0);
                return firstElement1.compareTo(firstElement2);
            }
        });

        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).get(1);
        }
        return res;
    }
}