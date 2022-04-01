package pack3;
import java.util.*;
public class Justification {
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		char[]sentence=line.toCharArray();
		String [] list=line.split(",");
		int count=sc.nextInt();
		int curr=0;
		int spaces=0;
		List<String>print=new ArrayList<String>();
		for(int i=0;i<list.length;i++) {
			int a=list[i].length();
			curr+=a;
			if (curr<=count) {
//				System.out.print(list[i]+" ");
				print.add(list[i]);
				curr++;
				spaces++;
				continue;
			}
			else {
				int mainlen=0;
				for(int j=0;j<print.size();j++) {
					String text=print.get(j);
					int len=text.length();
					if (j!=print.size()-1) {
						mainlen+=len+1;
					}
					else {
						mainlen+=len;
					}
//					System.out.print(print.get(j)+"   ");
				}
				int extraspace=count-mainlen;
				 if (spaces-1==0) {
					for(int h=0;h<print.size();h++) {
						System.out.print(print.get(h));
					}
				}
				 else if(extraspace==0) {
						for(int h=0;h<print.size();h++) {
							System.out.print(print.get(h)+" ");
						}
					}
				 else if(extraspace%(spaces-1)==0) {
					int k=extraspace/(spaces-1);
					for(int h=0;h<print.size();h++) {
						System.out.print(print.get(h)+" ".repeat(k));
					}
				}
				else if(extraspace==1){
					for(int h=0;h<print.size();h++) {
						System.out.print(print.get(h)+" ");
					}
				}
				else {
					int z=extraspace-(extraspace%(spaces-1));
					int k=z/(spaces-1);
					for(int h=0;h<print.size();h++) {
						System.out.print(print.get(h)+" ".repeat(k));
					}
				}
				
				
//				System.out.println(print);
				System.out.println();
				print.clear();
				spaces=0;
				curr=0;
			}
//			System.out.print(list[i]+" ");
			print.add(list[i]);
			curr+=a;
			curr++;
			spaces++;
		}
		for(int j=0;j<print.size();j++) {
			System.out.print(print.get(j)+"   ");
		}	
	}
	

}
