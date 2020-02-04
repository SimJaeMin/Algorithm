package kr.co.mlec.bf;

import java.util.ArrayList;
import java.util.Scanner;

public class BF_14500 {
	static int[][] a = new int[501][501];
	static boolean[][] check = new boolean[501][501];
	static int n, m;
	static int max = 0;

	static int[] xx = { -1, 1, 0, 0 }; //상 , 하 , 좌,우
	static int[] yy = { 0, 0, -1, 1 };

	private static void dfs(int x, int y, int count, int first) {
		if(count>=4) {
			max=Math.max(max, first);
			return;
		}
		for(int i=0;i<4;i++) {
			int nextX= x+xx[i];
			int nextY= y+yy[i];
			if(nextX >= 0 && nextY >= 0 && check[nextX][nextY]== false && nextX<n && nextY < m) {
				check[nextX][nextY]=true;
				dfs(nextX,nextY,count+1,first+a[nextX][nextY]);
				check[nextX][nextY]=false;
			}
		}
	}
	private static void oa(int x, int y) {
		    // ㅗ모양
		    if(x>=1 && y>=1 && y<m-1)
		      max= Math.max(max, a[x][y]+a[x-1][y]+a[x][y-1]+a[x][y+1]);
		    // ㅜ모양
		    if(x<n-1 && y>=1 && y<m-1)
		        max = Math.max(max, a[x][y]+a[x+1][y]+a[x][y-1]+a[x][y+1]);
		    // ㅏ모양
		    if(x<n-1 && x>=1 && y<m-1)
		        max = Math.max(max, a[x][y]+a[x+1][y]+a[x-1][y]+a[x][y+1]);
		    // ㅓ모양
		    if(x<n-1 && x>=1 && y>=1)
		        max = Math.max(max, a[x][y]+a[x+1][y]+a[x-1][y]+a[x][y-1]);
		  
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<n;i++) { //각각의 모든점 에서 한번은 뎁스가 4인 dfs 하나는 남은 한모양을 해주면된다.
			for(int j=0;j<m;j++) {
				check[i][j]=true;
				dfs(i,j,1,a[i][j]); //현재 x,y 좌표 , 초기 카운트(4까지 증가시킬 목적) , 시작한 좌표의 값
				check[i][j]=false;
				
				oa(i,j);
				
			}
		}
		System.out.println(max);
	}
}
