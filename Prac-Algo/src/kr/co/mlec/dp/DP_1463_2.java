package kr.co.mlec.dp;

import java.util.Scanner;
//D[N]에 무엇이 와냐되냐 -> N을 1로 만드는 최소 횟수
// N이 올라가면서 계속 N을 1로만드는 최소한의수가 저장됨 DP[N]에
// N을 1로 만드는 최소한의 수는 N을 3으로나누거나 ,N을 2로나누거나 N에서 1을 뺀수에서 최소로 가는거에 +1을 해준 것중 하나
//초기값 지정 : DP[1]= 0 , 1을 1로 만드는 최소횟수는 0번
// DP[I]를 다른값과 비교해주기위해 먼저 해주는거는 이걸  DP[N]= DP[N-1] +1 로 기준잡고 N/2, N/3과 비교해서 최소값 찾기
public class DP_1463_2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int x= sc.nextInt();
		int dp[] = new int[x+1];
		dp[1]=0;
		
		for(int i=2;i<=x;i++) {
			
			dp[i]=dp[i-1]+1;
			
			if(i%3==0 && dp[i/3]+1 <dp[i]) {
				dp[i]=dp[i/3]+1;
			}
			
			if(i%2==0 && dp[i/2]+1 < dp[i]) {
				dp[i]=dp[i/2]+1;
			}
		}
		System.out.println(dp[x]);
	}
}
