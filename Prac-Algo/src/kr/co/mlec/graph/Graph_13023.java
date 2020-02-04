package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Graph_13023 {
	static ArrayList<Integer>[] arr;
	static int count=0;
	static boolean check[];
	
	public static void dfs(int num) {
		check[num]=true; //�湮�ѰŴ� true
		
		for(int i=0;i<arr[num].size();i++) { //�湮 �Ѱ��߿��� ���� �湮�� ���ִ°�ã��
			int x=arr[num].get(i);  // ������ �� �ϳ��� ��������
			
			if(check[x]==true) { // �װ� �湮�ߴ��Ÿ� �����ɷ�
				continue;
			}
			
			if(check[x]==false) { // �湮 ���ߴ��Ÿ� 
				count++; // count�� �����ϰ�
				
				if(count==4) {
					System.out.println(1);
					System.exit(0);
				}
				dfs(x); // �װɷ� ���� �湮�Ұ� ã�´�.
			}
		}
		if(count >0) { // �ѹ��� ���̰� 4�ΰ� ã�ƾߵǴµ� ���� ��忡�� ������������ count�� - ���ش�. �׷��� 0 �����۾����� �ȵǴϱ� 0 0 ���� Ŭ����
		count--;
		}
		check[num]=false;// �ٽ� ������ ���� �湮 ���Ұɷ� �ٲ������
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = (ArrayList<Integer>[]) new ArrayList[n]; // ArrayList�� �迭�� ���� , �迭�� ũ�Ⱑ n�� ArrayList<Integer>�� �迭��
		check = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i]= new ArrayList<Integer>(); // ArrayList�� �迭�̴ϱ� �迭�� ��ҵ��� ArrayList�� �̰Ÿ� ���� ������ �����
		}
		
		for(int i=0;i<m;i++) {
			int first=sc.nextInt(); // ������ ���� �׷����ϱ� ���ʴ� �߰����ֱ�
			int second= sc.nextInt();
			arr[first].add(second);
			arr[second].add(first);
		}
		
		for(int i=0;i<n;i++) { // ����
			Collections.sort(arr[i]);
		}
		
		for(int i=0;i<n;i++) {
			dfs(i); // dfs�� ������ 0 ������ n ������ �� ���ֱ����ؼ�
		}
		
		System.out.println(0);
	}
}
