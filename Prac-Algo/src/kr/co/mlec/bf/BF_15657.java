package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BF_15657 {
	static int data[];
	static int a[];
	
	static StringBuilder sb;
	public static void go(int n, int m , int len ) {
		if(len == m + 1 ) {
			for(int i=1;i<m+1;i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(a[len-1] <= data[i]) {
				a[len]=data[i];
				go(n,m,len+1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		s= br.readLine().split(" ");
		data= new int[n];
		a= new int[m+1];
		sb= new StringBuilder();
		for(int i=0;i<s.length;i++) {
			data[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(data);
		go(n,m,1);
		
	}
}
