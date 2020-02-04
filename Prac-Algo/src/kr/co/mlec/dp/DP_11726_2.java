package kr.co.mlec.dp;

import java.util.Scanner;

public class DP_11726_2 {
	//DP[N] 에는 가로의 길이가 N인 직사각형에 1*2, 2*1 타일링으로 몇개의 경우로 가득채울수있냐
	//마지막에 올수있는거는 가로길이기 1 세로 길이가 2인 거 하나가 오거나
	//가로길이가2, 세로길이가 2인게 위아래로 오던가 
	//그러면 가로길이가 N이면 마지막에 올수있는경우 2가지를 제외하면 앞에는 똑같음, 그걸이요해서 해주면됨
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int dp[] = new int[n+1];
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<=n;i++) {
			dp[i]=dp[i-1] + dp[i-2];
			dp[i]=dp[i]%10007;
		}
		
		System.out.println(dp[n]);
	}
}
