package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//������ ��������
public class DP_11057 {
public static void main(String[] args) throws Exception{
	//���������� ���������� ������ ũ�ų� ���� ���ڰ� ���;��Ѵ�.
	//DP[N][L] N�ڸ� ���� ������ ���ڰ� [L]�� ���������� ����
	//DP[N][L] �� DP[N-1][0] ���� DP[N-1][L] ������ �� �����ָ�ȴ�.
	//�� ������ ���ʺ��� ũ�ų� �������� �;ߵǴϱ�
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n=Integer.parseInt(br.readLine());
	long dp[][];
	dp=new long[n+1][10]; //10�� ������ 0~9������ �������� �ü�����
						  //n+1 �� ���ִ� ������ 1�ڸ� ������ n�ڸ����� �̴ϱ�
	for(int i=0;i<=9;i++) {
		dp[1][i]=1; //���ڴ� 0���� �����Ҽ� �����ϱ� ���ڸ��ε� ���������� 0�ΰ͵� 1���� �������
	}
	
	for(int i=2;i<=n;i++) { // n�ڸ� ����������
		for(int j=0;j<=9;j++) { //�� �ڸ����� 0~9������ �ü��ְ�
			dp[i][j]=0;	
			for(int k=0;k<=j;k++) {	//dp[i][L]= dp[i-1][L���� �۰ų� ����������]
										//L �� j�� 0�̸� 0���� 5�� 5���� �Ҽ��ְ�
					dp[i][j]=dp[i][j]+dp[i-1][k];
					dp[i][j]=dp[i][j]%10007;
			}	
		}
	}
	long sum=0;
	for(int i=0;i<=9;i++) {
		sum=sum+dp[n][i];
		sum=sum%10007;
	}
	System.out.println(sum);
}
}
