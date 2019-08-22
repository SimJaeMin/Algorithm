package kr.co.mlec.dp;

import java.util.Scanner;

//문제명 : 1,2,3 더하기
public class DP_9095 {
	public static void main(String[] args) {
		//마지막에 올 수 있는 수는 1, 2, 3 중에 하나이다 이걸활용하면 
		//마지막에 1이오면 N-1 을 1,2,3 으로 만들 수 있는 경우의수
		//마지막에 2가오면 N-2를 1,2,3 으로 만들 수 있는 경우의 수
		//마지막에 3이오면 N-3을 1,2,3 으로 만들 수 있는 경우의 수 이 세가지를 더해주면된다.
		//DP[I] 는 I를 1,2,3 의 합으로 만들 수 있는 경우의수
		//DP[I]= DP[I-1] + DP[I-2] + DP[I-3]
		
		Scanner sc = new Scanner(System.in);
		int test= sc.nextInt();
		for( int i=0 ;i<test;i++) {
			int num=sc.nextInt();
			int dp[]=new int[12];
			dp[1]=1; //초기값 설정 1 하나로 가능
			dp[2]=2; // 1+1, 2, 
			dp[3]=4;// 1+1+1 , 1+2 2+1 3
			for(int j=4;j<=num;j++) {
				dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
			}
			System.out.println(dp[num]);
		}
	}
}
