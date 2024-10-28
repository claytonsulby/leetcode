class Solution {
    public boolean isPalindrome(String s) {
        String trimmed = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (trimmed.length() == 0) {
            return true;
        }
        int left = 0;
        int right = trimmed.length() - 1;
        while (left < right && trimmed.charAt(left) == trimmed.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }
}

//Mistake: needed to look up regex
