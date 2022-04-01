package pack3;
import java.util.*;
public class Substring {
	int  check2(int l1,int l2,String s1,String s2) {
		char[]word1=s1.toCharArray();
		char[]word2=s2.toCharArray();
		StringBuilder sb=new StringBuilder();
		while(l1<s1.length() && l2<s2.length()){
			if(word1[l1]==word2[l2]) {
				sb.append(word1[l1]);
			}
			l1++;
			l2++;
		}
		if (sb.length()>=2) {
			System.out.println(sb);
			return 1;
		}
		else {
			return 0;
		}
	}
	int check (String str1,String str2) {
		int len1=str1.length();
		int len2=str2.length();
		int end = 0;
		boolean ch=false;
		char[]word1=str1.toCharArray();
		char[]word2=str2.toCharArray();
		for(int i=0;i<len1;i++) {
			for(int j=0;j<len2;j++) {
				if (word1[i]==word2[j] && i+1<word1.length && j+1<word2.length) {
					if(word1[i+1]==word2[j+1]) {
					end=end+check2(i,j,str1,str2);
					ch=true;}
				}
			}
			if(ch) {
				break;
			}
		}
		return end;
	}
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		String[] sent=name.split("[ ]");
		int res=0;
		Substring sub=new Substring();
		for(int i=0;i<sent.length;i++) {
			for(int j=i+1;j<sent.length;j++) {
				res=res+(sub.check(sent[i],sent[j]));
			}
		}
		if (res==0) {
			System.out.println("NO substring found");
		}
	}

}
