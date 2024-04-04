class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer targetIndice = map.get(nums[i]);
            if (targetIndice != null) {
                if (i == targetIndice) {
                    continue;
                }
                result[0] = targetIndice < i ? targetIndice : i;
                result[1] = targetIndice < i ? i : targetIndice;
            }
        }

        return result;
    }
}
