package kr.co.mlec.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair1{
	int x;
	int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	Pair1(int x, int y){
		this.x=x;
		this.y=y;
	}
	public Pair1() {
		// TODO Auto-generated constructor stub
	};
}

public class Graph_2178 {
	static int data[][];
	static int map[][]; //현재 (i,j) 가 시작에서 몇번째 출발한건지 저장하기위해
	//이걸 사용해서 여기서 이동할 수 있는 다음 요소는 이 값의 +1 만큼 이동한거임
	static boolean check[][];
	static int x[]= {-1 ,1 ,0 ,0};
	static int y[] = {0,0 ,-1,1};
	static Queue<Pair1> q;
	static int count=1;
	static int abc=0;
	
	public static void bfs(int n, int m,int dest1 , int dest2) {
		q = new LinkedList<Pair1>();
		Pair1 pa = new Pair1(n,m);
		q.add(pa);
		check[n][m]=true;
		map[n][m]=count; 
		
		while(!q.isEmpty()) {
			int one = q.peek().getX();
			int two = q.poll().getY();
			
			for(int i=0;i<4;i++) {
				int nextX= one+ x[i];
				int nextY= two+ y[i];
				
				if(nextX>-1 && nextY>-1 && nextX<dest1 && nextY <dest2 && data[nextX][nextY]==1 && check[nextX][nextY]==false) {				
					Pair1 p = new Pair1(nextX,nextY);
					q.add(p);
					check[nextX][nextY]=true;
					map[nextX][nextY]=map[one][two]+1; //현재 위치에서 한번 더 움직인거니까
					abc=1;
				}
			}
			if(abc==1) { //만약에 아무것도 갈대가 없으면 
				count++;
				abc=0;
			}
			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		data = new int[n][m];
		check = new boolean[n][m];
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s = sc.next();
			for(int j=0;j<m;j++) {
				data[i][j]= s.charAt(j) - '0';
			}
		}
		
		bfs(0,0,n,m);
		System.out.println(map[n-1][m-1]);
	}
}
