package kr.co.mlec.dp;

import java.util.Scanner;

public class DP_9095_2 {
	//DP[N]에 어떤게 들어가냐 -> N을 1,2,3의 합으로 나타낼수 있는 경우의수
	//마지막에 어떤게 올수있냐 -> 더하기 1, 더하기 2, 더하기 3
	//더하기 1이오면 그 앞에는 N-1 이되고 더하기 2가 오면 그 앞 수는 N-2가되고 더하기 3이오면 앞수는 N-3이된다
	//그 3개의 경우의 수를 다 합쳐야 N을 1,2,3 의 합으로 만드는 수가 나온다.
	//입력받은 n으로 생성을 할려고하면 초기값 정리에서 정하는 수보다 작은수가나오면 런타임에러가난다.
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int test=sc.nextInt();
		
		for(int i=0;i<test;i++) {
			int n=sc.nextInt();
			long dp[] = new long[12];
			
			dp[1]=1;
			
			dp[2]=2;
			dp[3]=4;
			
			for(int a=4;a<=n;a++) {
				dp[a]=dp[a-1]+dp[a-2]+dp[a-3];
			}
			
			System.out.println(dp[n]);
		}
	}
}
