package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제명 : 단어 길이 재기
//문제번호 :2743
public class String_2743 {
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s= br.readLine();

	System.out.println(s.length());
	
}
}
