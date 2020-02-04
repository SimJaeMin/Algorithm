package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph_1707 {
	static ArrayList<Integer>[] a; //���� ����Ʈ
	static int c[]; //�湮 �Ǵ� �迭
	
	static void bfs(int start, int color) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		c[start]=color;
		q.add(start);
		
		while(!q.isEmpty()) {
			int x=q.remove();
			for(int y:a[x]) {
				if(c[y]==0) { // �湮 ���ѰŸ� 
				q.add(y);
				c[y]=3-c[x];
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test= sc.nextInt();
		int qq=0; //���� �ߺ� �Ǵ� �� ���
		
		for(int i=0;i<test;i++) {
			int v= sc.nextInt(); //��� 
			int e=sc.nextInt(); // ����
		
			a= (ArrayList<Integer>[]) new ArrayList[v+1]; //��������Ʈ
			
			for(int j=1;j<=v;j++) {
				a[j]=new ArrayList<Integer>(); //�迭�ʱ�ȭ
			}
			
			for(int z=0;z<e;z++) {  //���� �߰�
				int x = sc.nextInt();
				int y = sc.nextInt();
				a[x].add(y);
				a[y].add(x);
			}
			
			for(int p=1;p<=v;p++) { // ����
				Collections.sort(a[p]);
			}
			
			c= new int[v+1]; // �湮 �Ǵ� �迭 
			for(int j=1;j<=v;j++) { // �ϳ��� �����ؼ� 
				if(c[j]==0) {  //�湮�ȵǰŸ� bfs ����
					bfs(j,1);
				}
			}

			for(int j=1;j<=v;j++) { //�� ó������
				for(int y:a[j]) { // �װŶ� ������ִ� �������� 
					if(c[j]==c[y]) { //�����
						qq=1; //������ ������ No ����ؾߵǴϱ� qq=1�� �ϴ� ����
					}
				}
			}
			
			if(qq==1) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
			qq=0;
		}
}
}
