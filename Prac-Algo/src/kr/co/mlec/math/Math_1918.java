package kr.co.mlec.math;

import java.util.Scanner;
import java.util.Stack;

public class Math_1918 {
	static Stack<Character> st;

	public static void check(char c) {

		if (c == '+' || c == '-') {
			while (st.size() > 0 && st.peek() != '(') {
					System.out.print(st.pop());
			}
			st.push(c);
		}
		
		if(c=='*' || c=='/') {
			while(st.size()>0 && (st.peek()=='*' || st.peek()=='/')) {
				System.out.print(st.pop());
			}
			st.push(c);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		st = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '+') {check(c);}
			else if (c == '-') { check(c);}
			else if (c == '*') {check(c);}
			else if (c == '/') {check(c);}
			else if (c == '(') {st.push('(');}
			else if (c == ')') {
				boolean t = true;
				while (t) {
					char b = st.pop();
					if (b == '(') {
						t = false;
					} else {
						System.out.print(b);
						continue;
					}
				}
			} else {
				System.out.print(c);
			}
		}
		
		while (!st.isEmpty()) {
			System.out.print(st.pop());
		}
	}
}
