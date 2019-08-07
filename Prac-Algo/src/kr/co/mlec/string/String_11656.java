package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//문제명 : 접미사 배열
public class String_11656 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s =br.readLine();
		int size=s.length();
		String[] sa = new String[size];
		for(int i=0;i<size;i++) {
			sa[i]=s.substring(i,size);	//i번째부터 size 까지 부분문자열을 추출한다.
		}
		Arrays.parallelSort(sa);  //정렬해준다
		
		for(int i=0;i<size;i++) {
			System.out.println(sa[i]);
		}
	}
}
