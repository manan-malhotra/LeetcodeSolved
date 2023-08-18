class Solution {
    public static List<Integer> intersection(int[][] nums) {
		List<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				if (map.containsKey(nums[i][j])) {
					map.put(nums[i][j], map.get(nums[i][j]) + 1);
				} else {
					map.put(nums[i][j], 1);
				}
			}
		}
        for (Map.Entry<Integer, Integer> ans : map.entrySet()) {
			if (ans.getValue() == nums.length) {
				list.add(ans.getKey());
			}
		}		Collections.sort(list);
		return list;
	}
}