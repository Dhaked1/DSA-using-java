import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int data  = scn.nextInt();
		int idx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (data == arr[i]) {
				idx = i;
				break;
			}
		}
		System.out.println(idx);
	}
}