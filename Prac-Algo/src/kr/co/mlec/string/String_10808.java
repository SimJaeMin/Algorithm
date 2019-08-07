package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제 이름 :알파벳 개수

//문제 번호 : 10808 
public class String_10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine(); //초기에 한줄을 입력받는다.
		int[] check=new int[26]; // 각각의 문자 하나당 몇개인지 판단하기위해 배열선언
		int size= s.length(); 
		while(size>0) { // size가 0보다 클때만
			check[s.charAt(size-1)-'a']++; // 아스키 코드값을이용해서 'a' = 97이니까 이걸이용해서
			size--;
		}

		for(int i=0;i<25;i++) {
			System.out.print(check[i] + " ");
		}
		System.out.print(check[25]);
		System.out.println();
		
		
		
	}
}
