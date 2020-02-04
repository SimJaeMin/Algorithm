package kr.co.mlec.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//진법 변환
public class Math_2745 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		String num=s[0];
		int b=Integer.parseInt(s[1]);
		int sum=0;
		int size=num.length();
		
		for(int i=0;i<size;i++) {
			char c=num.charAt(i);
			
			if(c>='A' && c<='Z') {
				sum=sum*b+(int)(c-55); // 맨앞의 숫자는 b의 n승을 해줘야되니까 size 만큼 올때 b를 게속 곱해준다.
			}else {
				sum=sum*b+(int)(c-'0'); //문자를 숫자로 만들려면 -'0' 문자로 할려면 + '0' 0~9 를
			}
		}
		System.out.println(sum);
	}
}
