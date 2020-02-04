package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class DP_14002 {
	static int a[];
	static int data[];
	public static void go(int aa) {
		
		if(aa==0) {
			return;
		}
		go(a[aa]);
		System.out.print(data[aa]+ " ");
	}
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		data=new int[1001];
		
		int dp[]=new int[1001];
		a = new int[1001];
		//dp수열 이 있을때 가장 긴 증가하는 부분수열의 갯수
		//초기값은 각자 자기 자신이 가장 긴 증가하는 거일수도 있으니 모두 1
		
		
		//dp[i] 는 dp[i] 까지 제일 긴 부분수열의 수
		//그런데 그 수열이 뭔지도 출력을해줘야함
		String s[] = br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			data[i]=Integer.parseInt(s[i-1]);
			dp[i]=1;
		}
		
		for(int i=1;i<=n;i++) { // 1부터 n 까지
			for(int j=1;j<i;j++) { // 1~2 , 1~3 , 1~4 이렇게 올라가고
				if(data[i]>data[j]) { // 그때 ex 4보다 1,2,3 번째꺼를 비교해서 4보다 작고
					if(dp[i]<dp[j]+1) { // 그때 가장 긴 수열도 작으면
						dp[i]=dp[j]+1; // 자기자신 + 이전까지 가장 긴 수열의 값을 더한게 자기자신이되고
						a[i]=j;//수열을 출력해줘야되니까 자기 자신 이전의 수열의 인덱스를 저장한다.
					}
				}
			}
		}
		int max=-2147000000;
		int max1=0;
		for(int i=1;i<=n;i++) {
			if(dp[i]>max) {
				max=dp[i];
				max1=i; // 가장 큰 인 부분 수열의 마지막을 찾고 a[마지막] 을 하면 이거 전깨 나오고 이게 0이 나올때까지
				//0 나올때까지 해야하는 이유는 0이 나와야 앞이 없는거니까
			}
		}
		System.out.println(max);
		
		go(max1); // 
		System.out.println();
	}
}
