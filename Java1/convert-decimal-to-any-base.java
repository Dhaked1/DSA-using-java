import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int d = scn.nextInt();
		int dn = getvalueInbase(n,d);
		System.out.println(dn);
	}
	
	public static int getvalueInbase(int n, int b)
	{
		int dig =0;
		int rem = 0;
		int p = 1;
		while(n>0){ 
		rem = n%b;
		n = n/b;
		dig = rem*p+dig;
		p = p*10;
		}
		return dig;
	}
}