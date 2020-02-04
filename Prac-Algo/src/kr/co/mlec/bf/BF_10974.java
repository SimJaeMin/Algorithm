package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_10974 {
	static int check[];
	static int a[];
	
	public static void go(int n, int len, int index) {
		if(len == n ) {
			for(int i=0;i<n;i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(check[i-1] < 0 ) {
				continue;
			}
			check[i-1]--;
			a[len]=i;
			go(n,len+1,1);
			check[i-1]++;
		}

		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		check= new int[n];
		a = new int [n];
		
		go(n,0,1);
	}
}
