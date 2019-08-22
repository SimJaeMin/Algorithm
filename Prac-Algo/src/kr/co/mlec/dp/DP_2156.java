package kr.co.mlec.dp;

import java.util.Scanner;

//������ :������ �ý�
public class DP_2156 {
	public static void main(String[] args) {
		//������ �ý��ϱ� �����ָ� �԰������ �������� �����ִ� 3���� ���Ǽ��� ����
		//�����ָ� ���Ǽ��� �ְ� �� ���� ���� �ִ�.
		//�׷��� ����� ���� �������� 0��°���� 1��°���� 2��°�� 3�� ������
		//DP[N][L] :N��° �ε� �������� ���� ���� L�϶� �� ���� �������� ��
		//DP[N][L] :0��°�� 1��° 2������ ���� �����ذ��鼭 �����Ÿ� �Ǵ��ذ���.
		//N��°�� 1�� �����̶�� �� ���� ���� ���� �� ���̴ٴ� ��� D[N-1][0]+���ݲ�
		//N��°�� 2�� �����̶�� �� ���� �������� 1�� �����̶�� ��� D[N-1][1]+���ݲ�
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		long p[]=new long[num+1];
		long dp[][] = new long [num+1][3];//0������ 1������ 2������
		
		for(int i=1;i<=num;i++) {
			p[i]=sc.nextLong();
		}
		
		for(int i=1;i<=num;i++) {
			dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][1], dp[i-1][2]));
			//i��° �� ���ݱ� 1�ܿ����̶�°Ŵ� �������� �ȸ��̰� ���ݲ��� ����
			dp[i][1]=dp[i-1][0]+p[i];
			//i��° �� ���ݱ� 2�ܿ����̶�� �Ŵ� �������� ���̰� ���ݲ��� ���Ŵٴ� ���
			dp[i][2]=dp[i-1][1]+p[i];
		}
		
		long max=Math.max(Math.max(dp[num][0],dp[num][1]), dp[num][2]);
		System.out.println(max);
		
	}
}
