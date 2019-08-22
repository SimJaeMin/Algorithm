package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//문제명 2*N 타일링
public class DP_11726 {
	public static void main(String[] args) throws Exception {
		//1 *2, 2*1 로 채운다 2*n을 
		//마지막에 올수있는거는 1*2 2개가 오거나, 2*1 이 한개가 올수있음
		//그럼 그 앞에는 1*2가 2개 오면 2*n-2를 타일링이되고
		//마지막에 가로가 1칸짜리가오면 총 가로 길이가 n-1 이 되니까 그길이와
		//마지막에 가로가 2칸짜리가오면 총 가로 길이가 n-2 가 되니까 두개를 더해주면된다.
		//2*1 이 1개가 오면 2* n-1 타일링이된다.
		//dp[i] = n일 때 채울수 있는 방법의수를 담으면된다
		//n 일때 채우는 방법의 수는 마지막에 1*2가 오는거와 2*1이 2게개 오는거를 더해주면된다.
		//dp[n]= dp[n-1]+dp[n-2]

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int dp[] = new int[1001];
		
		//for 문을 통해 n이 작을 때부터 하나씩 구한다음 배열에 저장하고 아래에서 구한 내용들을 계속 활용한다.
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=num;i++) {
			dp[i]=dp[i-1]+dp[i-2];
			dp[i]=dp[i]%10007;
		}
		System.out.println(dp[num]);
	}
}
