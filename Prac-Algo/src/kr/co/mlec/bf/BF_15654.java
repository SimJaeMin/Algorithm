package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BF_15654 {
	static int a[];
	static int data[];
	static boolean check[];
	public static void go(int n , int m, int len) {
		
		if(m==len) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(check[i]) {
				continue;
			}
			check[i]=true;
			a[len]=data[i];
			go(n,m,len+1);
			check[i]=false;
		}
	
	}
	public static void main(String[] args) throws Exception {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 String s[]=br.readLine().split(" ");
	 int n = Integer.parseInt(s[0]);
	 int m = Integer.parseInt(s[1]);
	 a = new int[m];
	 check = new boolean[n];
	 data = new int[n];
	 s= br.readLine().split(" ");
	 int len = s.length;
	
	 for(int i=0;i<len;i++) {
		 data[i]=Integer.parseInt(s[i]);
	 }
	 Arrays.sort(data);
	 
	 go(n,m,0);
	}
}
