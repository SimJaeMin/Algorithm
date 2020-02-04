package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_9095 {
	static int count=0;
	public static void go(int n, int sum) { // n 은 입력받은 수, sum 은 지금까지 더한 수
		
		if(sum==n) { // sum 이 n 이면
			count++; // n 을 만들수 있는 1,2,3 더하기가 있는거니까 하나 증가
			return;  // 여기서 그 함수는 끝
		}
		if(sum>n) { // sum이 커저버리면 의미없으니까 return 
			return;
		}
		go(n,sum+1); // 1,2,3 더하기니까 1,2,3 중 하나를 선택해야함, 1을 선택한경우
		go(n,sum+2); // 2를 선택
		go(n,sum+3); //3 을선택
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int n= sc.nextInt();
			
			go(n,0); 
			System.out.println(count);
			count=0;
		}
	}
}
