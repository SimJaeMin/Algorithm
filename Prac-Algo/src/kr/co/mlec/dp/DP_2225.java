package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//문제명 : 합분해
public class DP_2225 {
	public static void main(String[] args) throws Exception{
		//0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램
		//dp[k][n]= k개를 더해서 n을 만드는 경우의 수
		//마지막에 올 수 있는 경우는 0 부터 n 중 하나 
		//dp[k][n]= dp[K-1][n-L] 마지막에 오는 수가 L이라면 n-l 이고 마지막 숫자 하나를 빼니까 k-1개 
		
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
					dp[i][j]+=dp[i-1][j-z]; //i 개의 숫자를 더해 j를 만들 수있는거는
					//i-1개를 사용해서 j- 마지막 값(z <=j) 를 만드는 경우의 수를 다 더해주면된다.
					dp[i][j]=dp[i][j]%1000000000L;
				}
			}
		}
		
		System.out.println(dp[k][num]);
	}
}
