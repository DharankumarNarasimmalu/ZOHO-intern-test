package pack3;
import java.util.*;
public class Resverse {
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		while(N>0) {
			int a=N%10;
			N=N/10;
			System.out.print(a);
		}
	}
}
