package kr.co.mlec.math;

import java.util.Scanner;

//문제명 :  최소공배수
public class Math_1934 {
	static int gcd(int a, int b) {
		
		if(b==0) {
			return a;
		}else {
			return gcd(b,a%b);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int test=sc.nextInt();
		
		for(int i=0;i<test;i++) {
		int first=sc.nextInt();
		int second=sc.nextInt();
		
		
		int gcd1=gcd(first,second);	
		System.out.println(first*second/gcd1);
	}

	}
}
