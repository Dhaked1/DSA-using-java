import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // Read the size of the array
        int[] a = new int[n];
        String[] inputs = br.readLine().split(" "); // Read space-separated integers
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(inputs[i]); // Parse each integer
        }
        int[] nse = solve(a);
        display(nse);
    }

    public static int[] solve(int[] arr) {
        int[] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length - 1]);
        nse[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= st.peek()) {
                st.pop();
            }
            if (st.size() == 0) {
                nse[i] = -1;
            } else {
                nse[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return nse;
    }

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }
}