package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BF_15651 {
	static int a[]; //수열을 저장하기위핸
	static StringBuilder sb;
	public static void go(int n, int m, int len,String s) {
		if(m==len) {
			sb.append(s.trim()+ "\n");
			return;
		}
		
		for(int i=1;i<=n;i++) {
			//a[len]=i; // 중복된 숫자도 가능하니까 1 다음도 1부터 계속 올 수 있음 그래서 앞에 뭐가 왔는지 체크하는
				 		//베열이 필요없다.
			go(n,m,len+1, s + " " +i);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		sb= new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		a= new int[m]; // m 자리 수열을 만들려고하니까
		
		go(n,m,0,""); // 처음 자리수는 0자리
		System.out.println(sb);
	}
}
