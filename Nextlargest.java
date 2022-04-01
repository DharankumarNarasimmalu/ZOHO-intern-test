package pack3;
import java.util.*;
public class Nextlargest {
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] arr=s.split("[,]");
		int numbers[]=new int [arr.length];
		for(int i=0;i<arr.length;i++) {
			numbers[i]=Integer.parseInt(arr[i]);
		}
		
		int k=0;
		
		while(k<arr.length) {
			int curr=numbers[k];
			List<Integer>e=new ArrayList<>();
			for(int i=k+1;i<arr.length;i++) {
				if( numbers[i]>curr) {
					e.add(numbers[i]);
				}
				
			}
			if (e.isEmpty()) {
				System.out.print("-1"+" ");
			}
			else {
				System.out.print(Collections.min(e)+" ");
			}
			k++;

		}
		
		
		
	}

}
