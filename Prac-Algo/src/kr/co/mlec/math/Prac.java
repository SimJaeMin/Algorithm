package kr.co.mlec.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Prac {
	public static void main(String args[]) throws Exception{
		//dp[n][k] ���� k ���� ���� ���� n �� �Ǵ� ����� ��
		
		
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long dp[][]= new long[201][201];
		
		for(int i=0;i<=n;i++) {
			dp[i][1]=1; //�ϳ��� ���ؼ� ���� i�� �ɼ��ִ� ���� �ڱ��ڽŻ��̶� 1��
		}
		
		//dp[i][k]= dp[i-l][k-1] ���� k-1���� ���ؼ�  , ������ ���ϴ� ���� l �̶�� i-l
		//k���� ���ؼ� i�� ����� �Ŵϱ� k-1���� �������� i-l�� ����� ���� �� �����ָ�ȴ�.
		for(int i=2;i<=k;i++) {
			for(int j=0;j<=n;j++) {
				for(int z=0;z<=j;z++) { //������ ���� j���� �����Ÿ� �ü�����
					//0~j���� �����Ÿ� �� �ѹ��� ���ذ��� ���� �� ��������ϴϱ�
					dp[j][i]+=dp[j-z][i-1];
					dp[j][i]=dp[j][i]%1000000000L;			
			}
		}
		}
		System.out.println(dp[n][k]);
	}
}
