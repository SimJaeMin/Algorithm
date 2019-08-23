package kr.co.mlec.dp;
//������ : ���� �� �����ϴ� �κ� ����

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP_11722 {
	public static void main(String[] args) throws Exception {
		//���� �� �����ϴ� �κм����� ���� �� �����ϴ� �κм��� 
		//��� 1 : ���� �� �κ� ���� �����ϴ� �κм����� �ϰԵǸ� �����ϴ� �κм����̵ȴ�.
		//��� 2 : �Է¹��� ������ REVERSE�ϰ� �Ѵ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num= Integer.parseInt(br.readLine());
		int a[]= new int[num+1];
		int dp[] = new int[num+1];
		String s[]= br.readLine().split(" ");
		
		for(int i=1;i<=num;i++) {
			a[i]=Integer.parseInt(s[i-1]);
			dp[i]=1; //���� �� �����ϴ� �κм����� �ʱⰪ�� �ڱ� �ڽ� 1��
		}
		
		for(int i=num;i>=1;i--) {
			for(int j=num;j>i;j--) {
				if(a[i]>a[j]) {
					if(dp[i]<dp[j]+1){
						dp[i]=dp[j]+1;
					}
				}
			}
		}
		int max=dp[1];
		for(int i=2;i<=num;i++) {
			if(max<dp[i]) {
				max=dp[i];
			}
		}
		System.out.println(max);
		
		
		
		
	}
}
