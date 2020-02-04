package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BF_15656 {
	static int data[];
	static int a[];
	static StringBuilder sb;
	
	public static void go(int n, int m, int len,String s) {
		if(len==m) {
			sb.append(s.trim() + "\n");
			return;
		}
		for(int i=0;i<n;i++) {
			go(n,m,len+1,s+ " " + data[i]);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		data = new int[n];
		a = new int[m];
		s =br.readLine().split(" ");
		for(int i=0;i<s.length;i++) {
			data[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(data);
		go(n,m,0,"");
		System.out.println(sb);
	}
}
