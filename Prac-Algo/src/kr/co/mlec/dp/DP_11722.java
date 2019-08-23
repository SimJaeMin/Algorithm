package kr.co.mlec.dp;
//문제명 : 가장 긴 감소하는 부분 수열

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP_11722 {
	public static void main(String[] args) throws Exception {
		//가장 긴 감소하는 부분수열은 가장 긴 증가하는 부분수열 
		//방법 1 : 가장 끝 부분 부터 증가하는 부분수열을 하게되면 감소하는 부분수열이된다.
		//방법 2 : 입력받은 수열을 REVERSE하고 한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num= Integer.parseInt(br.readLine());
		int a[]= new int[num+1];
		int dp[] = new int[num+1];
		String s[]= br.readLine().split(" ");
		
		for(int i=1;i<=num;i++) {
			a[i]=Integer.parseInt(s[i-1]);
			dp[i]=1; //가장 긴 감소하는 부분수열의 초기값은 자기 자신 1임
		}
		
		for(int i=num;i>=1;i--) {
			for(int j=num;j>i;j--) {
				if(a[i]>a[j]) {
					if(dp[i]<dp[j]+1){
						dp[i]=dp[j]+1;
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
