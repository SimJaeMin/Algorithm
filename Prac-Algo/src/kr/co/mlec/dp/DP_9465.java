package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//문제명: 스티커
public class DP_9465 {
	public static void main(String[] args) throws Exception {
		//스티커를 뜯을건데 질이 안좋아서 하나를 뜯으면 그 주변에 위, 아래, 양옆은 버려야한다. 
		//각 스티커에는 점수가 있는데 가장 높은 점수를 만들고 싶어한다.
		//최대값을 구해야하니까 각각의 경우를 계속 저장하면서가야함
		//어디부터 뜯어야 된다는 말이없으니까 왼쪽부터 뜯는다고 가정하고 맨 왼쪽에서 
		//위에꺼 하나뜯는경우, 아래꺼 하나뜯는경우, 안뜯는 경우 이렇게 있고
		//위에꺼 하나 뜯는 경우는  그 다음에 안뜯거나 아래꺼 하나 뜯을 수 있고
		//아래꺼 하나 뜯는  경우는 그다음에 안뜯거나 위에꺼 하나
		//안뜯은 경우는 위,아래,또안뜯기 이렇게 3중에 선택할 수 있는데 
		//이렇게 뜯어가면서 최대값을 계속 저장해나가면된다.
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		int num;
		long p[][];
		long dp[][];
		for(int i=0;i<test;i++) {
			num=Integer.parseInt(br.readLine());
			p=new long[num+1][2];
			dp=new long[num+1][3];
			
			String s[]=br.readLine().split(" ");
			for(int a=1;a<=num;a++) {
				p[a][0]=Long.parseLong(s[a-1]);
			}
			
			s=br.readLine().split(" ");
			for(int a=1;a<=num;a++) {
				p[a][1]=Long.parseLong(s[a-1]);
			}
			
			for(int j=1;j<=num;j++) {
				//j번째에서 하나도 안뜯은거 위에꺼 아래꺼 인데 2번째라고 가정하면 2번째줄에서 하나도 안뜯은거는 첫번째 줄에서 다 해도되니까 3중 가장 큰거
				//2번째 줄에서 위에꺼를 뜯는다면 첫번째줄에서 아래꺼나 안뜯어야되니까 둘중 큰거에 2번째거  위에꺼 뜯은거 더해주곤
				//2번재줄에서 아래꺼를 뜯는다면 첫 번째줄에서 위에꺼나 안뜯어야되니까 둘중 큰거에 2번째거 아래꺼 뜯은거 더해주기
				dp[j][0]=Math.max(dp[j-1][0],Math.max(dp[j-1][1], dp[j-1][2]));
				dp[j][1]=Math.max(dp[j-1][0],dp[j-1][2])+p[j][1];
				dp[j][2]=Math.max(dp[j-1][0], dp[j-1][1])+p[j][0];
			}
			//그리고 그 중 제일 큰거 출력
			System.out.println(Math.max(dp[num][0], Math.max(dp[num][2],dp[num][1])));
		}
	
	}
}
