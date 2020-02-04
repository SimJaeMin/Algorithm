package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_14889 {
	static int data[][];
	static boolean check[];
	static int cho=0;
	static int cho1=0;
	static int min=-1;
	public static void go(int n, int index , int m , int len) {
		
		if(m==len) {
			
			for(int i = 0; i < n ;i++) {
				for(int j=0;j<n;j++) {
					if(check[i] && check[j]) {
						cho=cho+data[i][j];
					}else if(check[i]==false && check[j] == false) {
						cho1=cho1+data[i][j];
					}
				}
			}
			int sum= cho - cho1;
			if(sum<0) {
				sum= -1 * sum;
			}
			if(sum<min || min==-1) {
				min=sum;
			}
			cho=0;
			cho1=0;
			return;
		}
		
		if(len>m) {
			return;
		}
		if(index>=n) {
			return;
		}
		
		check[index]=true;
		go(n,index+1, m,len+1); // index 선수를 1 번팀에 포함하느냐
		check[index]=false;
		go(n,index+1,m,len); // index선수를 1 팀에 포함히지않느냐
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		data= new int[n][n];
		check= new boolean[n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				data[i][j]=sc.nextInt();
			}
		}
		
		go(n, 0, n/2,0);
		System.out.println(min);
	}
}
