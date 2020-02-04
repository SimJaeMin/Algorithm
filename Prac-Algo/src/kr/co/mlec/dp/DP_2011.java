package kr.co.mlec.dp;

import java.util.Scanner;

//문제명 :  암호코드
public class DP_2011 {
	public static void main(String[] args) {
		//암호가 주어지면 나올수 있는 해석의 수를 구하는 문제
		//A가 1 B가2... Z가 26으로 변환되는거임
		//DP[I]는 I번째 문자까지 해석했을때 나올 수 있는 해석의 가짓수 
		Scanner sc = new Scanner(System.in);
		String s =sc.nextLine();
		int num=s.length();
		s=" "+ s; //문자열을 1부터 시작하기위해서
		long dp[] = new long[num+1];
		
		dp[0]=1;
		
		for(int i=1;i<=num;i++) {
			int x=s.charAt(i)-'0'; //첫번쨰 문자를 읽어서 그게 1~9 사이면
			if(x>=1 && x<=9) { 
				dp[i]=dp[i-1]+dp[i]; 
				dp[i]=dp[i]%1000000;
			}
			if(i==1) {
				continue;
			}
			x=(s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
			if(x>=10 && x<=26) {
				dp[i]=dp[i]+dp[i-2];
				dp[i]%=1000000;
			}
		}
		System.out.println(dp[num]);
	
	
	}
}
