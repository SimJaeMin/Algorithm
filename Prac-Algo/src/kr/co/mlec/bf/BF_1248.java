package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BF_1248 {
	static char ch[][];
	static int a[];
	
	public static boolean check(int n) {
		
		for(int i=0;i<=n;i++) {
			int sum=0;
			for(int j=i;j<=n;j++) {
				sum=sum+a[j];
				char x=ch[i][j];
				
				if(x=='-') {
					if(sum<0) {
						continue;
					}else {
						return false;
					}	
				}else if(x=='+') {
					if(sum>0) {
						continue;
					}else {
						return false;
					}
				}else {
					if(sum==0) {
						continue;
					}else {
						return false;
					}
				}
				
			}
		}
		return true;
	}
	
	public static void go(int n, int index,int len) {
		if(n==len) {
			for(int i=0;i<n;i++) {
				System.out.print(a[i] + " ");
			}
			System.exit(0);
		}
		
		if(ch[index][index]=='-') {
			for(int i=-10;i<0;i++) {
				a[len]=i;
				if(check(index)) {
					go(n,index+1,len+1);
				}
			}
		}else if(ch[index][index]=='+') {
			for(int i=1;i<=10;i++) {
				a[len]=i;
				if(check(index)) {
					go(n,index+1,len+1);
				}
			}
		}else {
			a[len]=0;
			if(check(index)) {
				go(n,index+1,len+1);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n];
		ch=new char[n][n];
		String s= sc.next();
		int a=0;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				ch[i][j]=s.charAt(a);
				a++;
			}
		}
		
		go(n,0,0);
	}
}
