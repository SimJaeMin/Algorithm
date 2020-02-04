package kr.co.mlec.simul;

import java.util.Scanner;
import java.util.Stack;

public class Simul_3048 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();

		String s = sc.next();
		
		for(int i=0;i<s.length();i++) {
			st.add(s.charAt(i));
		}
		
		for(int i=0;i<n1;i++) {
			sb.append(st.pop());
		}
		
		
		int time = sc.nextInt();
		
		
		for(int i=0;i<time;i++) {
			
		}
	}
}
