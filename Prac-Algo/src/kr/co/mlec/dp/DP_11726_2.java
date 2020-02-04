package kr.co.mlec.dp;

import java.util.Scanner;

public class DP_11726_2 {
	//DP[N] ���� ������ ���̰� N�� ���簢���� 1*2, 2*1 Ÿ�ϸ����� ��� ���� ����ä����ֳ�
	//�������� �ü��ִ°Ŵ� ���α��̱� 1 ���� ���̰� 2�� �� �ϳ��� ���ų�
	//���α��̰�2, ���α��̰� 2�ΰ� ���Ʒ��� ������ 
	//�׷��� ���α��̰� N�̸� �������� �ü��ִ°�� 2������ �����ϸ� �տ��� �Ȱ���, �װ��̿��ؼ� ���ָ��
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
