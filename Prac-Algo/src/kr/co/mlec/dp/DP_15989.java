package kr.co.mlec.dp;

import java.util.Scanner;


public class DP_15989 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int test=sc.nextInt();
		for(int i=0;i<test;i++) {
			int n=sc.nextInt();
			int dp[]= new int[10001];
			dp[0]=1;
			for(int a=1;a<=3;a++) {
				for(int b=1;b<=n;b++) {
					if(b-a>=0) {
						dp[b]=dp[b]+dp[b-a];
					}
				}
			}
			System.out.println(dp[n]);
		}
}
}