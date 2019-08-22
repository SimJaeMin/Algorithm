package kr.co.mlec.dp;

import java.util.Scanner;

//문제명 :포도주 시식
public class DP_2156 {
	public static void main(String[] args) {
		//포도주 시식하기 포도주를 먹고싶은데 연속으로 놓여있는 3잔을 마실수는 없다
		//포도주를 마실수도 있고 안 마실 수도 있다.
		//그러면 경우의 수는 연속으로 0번째던가 1번째던가 2번째인 3개 가있음
		//DP[N][L] :N번째 인데 연속으로 마신 수가 L일때 총 마신 포도주의 양
		//DP[N][L] :0번째랑 1번째 2번쨰를 각각 저장해가면서 다음거를 판단해간다.
		//N번째가 1번 연속이라면 이 말은 이전 꺼는 안 마셨다는 얘기 D[N-1][0]+지금꺼
		//N번째가 2번 연속이라면 이 말은 이전꺼는 1잔 연속이라는 얘기 D[N-1][1]+지금꺼
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		long p[]=new long[num+1];
		long dp[][] = new long [num+1][3];//0번연속 1번연속 2번연속
		
		for(int i=1;i<=num;i++) {
			p[i]=sc.nextLong();
		}
		
		for(int i=1;i<=num;i++) {
			dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][1], dp[i-1][2]));
			//i번째 즉 지금깨 1잔연속이라는거는 이전꺼는 안마셨고 지금꺼는 마심
			dp[i][1]=dp[i-1][0]+p[i];
			//i번째 즉 지금깨 2잔연속이라는 거는 이전꺼는 마셨고 지금꺼도 마신다는 얘기
			dp[i][2]=dp[i-1][1]+p[i];
		}
		
		long max=Math.max(Math.max(dp[num][0],dp[num][1]), dp[num][2]);
		System.out.println(max);
		
	}
}
