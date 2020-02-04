package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph_1260 {
	
	public static void dfs(int start) {
		if(c[start]==true) {
			return;
		}
		c[start]=true;
		System.out.println(start + " ");
		
		for(int y:a[start]) {
			if(c[y]==false) {
				dfs(y);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		c[start]=true;
		while(!q.isEmpty()) {
			int x=q.remove();
				for(int y:a[x]) {
					if(c[y]==false) {
					q.add(y);
					c[y]=true;
			}
				}
		}
	}
	
	
	static ArrayList<Integer>[] a;
	static int [] b;
	
	static boolean[] c;
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		
		a=(ArrayList<Integer>[])new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			a[i]=new ArrayList<Integer>();
		}
		
		for(int i=1;i<=m;i++) {
			int u=sc.nextInt();
			int v=sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		for(int i=1;i<=n;i++) {
			Collections.sort(a[i]);
		}
		
		c = new boolean[n+1];
		dfs(start);
		System.out.println();;
	
		c= new boolean[n+1];
		bfs(start);
		System.out.println();
		
}
}
class pair <W,V>{
	private W weight;
	private V v;
	public W getWeight() {
		return weight;
	}
	public void setWeight(W weight) {
		this.weight = weight;
	}
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
	
}