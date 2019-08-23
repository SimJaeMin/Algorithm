package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//문제명 : 가장 긴 바이토닉 부분 수열
public class DP_11054 {
	public static void main(String[] args) throws Exception {
		//증가했다가 감소하는 부분 수열이 가장 긴 걸 찾으면된다.
		//그런데 가장 길었다가 감소하기 시작하는 부분에서 그 기준이 되는 수는 2번 체크 되기 때문에 전체길이 -1 을 해줘야한다.
		//먼저 가장 긴 증가하는 부분 수열을 찾고 그 부분에서 다시 가장 긴 감소하는 부분 수열을 찾으면 된다.
		//dp를 2번 돌려서 1번은 가장 긴 증가, 다른 한 번은 가장 긴 감소를 해서 2개를 더해주고 -1을 하면된다.
		//그런데 여기서 내가 입력받은 수열을 뒤집어서 가장 긴 감소하는 수열을 구해서 두개를 더해줄때는 같은 인덱스가아닌 반대로 되어있음
		//그래서 여기서는 뒤집어서 푸는것보다는 가장 감소하는 긴 수열을 num 부분부터 반대로 푸는 방법이 더 좋은거같음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		int dp1[] = new int[num+1]; //가장 긴 증가하는 부분 수열 저장
		int dp2[]= new int[num+1]; //가장 긴 감소하는 부분 수열 저장
		List<Integer> a=new ArrayList<Integer>();
		
		String s[]=br.readLine().split(" ");
		for(int i=1;i<=num;i++) {
			a.add(Integer.parseInt(s[i-1]));
			dp1[i]=1; //개수니까 1로 초기화
			dp2[i]=1;
		}
		
		for(int i=0;i<num;i++) { //가장 긴 증가하는 부분수열 사용
			for(int j=0;j<i;j++) {
				if(a.get(i)>a.get(j)) {
					if(dp1[i+1]<dp1[j+1]+1) {
						dp1[i+1]=dp1[j+1]+1;
					}
				}
			}
		}
		Collections.reverse(a); // 가장 긴 감소하는 부분수열을 풀기위해 reverse 사용
		
		for(int i=0;i<num;i++) { // 가장 긴 감소하는 부분수열 사용
			for(int j=0;j<i;j++) {
				if(a.get(i)>a.get(j)) {
					if(dp2[i+1]<dp2[j+1]+1) {
						dp2[i+1]=dp2[j+1]+1;
					}
				}
			}
		}

		
		
		for(int i=1;i<=num;i++) { // 내가 마음대로 수열을 뒤집었기때문에 더해줄때 반대쪽부터 더해줘야함
			dp1[i]=dp1[i]+dp2[num+1-i];
		}
		int max=dp1[1];
		for(int i=2;i<=num;i++) {
			if(max<dp1[i]) {
				max=dp1[i];
			}
		}
		
	
		System.out.println(max-1);
	}
}
