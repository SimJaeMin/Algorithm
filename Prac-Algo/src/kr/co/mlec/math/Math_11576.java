package kr.co.mlec.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//������ Base Conversion
public class Math_11576 {
	public static void main(String[] args) throws Exception{
		// a������ b�������� --> a������ 10������ 10������ b��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]= br.readLine().split(" ");
		int a=Integer.parseInt(s[0]);
		int b=Integer.parseInt(s[1]);
		
		int test= Integer.parseInt(br.readLine());
		s=br.readLine().split(" ");
		int sum=0;
		
		for(int i=0;i<test;i++) {
			sum=sum*a+Integer.parseInt(s[i]);
		}
		
		
		StringBuilder sb=new StringBuilder();
		while(sum>0) {
			int c=sum%b;
			sb.append(c);
			sum=sum/b;
		}
		for(int i=sb.length()-1;i>=0;i--) {
			System.out.print(sb.charAt(i)+ " ");
		}
		System.out.println();
	}
}
