package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_14501 {
	static int data[];
	static int day[];
	static int max=0;
	public static void go(int n, int index, int sum, int len) {
		if(len== n) {
			if(max<sum) {
				max=sum;
			}
			return;
		}
		if(len>n) { // 퇴사날짜보다 상담이 끝나는날이 더 늦게될수도
			return;
		}
		
		go(n,index+day[index] , sum+data[index],len+day[index]); //그 날 상담을하면 상담이 걸리는 시간만큼 다른 상담을 못하니 그 만큼 넘겨준다.
		go(n,index+1,sum,len+1); //그날 상담을 안하면 그 다음날로 간다. len 은 1증가하는게 상담을안해도 날짜는 지나가니까
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		data=new int[n];
		day=new int[n];
		
		for(int i=0;i<n;i++) {
			day[i]=sc.nextInt();
			data[i]=sc.nextInt();
		}
		
		go(n,0,0,0);
		System.out.println(max);
	}
}
