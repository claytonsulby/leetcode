import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Test case 2
        List<Integer> prices2 = Arrays.asList(1, 2, 3, 4, 5);
        int k2 = 3;
        int threshold2 = 12;
        System.out.println("Test case 1: " + reduceGifts(prices2, k2, threshold2));

        // Test case 2
        List<Integer> prices1 = Arrays.asList(1, 2, 3, 4, 5);
        int k1 = 3;
        int threshold1 = 11;
        System.out.println("Test case 2: " + reduceGifts(prices1, k1, threshold1));

    }

    //my solution
    public static int reduceGifts2(List<Integer> prices, int k, int threshold) {
        Collections.sort(prices); // quickSort

        // find max difference using k largest values
        int difference = threshold;
        int removedGifts = 0;

        for (int i = 0; i < k; i++) {
            int index = prices.size() - 1 - i - removedGifts;
            if (index < 0) {
                break;
            }
            difference -= prices.get(index);
            if (difference < 0) {
                difference += prices.get(prices.size() - 1 - removedGifts);
                i = 0;
                removedGifts++;
            }
        }
        return removedGifts;
    }

    //chat gpt
    public static int reduceGifts(List<Integer> prices, int k, int threshold) {
        Collections.sort(prices);

        int removedGifts = 0;
        int sum;
        do {
            sum = 0;
            for (int i = 0; i < k; i++) {
                sum += prices.get(prices.size() - 1 - i - removedGifts);
            }
            if (sum > threshold) {
                removedGifts++;
            }
        } while (sum > threshold);
        return removedGifts;
    }
}
