package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//������ ������ 
public class DP_1912 {
	public static void main(String[] args) throws Exception{
		//n ���� ������ �̷���� ������ �־����� �� �� ���ӵ� �� ���� ���� �����ؼ� ���� �� �ִ� ���� ���� ū�ո� ���ؾ��Ѵ�.
		//���ӵ� ����� ���� �߿��ϴ�.
		//dp[i] �� i�� ° ���� ���ӵ� ���� ���� ���� ū ���� ���� 
		//dp[i] = dp[i-1]+a[i] �̰ų� a[i] 2�� ū ���� �����ϸ�ȴ�.
		//���ӵ� ���ϱ� dp�� �ü� �ִ� ���� �տ��� �ڱⲬ ���� �Ͱ�, �ڱⰡ ���Ӱ� ������ ��� ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int a[]=new int[num+1];
		int dp[]=new int[num+1];
		
		String s[] = br.readLine().split(" ");
		
		for(int i=1;i<=num;i++) {
			a[i]=Integer.parseInt(s[i-1]);
			dp[i]=a[i]; // �ڱ� �ڽ��� ������ �Ǵϰ�
		}
		
		for(int i=1;i<=num;i++) {
			dp[i]=Math.max(dp[i-1]+a[i], a[i]); //���ӵ� ���ϱ� �ڱ��ڽŰ�, �������� �ڱ��ڽ��� ���Ѱ��� ū��
		}
		int max=dp[1];
		for(int i=2;i<=num;i++) { //���� ���� ū���� ã����ȴ�.
			if(max<dp[i]) {
				max=dp[i];
			}
		}
		System.out.println(max);
		
		
	}
}
