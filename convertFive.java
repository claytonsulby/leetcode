//{ Driver Code Starts
import java.util.Scanner;
import java.lang.Math;

class Convert_To_Five {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            System.out.println(new GfG().convertfive(N));
            T--;
        }
    }
}
// } Driver Code Ends

class GfG {
    int convertfive(int num) {
        return convertfiveUsingBitShifting(num);
    }
    
    int convertfiveUsingBitShifting(int num) {
        int returningNumber = num;
        int iteratingNumber = num;
        for (int i = 0; i < String.format("%d", num).length(); i++) { //TODO: find length of int
            int modulusByTen = iteratingNumber % 10;
            if (modulusByTen == 0) {
              /*
                * was incorrectly written as (i * 10) + 5 then (i * 10) * 5
                */
               returningNumber += (Math.pow(10, i) * 5);
            }
            iteratingNumber /= 10;
        }
        return returningNumber;
    }
    
    int convertfiveUsingFormattedString(int num) {
        String temporaryOutput = "";
        String stringNumber = String.format("%d", num);
        String[] splitString = stringNumber.split("");
        
        for (String character : splitString) {
            String modifiedDigitIfZero = character == "0" ? "5" : character;
            temporaryOutput = String.format("%s%s", temporaryOutput, modifiedDigitIfZero);
        }
        
        return Integer.valueOf(temporaryOutput);
    }
    
}
