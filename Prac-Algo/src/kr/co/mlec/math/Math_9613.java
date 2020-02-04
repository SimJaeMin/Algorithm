package kr.co.mlec.math;

import java.util.Scanner;

//문제명 :GCD 합
public class Math_9613 {
	public static int gcd(int a , int b) {
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int test=sc.nextInt();
		
		for(int i=0;i<test;i++) {
			int num=sc.nextInt();
			int arr[]=new int [num];
			for(int j=0;j<num;j++) {
				arr[j]=sc.nextInt();	
			}
			long sum=0;
			for(int a=0;a<num-1;a++) {
				for(int b=a+1;b<num;b++) {
					sum=sum+gcd(arr[a],arr[b]);
				}
			}
			
			System.out.println(sum);
		}
	}
}
