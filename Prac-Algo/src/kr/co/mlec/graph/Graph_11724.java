package kr.co.mlec.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;
public class Graph_11724 {
	static ArrayList<Integer>[] g;
	static boolean c[];
	
	static void bfs(int start) {
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(start);
		c[start]=true;
		
		while(!q.isEmpty()) {
			int x=q.remove();
			for(int y : g[x]) {
				if(c[y]==false) {
				q.add(y);
				c[y]=true;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int v= sc.nextInt();
		int e= sc.nextInt();
		int count=0;
		g = (ArrayList<Integer>[]) new ArrayList[v+1];
		Vector<Integer> aa = new Vector<Integer>();
		int a[] = new int[10];
	
		for(int i=1;i<=v;i++) {
			g[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<e;i++) {
			int x= sc.nextInt();
			int y= sc.nextInt();
			g[x].add(y);
			g[y].add(x);
		}
		c= new boolean[v+1];
		
		for(int i=1;i<=v;i++) {
			if(c[i]==false) {
				bfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
}
