class Solution {
    public boolean isPalindrome(int x) {
        String stringValue = String.format("%d", x);
        int middlePoint = stringValue.length() / 2;
        for (int i = middlePoint; i > 0; i--) {
            int decreasingIndice = i - 1;
            int increasingIndice = stringValue.length() - i;
            if (stringValue.substring(decreasingIndice) != stringValue.substring(increasingIndice)) {
                return false;
            }
        }
        return true;
    }
}
