import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Input first array
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }

        // Input second array
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }

        // Result array
        int[] diff = new int[n2];
        int c = 0; // Carry
        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = diff.length - 1;

        // Compute the difference
        while (k >= 0) {
            int alv = (i >= 0 ? a1[i] : 0); // Value from a1 or 0 if out of bounds
            int blv = (j >= 0 ? a2[j] : 0); // Value from a2 or 0 if out of bounds

            int d = 0; // Difference
            if (blv + c >= alv) {
                d = blv + c - alv;
                c = 0;
            } else {
                d = blv + c + 10 - alv;
                c = -1;
            }

            diff[k] = d; // Store the difference
            i--;
            j--;
            k--;
        }

        // Skip leading zeros
        int idx = 0;
        while (idx < diff.length && diff[idx] == 0) {
            idx++;
        }

        // Print the result
        if (idx == diff.length) {
            System.out.print(0); // If all elements are zero, print 0
        } else {
            while (idx < diff.length) {
                System.out.print(diff[idx]);
                idx++;
            }
        }
    }
}