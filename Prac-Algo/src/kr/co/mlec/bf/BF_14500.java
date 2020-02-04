package kr.co.mlec.bf;

import java.util.ArrayList;
import java.util.Scanner;

public class BF_14500 {
	static int[][] a = new int[501][501];
	static boolean[][] check = new boolean[501][501];
	static int n, m;
	static int max = 0;

	static int[] xx = { -1, 1, 0, 0 }; //�� , �� , ��,��
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
		    // �Ǹ��
		    if(x>=1 && y>=1 && y<m-1)
		      max= Math.max(max, a[x][y]+a[x-1][y]+a[x][y-1]+a[x][y+1]);
		    // �̸��
		    if(x<n-1 && y>=1 && y<m-1)
		        max = Math.max(max, a[x][y]+a[x+1][y]+a[x][y-1]+a[x][y+1]);
		    // �����
		    if(x<n-1 && x>=1 && y<m-1)
		        max = Math.max(max, a[x][y]+a[x+1][y]+a[x-1][y]+a[x][y+1]);
		    // �ø��
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
		
		for(int i=0;i<n;i++) { //������ ����� ���� �ѹ��� ������ 4�� dfs �ϳ��� ���� �Ѹ���� ���ָ�ȴ�.
			for(int j=0;j<m;j++) {
				check[i][j]=true;
				dfs(i,j,1,a[i][j]); //���� x,y ��ǥ , �ʱ� ī��Ʈ(4���� ������ų ����) , ������ ��ǥ�� ��
				check[i][j]=false;
				
				oa(i,j);
				
			}
		}
		System.out.println(max);
	}
}
