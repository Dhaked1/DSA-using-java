import java.util.*;
import java.io.*;
/*span is defined as differnce of maximum value and minimum value*/
public class Main {
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [ ] arr = new int[n];
		for(int i = 0;i<arr.length;i++)
		{ 
		arr[i] = scn.nextInt();
		}
		int max = arr[0];
		int min = arr[0];
		for(int i = 0;i<arr.length;i++)
		{ 
		if  (arr[i]>max)
		{
			max = arr[i];
			  }
			  if(arr[i]<min)
			  {
			  	min = arr[i];
			  }
		}
		int span = max - min;
		System.out.println(span);
	}
}