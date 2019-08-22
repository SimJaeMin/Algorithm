package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//������ 2*N Ÿ�ϸ�
public class DP_11726 {
	public static void main(String[] args) throws Exception {
		//1 *2, 2*1 �� ä��� 2*n�� 
		//�������� �ü��ִ°Ŵ� 1*2 2���� ���ų�, 2*1 �� �Ѱ��� �ü�����
		//�׷� �� �տ��� 1*2�� 2�� ���� 2*n-2�� Ÿ�ϸ��̵ǰ�
		//�������� ���ΰ� 1ĭ¥�������� �� ���� ���̰� n-1 �� �Ǵϱ� �ױ��̿�
		//�������� ���ΰ� 2ĭ¥�������� �� ���� ���̰� n-2 �� �Ǵϱ� �ΰ��� �����ָ�ȴ�.
		//2*1 �� 1���� ���� 2* n-1 Ÿ�ϸ��̵ȴ�.
		//dp[i] = n�� �� ä��� �ִ� ����Ǽ��� ������ȴ�
		//n �϶� ä��� ����� ���� �������� 1*2�� ���°ſ� 2*1�� 2�԰� ���°Ÿ� �����ָ�ȴ�.
		//dp[n]= dp[n-1]+dp[n-2]

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int dp[] = new int[1001];
		
		//for ���� ���� n�� ���� ������ �ϳ��� ���Ѵ��� �迭�� �����ϰ� �Ʒ����� ���� ������� ��� Ȱ���Ѵ�.
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=num;i++) {
			dp[i]=dp[i-1]+dp[i-2];
			dp[i]=dp[i]%10007;
		}
		System.out.println(dp[num]);
	}
}
