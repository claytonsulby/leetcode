class Solution {
    public boolean isPalindrome(int x) {
        System.out.println(getReversedNumber(x));
        if (x < 0) {
            return false;
        }
        return x == getReversedNumber(x);
    }

    public int getReversedNumber(final int number) {
        int localNumber = number;
        int reversedNumber = 0;
        while (localNumber > 0) {
            int nextShiftedBit = localNumber % 10;
            if(reversedNumber > (Integer.MAX_VALUE - nextShiftedBit) / 10) { 
                //check if the next iteration would be larger than the max int
                return 0;
            }
            reversedNumber *= 10;
            reversedNumber += nextShiftedBit;
            localNumber /= 10;
        }
        return reversedNumber;
    }
}
