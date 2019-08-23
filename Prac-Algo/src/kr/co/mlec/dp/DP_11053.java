package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//문제명 가장 긴 증가하는 부분수열
public class DP_11053 {
	public static void main(String[] args) throws Exception{
		//수열 A가 주어졌을때 가장 긴 증가하는 부분 수열의 수를 구하는 문제임
		//DP[i] = i번째 수열까지 가장 긴 증가하는 부분 수열의 수
		//DP[i] = max ( dp[1 ~ i-1]) + 자기자신 (1) 
		//비교 1 :증가하는 부분 수열이 되기위해서는 A[i]가 A[1 ~ i-1 ] 까지 각각의 원소 보다 큰 상태여야한다.
		//각각의 원소보다 커야 증가하는 부분수열을 이어갈 수 있기 떄문이다.
		//비교 2 : j< i i가 j보다 큰 인덱스를 가지고 있어한다. 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num= Integer.parseInt(br.readLine());
		String []s = br.readLine().split(" ");
		int a[]=new int[num+1];
		int dp[] = new int[num+1];
		
		for(int i=1;i<=num;i++) {
			a[i]=Integer.parseInt(s[i-1]);
			dp[i]=1; // 모든 가장 긴 증가하는 부분수열은 자기자신을 포한한 길이 1이 초기값
		}
		
		//dp[i]= i번째 인덱스까지 가장 긴 증가하는 부분 수열의 수
		for(int i=1;i<=num;i++) {
			for(int j=1;j<i;j++) { //비교 2를 만족하기 위해 j는 i보다 앞에 있어야함
				if(a[i]>a[j]) { //비교 1을 만족하기위해 a[i]가 a[j]보다 커야 증가하는 부분수열
					if(dp[i]<=dp[j])	//증가하는 부분수열의 개수가 더 많으면 
					dp[i]=dp[j]+1; //거기다 자기자신을 더해 하나를 추가
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
