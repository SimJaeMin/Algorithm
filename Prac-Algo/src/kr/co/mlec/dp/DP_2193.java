package kr.co.mlec.dp;

import java.util.Scanner;

// 문제명 : 이친수
public class DP_2193 {
	public static void main(String[] args) {
		//이친수는 0으로 시작하지 않고 1이 두번 연속으로 나오지 않는다.
		//그래서 n번째 문자가 1이면 n-1 은 0이여야되고
		//n번째 문자가 0이면 n-1 은 0이나 1이여야한다. 
		//dp[n][L] N자리 이친수인데 N번째 자리가 L 인 이친수의 개수
		//DP[N][L]=D[N][0]+D[N][1]
		//n자리 이친수인데 마지막수가 l인 이친수는 그 전자리가 0으로 끝나는 이친수와 1로 끝나는 이친수의 합으로 만들수있다.
		//DP[N][0]=D[N-1][0]+D[N-1][1]
		//DP[N][1]=D[N-1][0]
		//바텁업 방식으로 n 즉 자리수가 1일때부터 n일때까지를 하나씩 구해가면서 간다.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[][] = new long[91][2];
		long sum=0; // 마지막 자리가 0인경우 1인경우를 합치기 위해
		
		dp[1][0]=0;
		dp[1][1]=1;
		
		for(int i=2;i<=n;i++) {
			dp[i][0]=dp[i-1][0]+dp[i-1][1];
			//i번째인데 마지막수가 0이면 i-1에 0이올수있고 1이올수있으니 2개를 더해준다.
			dp[i][1]=dp[i-1][0];
			//i번째인데 마지막수가 1이면 i-1에 올수있는 수는 0만올수있다.
		}
		sum=dp[n][0]+dp[n][1];
		System.out.println(sum);
		
		
		
	}
}
