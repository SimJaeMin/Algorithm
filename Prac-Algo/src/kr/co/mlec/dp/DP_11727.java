package kr.co.mlec.dp;

import java.util.Scanner;

//������ 2*N Ÿ�ϸ� 2
public class DP_11727 {
	public static void main(String[] args) {
	int dp[] = new int[1001];
	Scanner sc = new Scanner(System.in);
	int num=sc.nextInt();
	//�������� �ü��ִ°Ŵ� 1*2, 2*1 *2 , 2*2 �� �ü�����
	//dp[i]=i�� ũ���϶� ä��� �ִ� ����� ��
	dp[1]=1;
	dp[2]=3;
		for(int i=3;i<=num;i++) {
		dp[i]=dp[i-1]+dp[i-2]+dp[i-2];
		dp[i]=dp[i]%10007;
	}
		System.out.println(dp[num]);
}
}
