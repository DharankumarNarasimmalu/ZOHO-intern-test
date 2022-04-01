package pack3;
import java.util.*;
public class Arrange {
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] arr=s.split("[,]");
		List<String>color=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			int index=color.indexOf(arr[i]);
			if(index==-1) {
				color.add(arr[i]);
			}
			else {
				continue;
			}
		}
		for(int i=0;i<color.size();i++) {
			int count=0;
			for(int j=0;j<arr.length;j++) {
				if (color.get(i).equals( arr[j])) {
					count++;
				}
			}
			System.out.print((color.get(i)+" ").repeat(count)+" ");
		}


	}

}
