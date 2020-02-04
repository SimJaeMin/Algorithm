package kr.co.mlec.dp;

import java.util.Scanner;

public class DP_1309 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		
		long dp[][]=new long[n][3];
		//0 -> 이번행에 사자 x
		//1 -> 이번행에 사자 왼쪽
		//2 -> 이번행에 사자 오른쪽
		dp[0][0]=1;
		dp[0][1]=1;
		dp[0][2]=1;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<3;j++) {
				
				if(j==0) {
					dp[i][j]=(dp[i-1][1]+dp[i-1][2]+dp[i-1][0])%9901;
				}else if(j==1) {
					dp[i][j]=(dp[i-1][0]+dp[i-1][2])%9901;
				}else {
					dp[i][j]=(dp[i-1][0]+dp[i-1][1])%9901;
				}
			}
			
		}
		System.out.println((dp[n-1][0]+dp[n-1][1]+dp[n-1][2])%9901);
	}
}
