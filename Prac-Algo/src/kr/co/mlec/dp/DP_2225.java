package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//������ : �պ���
public class DP_2225 {
	public static void main(String[] args) throws Exception{
		//0���� N������ ���� K���� ���ؼ� �� ���� N�� �Ǵ� ����� ���� ���ϴ� ���α׷�
		//dp[k][n]= k���� ���ؼ� n�� ����� ����� ��
		//�������� �� �� �ִ� ���� 0 ���� n �� �ϳ� 
		//dp[k][n]= dp[K-1][n-L] �������� ���� ���� L�̶�� n-l �̰� ������ ���� �ϳ��� ���ϱ� k-1�� 
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String s[]= br.readLine().split(" ");
		int num=Integer.parseInt(s[0]);
		int k=Integer.parseInt(s[1]);
		
		long dp[][]=new long[k+1][num+1];
		
//		for(int i=0;i<=num;i++) {
//			dp[1][i]=1;
//		}
        dp[0][0] = 1;
		for(int i=1;i<=k;i++) {
			for(int j=0;j<=num;j++) {
				for(int z=0;z<=j;z++) {
					dp[i][j]+=dp[i-1][j-z]; //i ���� ���ڸ� ���� j�� ���� ���ִ°Ŵ�
					//i-1���� ����ؼ� j- ������ ��(z <=j) �� ����� ����� ���� �� �����ָ�ȴ�.
					dp[i][j]=dp[i][j]%1000000000L;
				}
			}
		}
		
		System.out.println(dp[k][num]);
	}
}
