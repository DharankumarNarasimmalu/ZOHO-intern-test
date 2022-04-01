package pack3;

import java.util.Scanner;

class Subarray { 
    public static void main(String[] args)
    {

    	Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] arr1=s.split("[,]");
		int arr[]=new int [arr1.length];
		for(int i=0;i<arr1.length;i++) {
			arr[i]=Integer.parseInt(arr1[i]);
		}
        int n = arr.length;
        int sum = 0;
        int maxsize = 0, startindex = 0;
        int endindex = 0;
        for (int i = 0; i < n - 1; i++) {
        	if(arr[i]==0) {
        		sum=-1;
        	}
        	else {
        		sum+=1;
        	}
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == 0)
                    sum += -1;
                else
                    sum += 1;
                if (sum == 0 && maxsize < j - i) {
                    maxsize = j - i;
                    startindex = i;
                }
            }
        }
        endindex = startindex + maxsize;
        if (maxsize == 0)
            System.out.println("No such subarray");
        else
            System.out.println(startindex + " to " + endindex);
    }
}