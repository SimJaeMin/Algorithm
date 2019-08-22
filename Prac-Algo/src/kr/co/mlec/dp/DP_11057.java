package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//문제명 오르막수
public class DP_11057 {
public static void main(String[] args) throws Exception{
	//오르막수란 오른쪽으로 갈수록 크거나 같은 숫자가 나와야한다.
	//DP[N][L] N자리 수에 마지막 숫자가 [L]인 오르막수의 개수
	//DP[N][L] 은 DP[N-1][0] 부터 DP[N-1][L] 까지를 다 더해주면된다.
	//그 이유는 왼쪽보다 크거나 같은수가 와야되니까
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n=Integer.parseInt(br.readLine());
	long dp[][];
	dp=new long[n+1][10]; //10인 이유는 0~9까지가 마지막에 올수있음
						  //n+1 을 해주는 이유는 1자리 수부터 n자리까지 이니까
	for(int i=0;i<=9;i++) {
		dp[1][i]=1; //숫자는 0으로 시작할수 있으니까 한자리인데 마지막수가 0인것도 1개로 해줘야함
	}
	
	for(int i=2;i<=n;i++) { // n자리 수까지가고
		for(int j=0;j<=9;j++) { //한 자리마다 0~9까지가 올수있고
			dp[i][j]=0;	
			for(int k=0;k<=j;k++) {	//dp[i][L]= dp[i-1][L보다 작거나 같은수까지]
										//L 즉 j가 0이면 0까지 5면 5까지 할수있게
					dp[i][j]=dp[i][j]+dp[i-1][k];
					dp[i][j]=dp[i][j]%10007;
			}	
		}
	}
	long sum=0;
	for(int i=0;i<=9;i++) {
		sum=sum+dp[n][i];
		sum=sum%10007;
	}
	System.out.println(sum);
}
}
