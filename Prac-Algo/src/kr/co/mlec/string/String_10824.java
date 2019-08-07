package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제명 : 네 수 	
public class String_10824 {
	public static void main(String[] args) throws IOException{
		String s,s1,s2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine();
		String[] ar = s.split(" ");
		s1=ar[0]+ar[1];
		s2=ar[2]+ar[3];
		
		System.out.println(Long.parseLong(s1)+Long.parseLong(s2));
		
	}
}
