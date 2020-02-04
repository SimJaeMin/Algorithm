package kr.co.mlec.dp;

import java.util.Scanner;

//문제명 파도반 수열 
public class DP_9461 {
	public static void main(String[] args) {
		//문제에 주어진 식을 보면 답을 구할 수 있음
		//3번째부터 공식이 성립된다.
		//N-3+N-2=N
		
		Scanner sc = new Scanner(System.in);
		int test=sc.nextInt();
		
		for(int i=0;i<test;i++) {
			int num=sc.nextInt();
			long dp[]=new long[101];
		
			dp[0]=0;
			dp[1]=1;
			dp[2]=1;
			dp[3]=1;
			dp[4]=2;
			dp[5]=2;
			dp[6]=3;
			dp[7]=4;
			dp[8]=5;
			dp[9]=7;
			dp[10]=9;
			for(int j=11;j<=100;j++) {
				dp[j]=dp[j-3]+dp[j-2];
				}
		System.out.println(dp[num]);
	}
	}
}
