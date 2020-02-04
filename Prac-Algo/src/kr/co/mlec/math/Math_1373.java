package kr.co.mlec.math;

import java.util.Scanner;

//문제명 2진수 8진수
public class Math_1373 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		String s= sc.next();
		int size=s.length();
		int cnt=0;
		int sum=0;
		for(int i=size-1;i>=0;i--) {
			char c=s.charAt(i);
			
			if(cnt%3==0) {
				sum=sum+c-'0';
				if(i==0) {
					sb.append(sum);
				}
			}else if(cnt%3==1) {
				sum=sum+ ( (c-'0')*2);
				if(i==0) {
					sb.append(sum);
				}
			}else {
				sum=sum+ ( (c-'0')*4);
				sb.append(sum);
				sum=0;
			}
			
			
			cnt++;
		}
		System.out.println(sb.reverse());
	}
}
