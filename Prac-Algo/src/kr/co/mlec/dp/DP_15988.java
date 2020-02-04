package kr.co.mlec.dp;

import java.util.Scanner;

public class DP_15988 {
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		int test = sc.nextInt();
		
		for(int i=0;i<test;i++) {
			int n = sc.nextInt();
			long dp[]=new long[1000001];
			
			
			dp[0]=0;
			dp[1]=1;
			dp[2]=2;
			dp[3]=4;
			
			if(n<4) {
				System.out.println(dp[n]);
				continue;
			}
			
			for(int j=4;j<=n;j++) {
				dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
				dp[j]=dp[j]%1000000009;
			}
			
			System.out.println(dp[n]);
			
		}
	}
}
