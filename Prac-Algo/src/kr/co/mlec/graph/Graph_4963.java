package kr.co.mlec.graph;

import java.util.Scanner;

public class Graph_4963 {
	static int data[][];
	static boolean check[][];
	static int x[]= {-1,1,0,0,-1,-1,1,1};
	static int y[]= {0,0,-1,1,-1,1,-1,1};
	static int count=0;
	
	public static void dfs(int i,int j,int first, int second) {
		check[i][j]=true;
		
		for(int a=0;a<8;a++) {
			int nextX = i+x[a];
			int nextY = j+y[a];
			
			if(nextX > -1 && nextY > -1 && nextX <first && nextY < second && check[nextX][nextY] == false
					 && data[nextX][nextY]==1) {
				dfs(nextX,nextY,first,second);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean tf = true;
	
		while(tf) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			if(first==0 && second ==0) {
				tf=false;
				break;
			}
			
			data = new int[second][first];
			check = new boolean[second][first];
			
			for(int i=0;i<second;i++) {
				for(int j=0;j<first;j++) {
					data[i][j]=sc.nextInt();
				}	
			}
			
			for(int i=0;i<second;i++) {
				for(int j=0;j<first;j++) {
					if(check[i][j]==false && data[i][j]==1) {
					
						dfs(i,j,second,first);
						
						count++;
					}
				}
			}
			System.out.println(count);
			count=0;
		}		
	}
}
