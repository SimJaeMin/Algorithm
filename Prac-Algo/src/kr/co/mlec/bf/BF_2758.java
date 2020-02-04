package kr.co.mlec.bf;

import java.util.Scanner;
//for(int ii=1;ii<=m;ii++) {
//for(int jj=1;jj<=n;jj++) {
//	System.out.print(dp[ii][jj] + " ");
//}
//System.out.println();
//}
public class BF_2758 {

	static long dp[][]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int i=0;i<test;i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			dp=new long[2001][11]; //마지막수가 i보다 작고 , 수의 갯수가 j인거
			
			for(int a=1;a<=m;a++) {
				dp[a][1]=1; //마지막 수가 a이고  수의 갯수가 1개인것은 모두 다 1개
			}
			
			for(int a=1;a<=m;a++) {     //마지막수가 a보다 작고
				for(int b=2;b<=n;b++) { //숫자의 개수가 b인거 	
										//의 수는 마지막 수가 a/2 이보다 작은거고 숫자가 b-1나인거
										//마지막수는 그 전보다 2배 이상 커야되고 숫자의 수가 지금보다 1개 적은거들의 합
					for(int k=1;k<=a/2;k++) {//마지막 수 A는 그전보다 2배 커야되나까 A/2까지
						dp[a][b]=dp[a][b]+dp[k][b-1];
					}
				}
			}
			
			long sum=0;
			for(int c=1;c<=m;c++) {
				sum=sum+dp[c][n];
			}
			//더해주는 이유는 마지막 숫자가 m보다 작고 숫자의수가 n개인거는
			//마지막 숫자가 1~ m 인거의 합이니까

			System.out.println(sum);
	}
}
}