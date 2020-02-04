package kr.co.mlec.bf;

import java.util.Scanner;
//for(int ii=1;ii<=m;ii++) {
//for(int jj=1;jj<=n;jj++) {
//	System.out.print(dp[ii][jj] + " ");
//}
//System.out.println();
//}
public class BF_2758 {

	static long dp[][]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int i=0;i<test;i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			dp=new long[2001][11]; //���������� i���� �۰� , ���� ������ j�ΰ�
			
			for(int a=1;a<=m;a++) {
				dp[a][1]=1; //������ ���� a�̰�  ���� ������ 1���ΰ��� ��� �� 1��
			}
			
			for(int a=1;a<=m;a++) {     //���������� a���� �۰�
				for(int b=2;b<=n;b++) { //������ ������ b�ΰ� 	
										//�� ���� ������ ���� a/2 �̺��� �����Ű� ���ڰ� b-1���ΰ�
										//���������� �� ������ 2�� �̻� Ŀ�ߵǰ� ������ ���� ���ݺ��� 1�� �����ŵ��� ��
					for(int k=1;k<=a/2;k++) {//������ �� A�� �������� 2�� Ŀ�ߵǳ��� A/2����
						dp[a][b]=dp[a][b]+dp[k][b-1];
					}
				}
			}
			
			long sum=0;
			for(int c=1;c<=m;c++) {
				sum=sum+dp[c][n];
			}
			//�����ִ� ������ ������ ���ڰ� m���� �۰� �����Ǽ��� n���ΰŴ�
			//������ ���ڰ� 1~ m �ΰ��� ���̴ϱ�

			System.out.println(sum);
	}
}
}