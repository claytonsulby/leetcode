class Solution {
    public boolean isPalindrome(int x) {
        return x == getReversedNumber(x);
    }

    public int getReversedNumber(final int number) {
        int localNumber = number;
        int reversedNumber = 0;
        while (localNumber > 0) {
            reversedNumber = reversedNumber * 10;
            reversedNumber += localNumber % 10;
            localNumber = localNumber / 10;
        }
        return reversedNumber;
    }
}
