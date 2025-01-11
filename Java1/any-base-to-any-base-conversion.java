import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n= scn.nextInt();
		int b1 = scn.nextInt();
		int b2= scn.nextInt();
		int d = getValue(n,b1,b2);
		System.out.println(d);	
	}
	public static int getValue(int n,int b1,int b2)
	{ 
	int dec = getvalueIndecimal(n,b1);
	int dn = getvalueInbase(dec,b2);
	return dn;
	}
public static int getvalueIndecimal(int n,int b)
	{
		int dig = 0;
		int p = 1;
		while(n>0)
		{
			int rem = n%10;
			n = n/10;
			dig = rem*p+dig;
			p = p*b;
		}
		return dig;
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