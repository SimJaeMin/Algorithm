package kr.co.mlec.math;

import java.util.Scanner;

//문제명 : 소수 구하기 (애라토스테네스의 체)
public class Math_1929 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int first=sc.nextInt();
		int second=sc.nextInt();
		
		boolean p[]=new boolean[second+1];
		p[0]=p[1]=true;
		for(int i=2;i*i<=second;i++) { // 그 수 의 배수는 약수가 있는거니까 지운다.
			for(int j=2;i*j<=second;j++) { // 크기가 지정한것보다는 작게 , 배수가 1인것들은 상관 x
				p[i*j]=true;
			}
		}
		
		for(int i=first;i<=second;i++) {
			if(p[i]==false) System.out.println(i); //살아남은것들만 출력
		}
		
	}
}
