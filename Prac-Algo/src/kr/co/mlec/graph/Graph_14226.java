package kr.co.mlec.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair11{
	int first;
	int second;
	public Pair11(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
public class Graph_14226 {
	static int numScreen=0;
	static int numClip=0;
	static boolean check[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		Queue<Pair11> q = new LinkedList<Pair11>();
		q.add(new Pair11(1,0));// 초기에는 화면에 1개 , 클립에 0 개

		check=new boolean[1002][1002];
		check[1][0]=true; //이거는 방문한거
		boolean t=true;
		int num=0;
		while(!q.isEmpty() && t) {
			num++;
			int size= q.size();
			
			for(int i=0;i<size;i++) {
				Pair11 next = q.poll(); 
				numScreen=next.first; // 현재 화면에 있는 수
				numClip = next.second; // 현재 클립에있는 수
				
				if(numScreen <=1001 && numScreen>0) { // 현재 화면에 있는게 0보다 크고 1001 보다 작으면 화면에 있는걸 클립에 붙여넣기 할 수있음
					//그러면 클립에있는 수도 화면의 수랑 같아진다. 붙여넣기하면 기존에 같은거는 덮어쓰기가 되니까
					if(check[numScreen][numScreen]==false)
					q.add(new Pair11(numScreen,numScreen));
					check[numScreen][numScreen]=true;
				}
				
				if(numClip>0 && numScreen+numClip <=1001 ) { //s의 최대가 1000임 이걸 안넘을때 
					if(check[numScreen+numClip][numClip]==false) { // 클립에 있는걸 화면에 추가시키는거 이때의 수가 1001보다 작아야함
						q.add(new Pair11(numScreen+ numClip,numClip));
						check[numScreen+numClip][numClip]=true;
					}
				}
				
				if(numScreen>2) { // 화면에 0개가 되면 안되니까 2개 이상일때 1개를 빼줄수있음
					if(check[numScreen -1] [numClip]==false) {
						q.add(new Pair11(numScreen-1,numClip));
						check[numScreen-1][numClip]=true;
					}
				}
				
				if(numScreen==s) { //찾는수와 화면에 있는 이모티콘 수가 같으면 
					t=false;
					break;
				}
			}
		}
		
		System.out.println(num-1);
		
	}
}
