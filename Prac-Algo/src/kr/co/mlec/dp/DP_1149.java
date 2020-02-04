package kr.co.mlec.dp;

import java.util.Scanner;

public class DP_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); 
		int data[][] = new int[n + 1][4];  //������ �Է�
		long dp[][] = new long[n + 1][4];  //i��° ���� 1=Red 2=Green 3=Blue �� ĥ���� ���� �ּҰ�
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 3; j++) {
				data[i][j] = sc.nextInt();
			}
		}

		dp[1][1] = data[1][1]; // ù��° ���� red��
		dp[1][2] = data[1][2]; // ù���� ���� blue��
		dp[1][3] = data[1][3]; // ù���� ���� green��

		for (int i = 2; i <= n; i++) { // 2��° ������ n��° ������
			for (int j = 1; j <= 3; j++) { // 2��° ���� RED, BLUE ,GREEN���� 3�� �ϳ��� �� ĥ�غ���
				if (j == 1) { //RED �� ĥ������ �� �� ���� BLUE�� GREEN���� ĥ�ߴ����� �����Ÿ�
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
		System.out.println(min); // ������ �� ���� �������� ������ش�.
	}
}
