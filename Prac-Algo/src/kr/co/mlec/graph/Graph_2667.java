package kr.co.mlec.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Graph_2667 {
	static int data[][];
	static boolean check[][];
	static int x[] = { -1, 1, 0, 0 }; //�����¿� ���������ϱ�
	static int y[] = { 0, 0, -1, 1 }; // �����¿� ���������ϱ�
	static Vector<Integer> v;
	static int num=0;
	public static void dfs(int i, int j,int n) {
		check[i][j] = true;
		
		for(int a=0;a<4;a++) { // �ϳ��� ������ �����¿츦 �� �� �������ϱ� �����ִ��� üũ�غ�����
			int nextX = i+x[a]; // �����¿� �������
			int nextY = j+y[a];
	
			if(nextX > -1 && nextY> -1 && nextX < n && nextY < n && check[nextX][nextY]==false && data[nextX][nextY] == 1) {
				 //���࿡ �� ���ִٸ�  num(��5������ ����) ��Ű�� �� ��ġ���� �� �����¿� �����ִ� �����ִ��� ã�ƾ���
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
			System.out.println(v.get(i)+1); // +1 �� ���ִ� ������ ��ó���� �����ִ°���ã�Ƽ� �����ϸ� �װ��� num�� ������ �ȵǼ� �������� 1���߰����ش�.
		}
	}
}