package kr.co.mlec.dp;
//������ : ���� ū ���� �κ� ����

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP_11055 {
	public static void main(String[] args) throws Exception{
		//���� ū ���� �κ� �����̶� ���� �κ� ���� �߿��� ���� ���� ū ���� ���ϴ� ���α׷��̴�.
		//�����ϴ� �κ� ������ ������ �ִµ� ���� �κ� �������� ��ü ���� ���� ū���� ����ؾ��Ѵ�.
		//dp[i]= a[i] �� ������ �����ϴ� �κ� ������ ��
		//dp[i]�� 2���� ������ ���� j < i �� Ŀ�� �ϰ� ( �κ� ������ �ڿ� �־���ϴϱ�)
		//a[j] < a[i] ���� �Ѵ�. �׷��� �����ϴ� �κ� ������ �ϼ��ȴ�.
		//�����ϴ� �κ� ������ ���̴� �ʱⰪ�� ��� �ڱ��ڽ� �ϳ� ���� 1�̿����� ���⼭�� �ڱ��ڽ��� ���̴�.
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int num=Integer.parseInt(br.readLine());
		int dp[] = new int[num+1];
		int a[] = new int[num+1];
		String s[] = br.readLine().split(" ");
		
		for(int i=1;i<=num;i++) {
			a[i]=Integer.parseInt(s[i-1]);
			dp[i]=a[i];
		}
		
		for(int i=1;i<=num;i++) {
			for(int j=1;j<i;j++) { //i��° �������� ����
				if(a[j]<a[i]) {
					if(dp[i]<dp[j]+a[i]) {
					dp[i]=dp[j]+a[i]; //���ӵ� ���������� 1�� �������� ���̴ϰ� �ڱ��ڽ��� �����ش�.
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
