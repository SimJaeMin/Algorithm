package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//������: ��ƼĿ
public class DP_9465 {
	public static void main(String[] args) throws Exception {
		//��ƼĿ�� �����ǵ� ���� �����Ƽ� �ϳ��� ������ �� �ֺ��� ��, �Ʒ�, �翷�� �������Ѵ�. 
		//�� ��ƼĿ���� ������ �ִµ� ���� ���� ������ ����� �;��Ѵ�.
		//�ִ밪�� ���ؾ��ϴϱ� ������ ��츦 ��� �����ϸ鼭������
		//������ ���� �ȴٴ� ���̾����ϱ� ���ʺ��� ��´ٰ� �����ϰ� �� ���ʿ��� 
		//������ �ϳ���°��, �Ʒ��� �ϳ���°��, �ȶ�� ��� �̷��� �ְ�
		//������ �ϳ� ��� ����  �� ������ �ȶ�ų� �Ʒ��� �ϳ� ���� �� �ְ�
		//�Ʒ��� �ϳ� ���  ���� �״����� �ȶ�ų� ������ �ϳ�
		//�ȶ��� ���� ��,�Ʒ�,�Ǿȶ�� �̷��� 3�߿� ������ �� �ִµ� 
		//�̷��� ���鼭 �ִ밪�� ��� �����س�����ȴ�.
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		int num;
		long p[][];
		long dp[][];
		for(int i=0;i<test;i++) {
			num=Integer.parseInt(br.readLine());
			p=new long[num+1][2];
			dp=new long[num+1][3];
			
			String s[]=br.readLine().split(" ");
			for(int a=1;a<=num;a++) {
				p[a][0]=Long.parseLong(s[a-1]);
			}
			
			s=br.readLine().split(" ");
			for(int a=1;a<=num;a++) {
				p[a][1]=Long.parseLong(s[a-1]);
			}
			
			for(int j=1;j<=num;j++) {
				//j��°���� �ϳ��� �ȶ����� ������ �Ʒ��� �ε� 2��°��� �����ϸ� 2��°�ٿ��� �ϳ��� �ȶ����Ŵ� ù��° �ٿ��� �� �ص��Ǵϱ� 3�� ���� ū��
				//2��° �ٿ��� �������� ��´ٸ� ù��°�ٿ��� �Ʒ����� �ȶ��ߵǴϱ� ���� ū�ſ� 2��°��  ������ ������ �����ְ�
				//2�����ٿ��� �Ʒ����� ��´ٸ� ù ��°�ٿ��� �������� �ȶ��ߵǴϱ� ���� ū�ſ� 2��°�� �Ʒ��� ������ �����ֱ�
				dp[j][0]=Math.max(dp[j-1][0],Math.max(dp[j-1][1], dp[j-1][2]));
				dp[j][1]=Math.max(dp[j-1][0],dp[j-1][2])+p[j][1];
				dp[j][2]=Math.max(dp[j-1][0], dp[j-1][1])+p[j][0];
			}
			//�׸��� �� �� ���� ū�� ���
			System.out.println(Math.max(dp[num][0], Math.max(dp[num][2],dp[num][1])));
		}
	
	}
}
