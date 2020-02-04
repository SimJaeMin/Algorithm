package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph_10451 {
	static int[] a;
	static boolean c[];

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a[start]);
		c[start]=true;
		
		while(!q.isEmpty()) {
			int y=q.remove();
			if(c[y]==false) {
				q.add(a[y]);
				c[y]=true;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test=sc.nextInt();
		int count=0;
		for(int i=0;i<test;i++) {
			int v = sc.nextInt();
			a=new int[v+1];
			for(int j=1;j<=v;j++) {
				a[j]=sc.nextInt();
			}
			
			c= new boolean[v+1];
			for(int j=1;j<=v;j++) {
				if(c[j]==false) {
					count++;
					bfs(j);
				}
			}
			
			System.out.println(count);
			count=0;
		}
	}
}
