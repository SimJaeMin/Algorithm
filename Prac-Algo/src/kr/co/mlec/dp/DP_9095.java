package kr.co.mlec.dp;

import java.util.Scanner;

//������ : 1,2,3 ���ϱ�
public class DP_9095 {
	public static void main(String[] args) {
		//�������� �� �� �ִ� ���� 1, 2, 3 �߿� �ϳ��̴� �̰�Ȱ���ϸ� 
		//�������� 1�̿��� N-1 �� 1,2,3 ���� ���� �� �ִ� ����Ǽ�
		//�������� 2������ N-2�� 1,2,3 ���� ���� �� �ִ� ����� ��
		//�������� 3�̿��� N-3�� 1,2,3 ���� ���� �� �ִ� ����� �� �� �������� �����ָ�ȴ�.
		//DP[I] �� I�� 1,2,3 �� ������ ���� �� �ִ� ����Ǽ�
		//DP[I]= DP[I-1] + DP[I-2] + DP[I-3]
		
		Scanner sc = new Scanner(System.in);
		int test= sc.nextInt();
		for( int i=0 ;i<test;i++) {
			int num=sc.nextInt();
			int dp[]=new int[12];
			dp[1]=1; //�ʱⰪ ���� 1 �ϳ��� ����
			dp[2]=2; // 1+1, 2, 
			dp[3]=4;// 1+1+1 , 1+2 2+1 3
			for(int j=4;j<=num;j++) {
				dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
			}
			System.out.println(dp[num]);
		}
	}
}
