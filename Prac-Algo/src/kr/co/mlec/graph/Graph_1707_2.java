package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph_1707_2 {
	static ArrayList<Integer>[] a;
	static int check[];
	static Queue<Integer> q;
	public static void dfs(int start, int num) {
		check[start] = num;
		
		for(int i=0;i<a[start].size();i++) {
			int next= a[start].get(i);
			
			if(check[next]==0) {
				dfs(next,3-num);
			}
		}
	}
	
	public static void bfs(int start, int num) {
		q.add(start);
		check[start]=num;
		
		while(!q.isEmpty()) {
			int next = q.poll();
			for(int i=0;i<a[next].size();i++) {
				int x = a[next].get(i);
				if(check[x]==0) {
					if(check[next]==1) {
						check[x]=2;	
						q.add(x);
					}else {
						check[x]=1;
						q.add(x);
					}
						
					
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int i=0;i<test;i++) {
			int sw=0;
			int node = sc.nextInt();
			int edge = sc.nextInt();
			q = new LinkedList<Integer>();
			a = (ArrayList<Integer>[]) new ArrayList[node+1];
			check = new int[node+1];
			for(int j=1;j<=node;j++) {
				a[j] = new ArrayList<Integer>();
			}
			
			for(int z=0;z<edge;z++) {
				int first= sc.nextInt();
				int second = sc.nextInt();
				a[first].add(second);
				a[second].add(first);
			}
			
			for(int jj=1;jj<=node;jj++) {
				Collections.sort(a[jj]);
			}
			
			for(int c=1;c<=node;c++) {
				if(check[c]==0) {
				//dfs(c,1);
					bfs(c,1);
				}
			}
			for(int ii=1;ii<=node;ii++) {
				for(int iii=0;iii<a[ii].size();iii++) {
					int num=a[ii].get(iii);
					if(check[ii]==check[num]) {
						sw=1;
					}
				}
			}
			if(sw==1) {
				System.out.println("NO");
			}else {
				System.out.println("YES");		
			}
		
		}
	}
}
