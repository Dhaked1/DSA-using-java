import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // Size of the array
        int[] a = new int[n]; // Array input
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        
        int[] nge = solve(a); // Array to store Next Greater Elements
        display(nge); // Display the result
    }
    
    public static int[] solve(int[] arr) {
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0); // Push the index of the first element onto the stack
        
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                int pos = st.pop();
                nge[pos] = arr[i];
            }
            st.push(i); // Push the current index onto the stack
        }
        
        while (st.size() > 0) {
            int pos = st.pop();
            nge[pos] = -1; // No greater element exists for these indices
        }
        return nge;
    }
    
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val).append("\n");
        }
        System.out.print(sb);
    }
}