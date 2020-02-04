package kr.co.mlec.dp;

import java.util.Scanner;

public class DP_9095_2 {
	//DP[N]�� ��� ���� -> N�� 1,2,3�� ������ ��Ÿ���� �ִ� ����Ǽ�
	//�������� ��� �ü��ֳ� -> ���ϱ� 1, ���ϱ� 2, ���ϱ� 3
	//���ϱ� 1�̿��� �� �տ��� N-1 �̵ǰ� ���ϱ� 2�� ���� �� �� ���� N-2���ǰ� ���ϱ� 3�̿��� �ռ��� N-3�̵ȴ�
	//�� 3���� ����� ���� �� ���ľ� N�� 1,2,3 �� ������ ����� ���� ���´�.
	//�Է¹��� n���� ������ �ҷ����ϸ� �ʱⰪ �������� ���ϴ� ������ �������������� ��Ÿ�ӿ���������.
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
