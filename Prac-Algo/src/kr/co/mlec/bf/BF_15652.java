package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BF_15652 {
	static StringBuilder sb;
	static int a[];
	public static void go(int n, int m,int len, String s) {
		if(len-1==m) { // len 이 1부터 시작했으니까 len - 1 이 m 일 때의 값을 출력한다.
			//sb.append(s.trim() + "\n");
			for(int i=0;i<m;i++) {
				System.out.print( a[i+1] + " "); // index 1이 index 0 이니까 +1 해준다.
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=n;i++) {
			
			if(i>=a[len-1]) { // 자기 바로 전 index 의 값과 비교해서 크거나 같은 값만 올수있으니가 
				a[len]=i; 
				go(n,m,len+1,"");
			}
		
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		sb = new StringBuilder();
		a = new int[m+1]; // m+1 로 배열 크기 설정하는 이유는 index를 1부터 사용하기 위해서 
					      // index -1 과 비교해서 그 값보다 큰 값만 들어갈 수 있는데 0 부터 시작하면 index 가 -1 이 되버린다.
						  // 이걸 막을려고  + 1 을 해준다음 index를 1을 0 처럼 사용한다.
		go(n,m,1 ,""); // len 도 1을 넘겨준다.
		System.out.println(sb);
		
	}
}
