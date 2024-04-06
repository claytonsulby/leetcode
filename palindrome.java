class Solution {
    public boolean isPalindrome(int x) {
        String stringValue = String.format("%d", x);
        for (int i = 0; i < stringValue.length(); i++) {
            int decreasingIndice = stringValue.length() - i - 1;
            int increasingIndice = i;
            if (decreasingIndice <= increasingIndice) {
                break;
            }
            char decreasingChar = stringValue.charAt(decreasingIndice);
            char increasingChar = stringValue.charAt(increasingIndice);
            if (decreasingSubstring != increasingSubstring) {
                return false;
            }
        }
        return true;
    }
}
