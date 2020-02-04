package kr.co.mlec.math;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class Math_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> t = new TreeSet<Integer>();
		
		Vector<Integer> v= new Vector<Integer>();

		for (int i = 0; i < 10; i++) {
			v.add(sc.nextInt());
		}
		int size1=v.size();
		for (int i = 0; i < 10; i++) {
			v.add(v.get(i) % 42);
		}
		for(int i=0;i<size1;i++) {
			v.remove(0);
		}
		
		HashSet<Integer> v1 = new HashSet<Integer>(v);
		
		v=new Vector<Integer>(v1);
		
		System.out.println( "v. size : " + v.size());
		
		
		for(int i=0;i<v.size();i++) {
			System.out.println(i + ": "  + v.get(i));
		}
		
	}
}
