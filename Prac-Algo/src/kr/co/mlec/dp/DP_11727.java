package kr.co.mlec.dp;

import java.util.Scanner;

//문제명 2*N 타일링 2
public class DP_11727 {
	public static void main(String[] args) {
	int dp[] = new int[1001];
	Scanner sc = new Scanner(System.in);
	int num=sc.nextInt();
	//마지막에 올수있는거는 1*2, 2*1 *2 , 2*2 가 올수있음
	//dp[i]=i이 크기일때 채울수 있는 방법의 수
	dp[1]=1;
	dp[2]=3;
		for(int i=3;i<=num;i++) {
		dp[i]=dp[i-1]+dp[i-2]+dp[i-2];
		dp[i]=dp[i]%10007;
	}
		System.out.println(dp[num]);
}
}
