package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_14889_2 {
	static int data[][];
	static boolean a[];
	static int min=-1;
	public static void go(int n , int len,int index) {
		
		if(len == n/2 ) {
			int sum=0;
			int sum1=0;
			for(int i=0;i< n ;i++) {
				for(int j=0;j<n;j++) {
					if(a[i] == true && a[j] == true) {
						sum=sum+ data[i][j];
					}else if(a[i]==false && a[j]==false) {
						sum1=sum1+data[i][j];
					}
				}
			}
			sum= sum- sum1;
			if(sum<0) {
				sum= sum * -1;
			}
			
			if(min==-1 || sum<min) {
				min=sum;
			}
			return;
		}
		
		if(index>=n) {
			return;
		}
		
		a[index]=true;
		go(n,len+1,index+1);
		a[index]=false;
		go(n,len,index+1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		data = new int[n][n];
		a= new boolean[n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				data[i][j]=sc.nextInt();
			}
		}
		
		go(n,0,0);
		System.out.println(min);
	}
}
