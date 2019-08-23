package kr.co.mlec.dp;
//문제명 : 가장 큰 증가 부분 수열

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP_11055 {
	public static void main(String[] args) throws Exception{
		//가장 큰 증가 부분 수열이란 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램이다.
		//증가하는 부분 수열이 여러개 있는데 이중 부분 수열들의 전체 합이 가장 큰것을 출력해야한다.
		//dp[i]= a[i] 를 포함한 증가하는 부분 수열의 합
		//dp[i]는 2가지 조건이 있음 j < i 가 커야 하고 ( 부분 수열중 뒤에 있어야하니까)
		//a[j] < a[i] 여야 한다. 그래야 증가하는 부분 수열이 완성된다.
		//증가하는 부분 수열의 길이는 초기값이 모두 자기자신 하나 여서 1이였지만 여기서는 자기자신의 값이다.
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
			for(int j=1;j<i;j++) { //i번째 전까지만 가능
				if(a[j]<a[i]) {
					if(dp[i]<dp[j]+a[i]) {
					dp[i]=dp[j]+a[i]; //연속된 개수였으면 1을 증가지만 합이니가 자기자신을 더해준다.
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
