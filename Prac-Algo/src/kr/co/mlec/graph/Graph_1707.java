package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph_1707 {
	static ArrayList<Integer>[] a; //인접 리스트
	static int c[]; //방문 판단 배열
	
	static void bfs(int start, int color) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		c[start]=color;
		q.add(start);
		
		while(!q.isEmpty()) {
			int x=q.remove();
			for(int y:a[x]) {
				if(c[y]==0) { // 방문 안한거면 
				q.add(y);
				c[y]=3-c[x];
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test= sc.nextInt();
		int qq=0; //색깔 중복 판단 때 사용
		
		for(int i=0;i<test;i++) {
			int v= sc.nextInt(); //노드 
			int e=sc.nextInt(); // 간선
		
			a= (ArrayList<Integer>[]) new ArrayList[v+1]; //인접리스트
			
			for(int j=1;j<=v;j++) {
				a[j]=new ArrayList<Integer>(); //배열초기화
			}
			
			for(int z=0;z<e;z++) {  //간선 추가
				int x = sc.nextInt();
				int y = sc.nextInt();
				a[x].add(y);
				a[y].add(x);
			}
			
			for(int p=1;p<=v;p++) { // 정렬
				Collections.sort(a[p]);
			}
			
			c= new int[v+1]; // 방문 판단 배열 
			for(int j=1;j<=v;j++) { // 하나씩 시작해서 
				if(c[j]==0) {  //방문안되거면 bfs 시작
					bfs(j,1);
				}
			}

			for(int j=1;j<=v;j++) { //맨 처음꺼랑
				for(int y:a[j]) { // 그거랑 연결되있는 간선들의 
					if(c[j]==c[y]) { //색깔비교
						qq=1; //같은게 있으면 No 출력해야되니까 qq=1로 일단 저장
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
