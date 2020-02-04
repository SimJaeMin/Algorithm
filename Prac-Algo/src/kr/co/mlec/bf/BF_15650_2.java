package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_15650_2 {
	static int a[];
	public static void go(int n , int m , int len, int index) {
		
		if(len == m) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i]+ " ");
			}
			System.out.println();
			return;
		}
		if(index>n) { // 모든걸 포함 안할때
			return;
		}
		
		a[len]=index; // 포함하는 경우
		go(n,m,len+1, index +1);
		a[len]=0; // 포함 하지 않는경우
		go(n,m,len,index+1);
		//이전 자리까지는 a[len] 에저장
	}
	public static void main(String[] args) {
		//선택 방식으로 풀거임
		//그러면 수열 중 이 수열을 포함할지 안할지 (오름차순이면 포함 , 아니면 포함 X ) 를 구분해줘야함
		
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m= sc.nextInt();
		
		a= new int[m];
		
		go(n,m,0,1);
		
	}
}
