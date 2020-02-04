package kr.co.mlec.dp;

import java.util.Scanner;

//문제명 : 제곱수의 합
public class DP_1699 {
	public static void main(String[] args) {
		//어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타 낼수있다. 11 =3의제곱 1의제곱 1의제곱
		//이럴때 자연수 N을 만드는 최소항의 개수를 구해야한다
		//DP[I] = I를 만드는 제곱의 최소항의 수
		//DP[I] = 에서 마지막에 올수있는 어떤수의 조건은 어떤수의 제곱은 I보다 작아야한다.
		//dp[i] = dp[i-j*j]+1 (마지막에 오는 수 제곱 수) 마지막에 오는수 j*j를 뺴주고 나온 숫자는 이미 구한숫자니까 그걸 이용하고 j*j는 1번이 되니까  + 1 을 해준다.ㄴ
		//즉 마지막에 올수있는 숫자는 1부터 N보다작은 제곱수
		//초기값에는 모든 수를 1의 제곱으로 만드는 자기자신이 들어간다. (제일 많은 경우)
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int dp[]=new int[num+1];
		
		for(int i=1;i<=num;i++) {
			dp[i]=i; //초기값 설정
		}
		
		for(int i=1;i<=num;i++) {
			for(int j=1;j*j<=i;j++) { //여기서 J가 마지막에 오는 경우의 수가된다.
				if(dp[i]>dp[i-(j*j)]+1) //마지막에 오는 숫자를 제곱해서 빼주는 경우이니까 dp[i-j*j] 마지막 숫자가 j*j인 경우를 뺀 숫자의 최소항의 개수 + 자기자신을 제곱한 경우의수 (1) 을 더해준다.
				dp[i]=dp[i-j*j]+1;	//J를 빼준 거의 DP[I-J] 를 사용해준다.
			}
		}
		System.out.println(dp[num]);
		
	}
}
