package kr.co.mlec.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Graph_2667 {
	static int data[][];
	static boolean check[][];
	static int x[] = { -1, 1, 0, 0 }; //상하좌우 갈수있으니까
	static int y[] = { 0, 0, -1, 1 }; // 상하좌우 갈수이으니까
	static Vector<Integer> v;
	static int num=0;
	public static void dfs(int i, int j,int n) {
		check[i][j] = true;
		
		for(int a=0;a<4;a++) { // 하나의 점에서 상하좌우를 다 갈 수있으니까 갈수있는지 체크해봐야함
			int nextX = i+x[a]; // 상항좌우 순서대로
			int nextY = j+y[a];
	
			if(nextX > -1 && nextY> -1 && nextX < n && nextY < n && check[nextX][nextY]==false && data[nextX][nextY] == 1) {
				 //만약에 갈 수있다면  num(단5지수를 증가) 시키고 그 위치에서 또 상하좌우 갈수있는 곳이있는지 찾아야함
				num++;
				dfs(nextX,nextY,n);
			}
			
		}
	}	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		data = new int[n][n];
		check = new boolean[n][n];
		int count = 0;
		
		v= new Vector<Integer>();
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				data[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i][j] == false && data[i][j] == 1) {
					dfs(i, j,n);
					v.add(num);
					num=0;
					count++;
				}
			}
		}
		System.out.println(count);
		Collections.sort(v);
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i)+1); // +1 을 해주는 이유는 맨처음에 갈수있는곳을찾아서 시작하면 그곳은 num에 포함이 안되서 마지막에 1을추가해준다.
		}
	}
}