package kr.co.mlec.bf;

import java.util.Arrays;
import java.util.Scanner;

public class BF_10819 {
	static int data[];
	static int a[];
	static int check[];
	static int max = -1;
	public static void go(int n,int len) {
		int sum=0;
		int c;
		if( len == n ) {
			for(int i=2;i<=n;i++) {
				c=a[i-2]-a[i-1];
				if(c<0) {
					c= -c;
				}
				sum=sum+c;
				c=0;
			}
			if (max < sum) {
				max=sum;
				sum=0;
			}
			sum=0;
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(check[i]<0) {
				continue;
			}
			check[i]--;
			a[len]=data[i];
			go(n,len+1);
			check[i]++;
		}
		
	}
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		data= new int[n]; 
		a= new int[n];
		check = new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		
		Arrays.sort(data);
		go(n,0);
		System.out.println(max);
	}
}
