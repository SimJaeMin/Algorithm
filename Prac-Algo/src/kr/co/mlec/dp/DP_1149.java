package kr.co.mlec.dp;

import java.util.Scanner;

public class DP_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); 
		int data[][] = new int[n + 1][4];  //데이터 입력
		long dp[][] = new long[n + 1][4];  //i번째 집을 1=Red 2=Green 3=Blue 로 칠했을 때의 최소값
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 3; j++) {
				data[i][j] = sc.nextInt();
			}
		}

		dp[1][1] = data[1][1]; // 첫번째 집을 red로
		dp[1][2] = data[1][2]; // 첫번쨰 집을 blue로
		dp[1][3] = data[1][3]; // 첫번쨰 집을 green로

		for (int i = 2; i <= n; i++) { // 2번째 집부터 n번째 집까지
			for (int j = 1; j <= 3; j++) { // 2번째 집을 RED, BLUE ,GREEN으로 3번 하나씩 다 칠해본다
				if (j == 1) { //RED 로 칠했으면 그 전 집을 BLUE나 GREEN으로 칠했던거중 작은거를
					dp[i][j] = Math.min(dp[i - 1][2] + data[i][j], dp[i - 1][3] + data[i][j]);
				}else if(j==2) {
					dp[i][j] = Math.min(dp[i - 1][1] + data[i][j], dp[i - 1][3] + data[i][j]);
				}else {
					dp[i][j] = Math.min(dp[i - 1][1] + data[i][j], dp[i - 1][2] + data[i][j]);
				}
			}
		}
		long min=dp[n][1];
		min=Math.min(min, Math.min(dp[n][2], dp[n][3]));
		System.out.println(min); // 마지막 중 가장 작은값을 출력해준다.
	}
}
