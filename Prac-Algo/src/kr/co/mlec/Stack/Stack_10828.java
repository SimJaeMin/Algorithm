package kr.co.mlec.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Stack_10828 {
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		stack = new Stack<Integer>();
		for (int i = 0; i < count; i++) {
			String s[] = br.readLine().split(" ");

			if (s[0].equals("push")) {
				stack.push(Integer.parseInt(s[1]));
			} else if (s[0].equals("pop")) {
				if(stack.size()>0) {
				System.out.println(stack.pop());
				}else {
					System.out.println(-1);
				}
			} else if (s[0].equals("top")) {
				if(stack.size()>0) {
				System.out.println(stack.peek());
				}else {
					System.out.println(-1);
				}
			} else if (s[0].equals("size")) {
				System.out.println(stack.size());
			} else if (s[0].equals("empty")) {
				if (stack.empty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		}
	}
}