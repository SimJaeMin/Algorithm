package kr.co.mlec.dp;

import java.util.Scanner;
//D[N]�� ������ �ͳĵǳ� -> N�� 1�� ����� �ּ� Ƚ��
// N�� �ö󰡸鼭 ��� N�� 1�θ���� �ּ����Ǽ��� ����� DP[N]��
// N�� 1�� ����� �ּ����� ���� N�� 3���γ����ų� ,N�� 2�γ����ų� N���� 1�� �������� �ּҷ� ���°ſ� +1�� ���� ���� �ϳ�
//�ʱⰪ ���� : DP[1]= 0 , 1�� 1�� ����� �ּ�Ƚ���� 0��
// DP[I]�� �ٸ����� �����ֱ����� ���� ���ִ°Ŵ� �̰�  DP[N]= DP[N-1] +1 �� ������� N/2, N/3�� ���ؼ� �ּҰ� ã��
public class DP_1463_2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int x= sc.nextInt();
		int dp[] = new int[x+1];
		dp[1]=0;
		
		for(int i=2;i<=x;i++) {
			
			dp[i]=dp[i-1]+1;
			
			if(i%3==0 && dp[i/3]+1 <dp[i]) {
				dp[i]=dp[i/3]+1;
			}
			
			if(i%2==0 && dp[i/2]+1 < dp[i]) {
				dp[i]=dp[i/2]+1;
			}
		}
		System.out.println(dp[x]);
	}
}
