package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class DP_14002 {
	static int a[];
	static int data[];
	public static void go(int aa) {
		
		if(aa==0) {
			return;
		}
		go(a[aa]);
		System.out.print(data[aa]+ " ");
	}
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		data=new int[1001];
		
		int dp[]=new int[1001];
		a = new int[1001];
		//dp���� �� ������ ���� �� �����ϴ� �κм����� ����
		//�ʱⰪ�� ���� �ڱ� �ڽ��� ���� �� �����ϴ� ���ϼ��� ������ ��� 1
		
		
		//dp[i] �� dp[i] ���� ���� �� �κм����� ��
		//�׷��� �� ������ ������ ������������
		String s[] = br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			data[i]=Integer.parseInt(s[i-1]);
			dp[i]=1;
		}
		
		for(int i=1;i<=n;i++) { // 1���� n ����
			for(int j=1;j<i;j++) { // 1~2 , 1~3 , 1~4 �̷��� �ö󰡰�
				if(data[i]>data[j]) { // �׶� ex 4���� 1,2,3 ��°���� ���ؼ� 4���� �۰�
					if(dp[i]<dp[j]+1) { // �׶� ���� �� ������ ������
						dp[i]=dp[j]+1; // �ڱ��ڽ� + �������� ���� �� ������ ���� ���Ѱ� �ڱ��ڽ��̵ǰ�
						a[i]=j;//������ �������ߵǴϱ� �ڱ� �ڽ� ������ ������ �ε����� �����Ѵ�.
					}
				}
			}
		}
		int max=-2147000000;
		int max1=0;
		for(int i=1;i<=n;i++) {
			if(dp[i]>max) {
				max=dp[i];
				max1=i; // ���� ū �� �κ� ������ �������� ã�� a[������] �� �ϸ� �̰� ���� ������ �̰� 0�� ���ö�����
				//0 ���ö����� �ؾ��ϴ� ������ 0�� ���;� ���� ���°Ŵϱ�
			}
		}
		System.out.println(max);
		
		go(max1); // 
		System.out.println();
	}
}
