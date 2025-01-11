import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int temp = n;
		int nod = 0;
		while(temp>0)
		{
			temp = temp/10;
			nod++;
			}
	/*handeling special case when rotation is negative and when zero come at first place after rotation */	
		k = k%nod;
		if (k<0)
		{
			k = k+nod;
			}
		
		int div =1;
		int multi =1;
		for(int i = 1;i<=nod;i++)
		{
			if(i<=k)
			{
				div = div*10;
				}
				else
				{
					multi = multi*10;
					}
			}
		int q = n/div;
		int r = n%div;
		int rot = r*multi + q;
		System.out.println(rot);	
	}
}