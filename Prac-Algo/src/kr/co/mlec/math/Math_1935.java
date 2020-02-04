package kr.co.mlec.math;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

public class Math_1935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Double> s = new Stack<Double>();
		int num=sc.nextInt();
		String s1= sc.next();
		double arr[]= new double[num];
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0; i<s1.length();i++) {
			char c= s1.charAt(i);
			
			if(c=='+') {
				double a=s.pop();
				double b=s.pop();
				s.push(b+a);
			}else if(c=='-') {
				double a=s.pop();
				double b=s.pop();
				s.push(b-a);
			}else if(c=='*') {
				double a=s.pop();
				double b=s.pop();
				s.push(b*a);
			}else if(c=='/'){
				double a=s.pop();
				double b=s.pop();
				s.push(b/a);
			}else {
				s.push(arr[c-'A']);
			}
		}
		System.out.format("%.2f", s.pop());
	}
}
