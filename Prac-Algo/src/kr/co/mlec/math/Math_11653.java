package kr.co.mlec.math;

import java.util.Scanner;

//문제명 : 소인수분해
public class Math_11653 {
	public static void main(String[] args) {
		//소인수 분해란 소수로 수의 곱을 표현하는것임
		//2부터 i*i 까지 하나의 수로 안나눠질때까지 계속 나누어준다..
		
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		for(int i=2;i*i<=num;i++) {
			
			while(num%i==0) {
				System.out.println(i);
				num=num/i;
			}
			
		}
		if(num>1) {
			System.out.println(num);
		}
	}
}
