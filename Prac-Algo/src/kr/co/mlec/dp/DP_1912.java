package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//문제명 연속합 
public class DP_1912 {
	public static void main(String[] args) throws Exception{
		//n 개의 정수로 이루어진 수열이 주어지고 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합중 가장 큰합를 구해야한다.
		//연속된 수라는 것이 중요하다.
		//dp[i] 는 i번 째 까지 연속된 수의 합중 가장 큰 값을 저장 
		//dp[i] = dp[i-1]+a[i] 이거나 a[i] 2중 큰 값을 저장하면된다.
		//연속된 수니까 dp에 올수 있는 경우는 앞에서 자기껄 더한 것과, 자기가 새롭게 시작한 경우 만있음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int a[]=new int[num+1];
		int dp[]=new int[num+1];
		
		String s[] = br.readLine().split(" ");
		
		for(int i=1;i<=num;i++) {
			a[i]=Integer.parseInt(s[i-1]);
			dp[i]=a[i]; // 자기 자신이 시작이 되니가
		}
		
		for(int i=1;i<=num;i++) {
			dp[i]=Math.max(dp[i-1]+a[i], a[i]); //연속된 수니까 자기자신과, 이전꺼와 자기자신을 더한값중 큰값
		}
		int max=dp[1];
		for(int i=2;i<=num;i++) { //그중 가장 큰값을 찾으면된다.
			if(max<dp[i]) {
				max=dp[i];
			}
		}
		System.out.println(max);
		
		
	}
}
