import java.util.*;
public class Main {
	public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
		 int n = scn.nextInt();
		 int b= scn.nextInt();
		 int dn = getvalueIndecimal(n,b);
		 System.out.println(dn);
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
}