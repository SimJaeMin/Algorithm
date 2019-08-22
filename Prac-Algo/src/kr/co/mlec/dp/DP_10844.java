package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//문제명 쉬운 계단수
public class DP_10844 {
	public static void main(String[] args) throws Exception {
		//인접한 모든 자리수의 차이가 1이 나면 계단 수이다.
		//길이가 N인 계단 수가 몇개 있는지 찾는거임
		//DP 는 큰 문제를 작은방식으로 나눠서 푸는 방식이니까 마지막을 분리하는 느낌으로 문제를푼다
		//마지막에 올 수 있는 숫자는 0~9 까지 있다.
		//마지막에 올 수 있는 숫자의 경우들을 다 더하면 몇개가 있는지 나온다.
		//DP[N][L]= N자리수에 끝이 L인 계단수 의 개수
		//DP[N][L] N번째 자리에 L 이 오게된다면  N-1 에는 DP[N-1][L-1], DP[N-1][L+1] 이 올 수 있다.
		//그런데 N번째 자리에 0, 9가 오게된다면 L+1 , L-1 만 가능 하다는걸 생각해야한다.
		//DP[N][L]=DP[N-1][L-1]+DP[N-1][L+1]
		//SUM = DP[N][L] 의합 L = 0~9
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		long dp[][]= new long [n+1][10];
		long sum=0;
		//초기값 지정
		for(int i=1;i<=9;i++) { // 1자리인데 끝이 i 인 것들은 각각 1개씩만 있다.ㄴ
			dp[1][i]=1;			//0으로 시작하는 수는 없기떄문에
		}

		for(int i=2;i<=n;i++) {  //길이가 2인 거부터 n까지 
			for(int j=0;j<=9;j++) { // 마지막 끝나는 숫자가 0부터 9까지
				if(j==9) { //9 라면 j+1 = 10 으로 끝나는 경우는 없으니까 n-1이 8로 끝나는 경우만 더해주고 
					dp[i][j]=dp[i-1][j-1];
					dp[i][j]=dp[i][j]%1000000000;
				}else if(j==0) { //0이라면 j-1은 -1 로 끝나는 경우는없으니까 n-1이 1로 끝나는 경우만 더해주고
					dp[i][j]=dp[i-1][j+1];
					dp[i][j]=dp[i][j]%1000000000;
				}else { // 그경우가 아니고 예를들어 2라면 2로 끝나면 n-1이 1로 끝나는 겨웅와 n-1이 3으로 끝나는 경우를 합쳐줘야 n이 2로 끝나는 모든 경우의 수가 되니까 2개를 더해준다.
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1];
				dp[i][j]=dp[i][j]%1000000000;
				}
			}
		}
		
		for(int i=0;i<=9;i++) {
			sum=(sum+dp[n][i]);
		}
		System.out.println(sum%1000000000);
		
		
		
	}
}
