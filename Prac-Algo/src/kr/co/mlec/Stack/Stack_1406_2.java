package kr.co.mlec.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Stack_1406_2 {
	public static void main(String[] args) throws Exception{
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s= br.readLine();
		int test= Integer.parseInt(br.readLine());
		
		for(int i=0;i<s.length();i++) {
			left.add(s.charAt(i));
		}
		
		for(int i=0;i<test;i++) {
			String s1[] = br.readLine().split(" ");
			
			if(s1[0].equals("L")) {
				if(left.size()>0) {
					right.add(left.pop());
				}
			}else if(s1[0].equals("D")) {
				if(right.size()>0) {
					left.add(right.pop());
				}
			}else if(s1[0].equals("B")) {
				if(left.size()>0) {
					left.pop();
				}
			}else {
				left.add(s1[1].charAt(0));
			}
		}
		int size=left.size();
		for(int i=0;i<size;i++) {
			right.add(left.pop());
		}
		size=right.size();
		for(int i=0;i<size;i++) {
			System.out.print(right.pop());
		}
	}
}
