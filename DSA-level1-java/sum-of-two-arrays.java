import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        // Input for the first array
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = scn.nextInt();
        }

        // Input for the second array
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = scn.nextInt();
        }

        // Resultant sum array
        int[] sum = new int[Math.max(n1, n2)];
        int c = 0;

        int i = a1.length - 1; // Pointer for a1
        int j = a2.length - 1; // Pointer for a2
        int k = sum.length - 1; // Pointer for sum

        while (k >= 0) {
            int d = c; // Start with the carry
            if (i >= 0) {
                d += a1[i];
            }
            if (j >= 0) {
                d += a2[j]; // Use j here for a2
            }
            c = d / 10; // Calculate new carry
            d = d % 10; // Keep the last digit
            sum[k] = d; // Store in sum array
            i--;
            j--;
            k--;
        }

        // If there's a carry left, print it
        if (c != 0) {
            System.out.print(c);
        }

        // Print the sum array
        for (int val : sum) {
            System.out.print(val);
        }
    }
}