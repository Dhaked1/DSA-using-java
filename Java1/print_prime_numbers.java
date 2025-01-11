import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner san = new Scanner(System.in);
        int low = san.nextInt();
        int high = san.nextInt();

        for (int n = low; n <= high; n++) {
            if (n < 2) {
                continue; 
            }

            int count = 0;
            for (int div = 2; div * div <= n; div++) {
                if (n % div == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println(n);
            }
        }
    }
}