package kr.co.mlec.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair22 {
	int a;
	int b;

	public Pair22(int a, int b) {
		this.a = a;
		this.b = b;
	}

}

public class Graph_13549 {
	static boolean check[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		check = new boolean[100001];
		Queue<Pair22> q = new LinkedList<Pair22>();

		q.add(new Pair22(n, 0));
		check[n] = true;
		while (!q.isEmpty()) {
				Pair22 next = q.poll();
				int x = next.a; // 현재 위치정점
				int y = next.b; // 현재 위치까지 이동한 횟수

				if(x==k) {
					System.out.println(y);
					return;
				}
				
				if(2*x<=100000 && check[2*x]==false) {
					q.add(new Pair22(2*x,y));
					check[2*x]=true;
				}
				
				if (x - 1 >= 0 && check[x-1]==false) { //이동할수 있으면
					q.add(new Pair22(x-1,y+1));
					check[x-1]=true;
				}
				
				if(x+1 <=100000 && check[x+1]==false) {
					q.add(new Pair22(x+1,y+1));
					check[x+1]=true;
				}
				
			
			
		}
	}
}
