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
			System.out.println(0); //처음부터 같은곳에 있으면 0번움직이고
			System.out.println(n); // 이동경로는 n 하나
			return;
		}
		q.add(n); //초기 시작장소 삽입
		check[n]=true;
		boolean t=true;
		while(!q.isEmpty() && t) {
			
			int size = q.size(); 
			
			for(int i=0;i<size;i++) {
				int next =q.poll();
				
				if(next -1 > -1 && check[next-1]==false) {
					q.add(next-1);
					check[next-1]=true; //방문했으면 방문했다고 체크하고
					prev[next-1]=next; //이거 방문하기전에는 어떤걸 방문햇는지 저장
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
					v.add(next); // 마지막에 방문한거니까 추가하고
					int a= prev[next]; // 마지막에 방문하거 바로 전에 방문했던걸 찾은다음
					while(a!=n) {// 그게 처음 시작장소가 나올때까지
						v.add(a); //계속찾아주기
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
