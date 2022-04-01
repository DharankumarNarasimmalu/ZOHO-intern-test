package pack3;
import java.util.*;
public class Meal {
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		String list=sc.nextLine();
		String[] num=list.split(",");
		int []number=new int[num.length];
		for(int i=0;i<num.length;i++) {
			number[i]=Integer.parseInt(num[i]);
		}
		boolean check=true;
		for(int i=0;i<=num.length;i++) {
			if(i%2==0) {
				if(number[i+1]-number[i]>=8 || number[i+1]-number[i]<=3) {
					check=false;
					break;
				}
			}
			else {
				if( i==num.length-1) {
					break;
				}
				if(number[i+1]-number[i]<16) {
					check=false;
					break;
				}
			}
		}
		if(check) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		
		
	}

}
