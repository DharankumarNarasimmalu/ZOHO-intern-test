package pack3;
import java.util.*;
public class Matrix {
	static boolean check(int mat[][],int row,int col) {
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(j!=col-1 && mat[i][j]==mat[i][j+1] && mat[i][j]!=0) {
					return true;
				}
			}
		}
		return false;
		
	}
	static boolean check2(int mat[][],int row,int col) {
		for(int j=0;j<col;j++) {
			for(int i=0;i<row;i++) {
				if(i!=row-1 && mat[i][j]==mat[i+1][j] && mat[i][j]!=0) {
					return true;
				}
			}
		}
		return false;
		
	}
	int [][]moveup(int matrix[][],int row,int col){
		for(int j=0;j<col;j++) {
			for(int i=0;i<row;i++) {
				if(i!=row-1 && matrix[i][j]==0) {
					for(int k=i+1;k<row;k++) {
						if(matrix[k][j]!=0) {
							int temp=matrix[i][j];
							matrix[i][j]=matrix[k][j];
							matrix[k][j]=temp;
							break;
						}
					}
				}
			}
		}
			boolean flag=true;
			while(flag) {
			for(int j=0;j<col;j++) {
				for(int i=0;i<row;i++) {
					if (i!=row-1 && (matrix[i][j]==matrix[i+1][j] || matrix[i][j]==0)) {
						matrix[i][j]+=matrix[i+1][j];
						matrix[i+1][j]=0;
					}
				}
			}
			flag=check2(matrix,row,col);
			}
		return matrix;
	}
	int [][]movedown(int matrix[][],int row,int col){
		for(int j=0;j<col;j++) {
			for(int i=row-1;i>0;i--) {
				if(matrix[i][j]==0) {
					for(int k=i-1;k>=0;k--) {
						if(matrix[k][j]!=0) {
							int temp=matrix[i][j];
							matrix[i][j]=matrix[k][j];
							matrix[k][j]=temp;
							break;
						}
					}
				}
			}
		}
			boolean flag=true;
			while(flag) {
			for(int j=0;j<col;j++) {
				for(int i=row-1;i>0;i--) {
					if ((matrix[i][j]==matrix[i-1][j] || matrix[i][j]==0)) {
						matrix[i][j]+=matrix[i-1][j];
						matrix[i-1][j]=0;
					}
				}
			}
			flag=check2(matrix,row,col);
			}
		return matrix;
	}
	int [][]moveleft(int matrix[][],int row,int col) {
		for(int i=0;i<row;i++) {
		for(int j=0;j<col;j++) {
			if(j!=col-1 && matrix[i][j]==0) {
				for(int k=j+1;k<col;k++) {
					if(matrix[i][k]!=0) {
						int temp=matrix[i][j];
						matrix[i][j]=matrix[i][k];
						matrix[i][k]=temp;
						break;
					}
				}
			}
		}
	}
	// adding adjecent element
	boolean flag=true;
	while(flag) {
	for(int i=0;i<row;i++) {
		for(int j=0;j<col;j++) {
			if (j!=col-1 && (matrix[i][j]==matrix[i][j+1] || matrix[i][j]==0)) {
				matrix[i][j]+=matrix[i][j+1];
				matrix[i][j+1]=0;
			}
		}
	}
	flag=check(matrix,row,col);
	}
	return matrix;
    }
	int [][]moveRight(int matrix[][],int row,int col){
		for(int i=0;i<row;i++) {
		for(int j=col-1;j>0;j--) {
			if(matrix[i][j]==0) {
				for(int k=j-1;k>=0;k--) {
					if(matrix[i][k]!=0) {
						int temp=matrix[i][j];
						matrix[i][j]=matrix[i][k];
						matrix[i][k]=temp;
						break;
					}
				}
			}
			
		}
	}
	//adding adj element
	boolean flag=true;
	while(flag) {
	for(int i=0;i<row;i++) {
		for(int j=col-1;j>0;j--) {
			if ((matrix[i][j]==matrix[i][j-1] || matrix[i][j]==0)) {
				matrix[i][j]+=matrix[i][j-1];
				matrix[i][j-1]=0;
			}
		}
	}
	flag=check(matrix,row,col);
	}
		
		return matrix;
	}
		
	
	public static void main(String... args) {
		Scanner sc=new Scanner(System.in);
		int row=sc.nextInt();
		int col=sc.nextInt();
		int matrix[][]=new int [row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
//		String commend=sc.nextLine();
		sc.nextLine();
		while(true){
		String commend=sc.nextLine();
		Matrix m=new Matrix();
		if(commend.equals("moveleft")) {
//		// move left
 		matrix=m.moveleft(matrix, row, col);}
		if(commend.equals("insert")) {
//		//insert element
		int insert=sc.nextInt();
		int r=sc.nextInt();
		int c=sc.nextInt();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(i==r && j==c) {
					matrix[i][j]=insert;
				}
			}
		}}
		if(commend.equals("moveright")){
		//move right
		matrix=m.moveRight(matrix,row,col);}
		if(commend.equals("moveup")) {
		//move up
		matrix=m.moveup(matrix, row, col);}
		if (commend.equals("movedown")) {
		//move down
		matrix=m.movedown(matrix, row, col);}
		if(commend.equals("final")) {
			break;
		}
		//printing of element
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}}
