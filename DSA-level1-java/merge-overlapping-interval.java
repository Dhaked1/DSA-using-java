import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        
        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            arr[j][0] = Integer.parseInt(parts[0]);
            arr[j][1] = Integer.parseInt(parts[1]);
        }
        
        mergeoverlapping(arr);
    }

    public static void mergeoverlapping(int[][] arr) {
        pair[] pairs = new pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new pair(arr[i][0], arr[i][1]);
        }
        
        Arrays.sort(pairs);
        Stack<pair> st = new Stack<>();
        
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                st.push(pairs[i]);
            } else {
                pair top = st.peek();
                if (pairs[i].st > top.et) {
                    st.push(pairs[i]);
                } else {
                    st.pop();
                    st.push(new pair(top.st, Math.max(top.et, pairs[i].et)));
                }
            }
        }
        
        Stack<pair> rs = new Stack<>();
        while (!st.isEmpty()) {
            rs.push(st.pop());
        } 
        
        while (!rs.isEmpty()) {
            pair p = rs.pop();
            System.out.println(p.st + " " + p.et);
        }
    }

    public static class pair implements Comparable<pair> {
        int st;
        int et;
        
        pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(pair other) {
            return this.st - other.st; // Sorting by start time
        }
    }
}