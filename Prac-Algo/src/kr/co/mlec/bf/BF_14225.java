package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_14225 {
	static int data[];
	static int check[];
	static int a[];
	public static void go(int n , int len, int sum) {
		if(len<n) {
			check[sum]++;
		}else if(len==n){
			check[sum]++;
			return;
		}else {
			return;
		}
	
		go(n,len+1,sum+data[len]); // 다음 수를 더해서 가는 경우

		go(n,len+1,sum); // 다음 수를 포함안하고 넘어가는 경우, 다음 수를 포함 안하더라도 이전까지의 합은 저장해야함
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		data= new int[n];
		check=new int[n*100001];
		a=new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		go(n,0,0);
		for(int i=0;i<100001;i++) {
			if(check[i]==0) {
				System.out.println(i);
				break;
			}
		}
	}
}
