package kr.co.mlec.math;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Math_17298 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		StringBuilder sb= new StringBuilder();
		
		int[] v = new int[1000001];
		int[] v1 = new int[1000001];
		for (int i = 0; i < num; i++) {
			v[i]=sc.nextInt();
		}

		Stack<Integer> s = new Stack<Integer>();
		s.push(0); // 처음 인덱스를 저장  인덱스를 저장하는 이유는 그 인덱스 번째보다 큰 수중 가장 왼쪽에 있는 수를 그 인덱스에 다시 저장해야되니까
		
		for (int i = 1; i < num; i++) {

			while (!s.isEmpty() && v[s.peek()] < v[i]) { // 스택이 비어있지않고 스택의 top에 있는 인덱스를 이용해 v[i]와 비교해서 v[i]가 크면 자기보다 큰 수중 가장 먼저나온거니까
				v1[s.peek()] = v[i]; // 그 수를 v1에 그 인덱스에 저장
				s.pop();
			}
			
			s.add(i);
		}
		
		while(!s.isEmpty()) {
			v1[s.pop()]=-1; // 스택에 남아있는 인덱스는 자기보다 큰수가 오른쪽에 없는거니까 -1을해준다.
		}
		
		for(int i=0;i<num;i++) {
			sb.append(v1[i] + " "); //출력이 많으면 시간초과가 나서 sb로
		}
		System.out.println(sb);
	}
}
