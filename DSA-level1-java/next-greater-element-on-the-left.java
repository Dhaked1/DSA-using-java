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
        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr) {
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        nge[0] = -1;
        for (int i = 0; i<arr.length; i++) {
            while (st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }
            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return nge;
    }

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }
}