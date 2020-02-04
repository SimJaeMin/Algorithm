package kr.co.mlec.dp;

import java.util.Scanner;

public class DP_16194 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n= sc.nextInt();
		int data[] = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			data[i]=sc.nextInt();
		}
		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=data[1];
		for(int i=2;i<=n;i++) {
			dp[i]=data[i];
			for(int j=1;j<=i;j++) {
				dp[i]=Math.min(dp[i-j]+data[j], dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
}
