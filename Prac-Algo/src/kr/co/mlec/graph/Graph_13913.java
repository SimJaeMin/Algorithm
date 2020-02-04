package kr.co.mlec.graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class Graph_13913 {
	static boolean check[];
	static int prev[];
	static Vector<Integer> v;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int n=sc.nextInt();
		int k=sc.nextInt();
		v= new Vector<Integer>();
		prev = new int[100001];
		check= new boolean[100001];
		int num=-1;
		
		if(n==k) {
			System.out.println(0); //ó������ �������� ������ 0�������̰�
			System.out.println(n); // �̵���δ� n �ϳ�
			return;
		}
		q.add(n); //�ʱ� ������� ����
		check[n]=true;
		boolean t=true;
		while(!q.isEmpty() && t) {
			
			int size = q.size(); 
			
			for(int i=0;i<size;i++) {
				int next =q.poll();
				
				if(next -1 > -1 && check[next-1]==false) {
					q.add(next-1);
					check[next-1]=true; //�湮������ �湮�ߴٰ� üũ�ϰ�
					prev[next-1]=next; //�̰� �湮�ϱ������� ��� �湮�޴��� ����
				}
				
				if(next + 1 <= 100000 && check[next+1]==false) {
					q.add(next+1);
					check[next+1]=true;
					prev[next+1]=next;
				}
				
				if(next * 2 <=100000 && check[next*2]==false) {
					q.add(next*2);
					check[next*2]=true;
					prev[next*2]=next;
				}
				
				if(next==k) {
					v.add(next); // �������� �湮�ѰŴϱ� �߰��ϰ�
					int a= prev[next]; // �������� �湮�ϰ� �ٷ� ���� �湮�ߴ��� ã������
					while(a!=n) {// �װ� ó�� ������Ұ� ���ö�����
						v.add(a); //���ã���ֱ�
						a=prev[a];
					}
					t=false;
					break;
				}
			}
			num++;
		}
		System.out.println(num);
		//Collections.reverse(v);
		//System.out.print(n + " ");
		sb.append(n + " ");
		for(int i=v.size()-1;i>=0;i--) {
			//System.out.print(v.get(i) + " ");
			sb.append(v.get(i) + " ");
		}
		
		System.out.println(sb);
		
	}
}
