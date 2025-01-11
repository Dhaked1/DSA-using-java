import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt( );
		int k = scn.nextInt( );
		int temp = n;
		int nod = 0;// nod = number of digit
		while(temp >0){
			temp = temp/10;
			nod++;
			}
		int rem =0;
		int div = (int)Math.pow(10,k);
		rem = n%div;
		int p = nod - k;
		n = n/div;
		int d = (int)Math.pow(10,p);
		int rot_dig = 0;
		rot_dig = rem*d + n;	
			
		System.out.println(rot_dig);
	}
}