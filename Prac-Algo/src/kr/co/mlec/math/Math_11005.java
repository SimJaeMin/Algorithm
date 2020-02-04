package kr.co.mlec.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//문제명 진법 변환 2
public class Math_11005 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		int b= sc.nextInt();
		StringBuilder sb=new StringBuilder();
		int a;
		
		while(num>0) {
			a=num%b;
			
			if(a<10) {
				sb.append((char)(a+'0'));
			}else {
				sb.append((char)(a+55));

			}
			num=num/b;
		}
		System.out.println(sb.reverse());
		
	}
}

