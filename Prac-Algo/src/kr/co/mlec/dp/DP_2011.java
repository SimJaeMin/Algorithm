package kr.co.mlec.dp;

import java.util.Scanner;

//������ :  ��ȣ�ڵ�
public class DP_2011 {
	public static void main(String[] args) {
		//��ȣ�� �־����� ���ü� �ִ� �ؼ��� ���� ���ϴ� ����
		//A�� 1 B��2... Z�� 26���� ��ȯ�Ǵ°���
		//DP[I]�� I��° ���ڱ��� �ؼ������� ���� �� �ִ� �ؼ��� ������ 
		Scanner sc = new Scanner(System.in);
		String s =sc.nextLine();
		int num=s.length();
		s=" "+ s; //���ڿ��� 1���� �����ϱ����ؼ�
		long dp[] = new long[num+1];
		
		dp[0]=1;
		
		for(int i=1;i<=num;i++) {
			int x=s.charAt(i)-'0'; //ù���� ���ڸ� �о �װ� 1~9 ���̸�
			if(x>=1 && x<=9) { 
				dp[i]=dp[i-1]+dp[i]; 
				dp[i]=dp[i]%1000000;
			}
			if(i==1) {
				continue;
			}
			x=(s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
			if(x>=10 && x<=26) {
				dp[i]=dp[i]+dp[i-2];
				dp[i]%=1000000;
			}
		}
		System.out.println(dp[num]);
	
	
	}
}
