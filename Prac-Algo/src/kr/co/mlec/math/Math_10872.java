package kr.co.mlec.math;

import java.util.Scanner;

// ������ : ���丮��
public class Math_10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int fac=1;
		for(int i=1;i<=num;i++) {
			fac=fac*i;
		}
		System.out.println(fac);
	}
}
