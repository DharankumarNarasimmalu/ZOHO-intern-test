package pack3;
import java.util.*;
public class Step{
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		int check=1;
		int start =sc.nextInt();
		int end=sc.nextInt();
		for(int i=start;i<=end;i++) {
			if (i<10) {
				System.out.println(i);
				continue;
			}
			int s=i;
			List<Integer>array=new ArrayList<Integer>();
			while(s>0) {
				array.add(s%10);
				s=s/10;
			}

			int b=array.get(0)-array.get(array.size()-1);
			int a=1;
			int k=array.size()-1;
			for(int j=0;j<k;j++) {
				int adj=array.get(j)-array.get(j+1);
				if (adj!=1 && adj!=-1) {
					a=0;
				}
			}
			if(a==1 && (b==1||b==-1)) {
				System.out.println(i);
				check=0;
			}
//			else {
//				check=
//			}
		}
		if(check==1) {
			System.out.println("NO");
		}
	}
}

