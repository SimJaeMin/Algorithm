package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_1182 {
	static int data[];
	static int a[];
	static int count=0;
	static int sum=0;
	static boolean check[];
	public static void go(int n,int len,int s,int s1,int s2) {
		
		if(len==n) {
			if(s1==s && s2!=n) {
				count++;
			}
		
			return;
		}
		
		go(n,len+1,s,data[len]+s1,s2); //부분수열을 만들때 len 번째 데이터를 포함하느냐
		go(n,len+1,s,s1,s2+1); // 포함 안하느냐 
		//포함해도 안해도 len은 올라가섬 n이 될때 입력값 s와 비교, s2는 아무것도 포함안하면 0이되는걸 방지하기위해
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int s = sc.nextInt();
		data= new int[n];
		a= new int[n];
		check=new boolean[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		
		go(n,0,s,0,0);
		
	
		System.out.println(count);
	}
}
