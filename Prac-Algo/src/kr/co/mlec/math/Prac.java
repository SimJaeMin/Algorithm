package kr.co.mlec.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Prac {
	public static void main(String args[]) throws Exception{
		//dp[n][k] 정수 k 개를 더해 합이 n 이 되는 경우의 수
		
		
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long dp[][]= new long[201][201];
		
		for(int i=0;i<=n;i++) {
			dp[i][1]=1; //하나를 더해서 정수 i가 될수있는 경우는 자기자신뿐이라 1개
		}
		
		//dp[i][k]= dp[i-l][k-1] 정수 k-1개를 더해서  , 마지막 더하는 수가 l 이라면 i-l
		//k개를 더해서 i를 만드는 거니까 k-1개를 더했을때 i-l을 만드는 값을 다 더해주면된다.
		for(int i=2;i<=k;i++) {
			for(int j=0;j<=n;j++) {
				for(int z=0;z<=j;z++) { //마지막 수는 j보다 작은거만 올수있음
					//0~j보다 작은거를 다 한번씩 빼준거의 수를 다 더해줘야하니까
					dp[j][i]+=dp[j-z][i-1];
					dp[j][i]=dp[j][i]%1000000000L;			
			}
		}
		}
		System.out.println(dp[n][k]);
	}
}
