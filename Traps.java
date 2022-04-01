package pack3;
import java.util.*;
public class Traps {
	static int sum(int num) {
		int s=0;
		while(num>0) {
			s+=num%10;
			num=num/10;
		}
		return s;
	}
	public static void main(String...args) {
		Scanner sc= new Scanner(System.in);
		int N1=sc.nextInt();
		int N2=sc.nextInt();
		int y=sc.nextInt();
		List<Integer>result=new ArrayList<>();
		if(N1>N2) {
			System.out.println("NONE");
			return;
		}
		for(int i=N1;i<=N2;i++) {
			if(y<3) {
				y=3;
			}
			int curr=i;
			int flag=0;
			if(curr<10) {
				if(curr%y==0 || y%curr==0) {
					result.add(i);
					y+=2;
			     }
				else {
					y-=1;
				}
			}
			else {
			while(curr>=10) {
			if(curr%y==0 || y%curr==0) {
				result.add(i);
				flag=1;
				y+=2;
			}
			else {
				curr=sum(curr);
//				System.out.print(i+"|");
//				System.out.print(curr+" "+y+"|||");
				if(curr<10) {
					if(curr%y==0||y%curr==0) {
						result.add(i);
						y+=2;
						flag=1;
					}
				}
			}	
			}
			if( flag==0) {
				y-=1;
			}
		}}
		System.out.println(result);
		
	}

}
