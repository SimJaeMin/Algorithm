package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Graph_13023 {
	static ArrayList<Integer>[] arr;
	static int count=0;
	static boolean check[];
	
	public static void dfs(int num) {
		check[num]=true; //방문한거는 true
		
		for(int i=0;i<arr[num].size();i++) { //방문 한것중에서 다음 방문할 수있는걸찾고
			int x=arr[num].get(i);  // 여러개 중 하나를 가져오고
			
			if(check[x]==true) { // 그게 방문했던거면 다음걸로
				continue;
			}
			
			if(check[x]==false) { // 방문 안했던거면 
				count++; // count를 증가하고
				
				if(count==4) {
					System.out.println(1);
					System.exit(0);
				}
				dfs(x); // 그걸로 다음 방문할걸 찾는다.
			}
		}
		if(count >0) { // 한번에 깊이가 4인걸 찾아야되는데 다음 노드에서 갈데가없으면 count를 - 해준다. 그런데 0 보다작아지면 안되니까 0 0 보다 클때만
		count--;
		}
		check[num]=false;// 다시 백으로 가면 방문 안할걸로 바꿔줘야함
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = (ArrayList<Integer>[]) new ArrayList[n]; // ArrayList형 배열을 만듬 , 배열의 크기가 n인 ArrayList<Integer>형 배열임
		check = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i]= new ArrayList<Integer>(); // ArrayList형 배열이니까 배열의 요소들이 ArrayList임 이거를 각각 생성해 줘야함
		}
		
		for(int i=0;i<m;i++) {
			int first=sc.nextInt(); // 방향이 없는 그래프니까 양쪽다 추가해주기
			int second= sc.nextInt();
			arr[first].add(second);
			arr[second].add(first);
		}
		
		for(int i=0;i<n;i++) { // 정렬
			Collections.sort(arr[i]);
		}
		
		for(int i=0;i<n;i++) {
			dfs(i); // dfs의 시작을 0 번부터 n 번까지 다 해주기위해서
		}
		
		System.out.println(0);
	}
}
