import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int b  = scn.nextInt();
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		int d = getsum(b, n1 ,n2);
		System.out.println(d);
	}
	public static int getsum(int b, int n1, int n2)
	{
		int rem = 0;
		int p = 1;
		int c = 0;
		int dig = 0;
		while(n1>0 || n2>0 || c>0)
		{
			int r1= n1%10;
			int r2 = n2%10;
			n1= n1/10;
			n2 = n2/10;
			int s = r1+r2+c;
			c = s/b;
			rem = s%b;
			dig = p*rem + dig ;
			p = p*10;	
		}
		return dig;
	}
}