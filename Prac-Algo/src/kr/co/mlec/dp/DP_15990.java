package kr.co.mlec.dp;

import java.util.Scanner;

public class DP_15990 {
	//dp[n] n을 1,2,3 더하기로 만들 수 있는 갯수
	//그런데 같은 수를 두번 이상 연속 사용할 수 없다.
	//그러면 마지막에 오는 숫자가 1이면 그전에 오는 숫자는 1을 제외한 2개
	//마지막에 오는 숫자가 2이면 그 전에 오는 숫자는 2를 제외한 2개
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int test= sc.nextInt();
		long dp[][]=new long[100001][4];// i를 만드는데 마지막수가 j인거
		
		
		dp[1][1]=1; // 1을 만드는데 마지막수가 1인거는 자기자신 하나
		dp[2][2]=1; // 2를 만드는데 마지막수가 2인거는 자기자신 하나, 2를 만드는데 끝이 1인거는 올수없음 그럼 2번연속이니까
		dp[3][3]=1;
		dp[3][1]=1;
		dp[3][2]=1;
		
		for(int i=0;i<test;i++) {
			
			int n= sc.nextInt();
			
			for(int j=4;j<=n;j++) {
				dp[j][1]=(dp[j-1][2]+dp[j-1][3])%1000000009; // j를 만들려고 하는데 마지막에 숫자 1을 더해줄려고한다.
				//그러면 바로 전에는 1이 올수없으니까 j-1인데 마지막수가 2인거와 3인거를 더해준다.
				dp[j][2]=(dp[j-2][1]+dp[j-2][3])%1000000009;
				dp[j][3]=(dp[j-3][1]+dp[j-3][2])%1000000009;
			}
		
			System.out.println((dp[n][1]+dp[n][2]+dp[n][3])%1000000009);
		}
	}
}
