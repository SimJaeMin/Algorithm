package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BF_15655 {
	static int a[];
	static int data[];
	public static void go(int n, int m , int len, int index) {
		if(m==len) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i]+ " ");
			}
			System.out.println();
			return;
		}
		if(index>=n) {
			return;
		}
		a[len]=data[index];
		go(n,m,len+1,index+1);
		a[len]=0;
		go(n,m,len,index+1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n= Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		s= br.readLine().split(" ");
		data = new int[n];
		a = new int[m];
		for(int i=0;i<s.length;i++) {
			data[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(data);
		go(n,m,0,0);
	}
}
