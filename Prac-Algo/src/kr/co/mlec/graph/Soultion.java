package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Vector<Integer> a = new Vector<Integer>();
		
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			a.add(num);
		}
		
		Collections.sort(a);
		
		for(int i=0;i<n;i++) {
			System.out.println(a.get(i));
		}
	}
}
