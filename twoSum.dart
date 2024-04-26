class Solution {
  List<int> twoSum(List<int> nums, int target) {
    var result = <int>[];
    var map = Map<int, int>();
    for (int i = 0; i < nums.length; i++) {
        map[target - nums[i]] = i;
    }
    for (int i = 0; i < nums.length; i++) {
        int targetNumber = nums[i];
        int? targetIndex = map[targetNumber];
        
        if (targetIndex == i || targetIndex == null) {
            continue;
        }

        if (targetIndex < i) {
            result = [targetIndex, i];
            break;
        }

        result = [i, targetIndex];
    }

    return result;
  }
}
