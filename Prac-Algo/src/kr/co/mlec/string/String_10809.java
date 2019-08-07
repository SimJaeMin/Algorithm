package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//문제명 : 알파벳찾기
//번호 : 10809
public class String_10809 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[] check = new int[26];
	for(int i=0;i<26;i++) {
		check[i]=-1; // 초기 배열은 아무것도 없으니까 -1로 시작
	}
	String s= br.readLine();
	int size=s.length();
	for(int i=0;i<size;i++) {
		if(check[s.charAt(i)-'a']==-1) { //-1이라는것은 아직 한번도 안나왔다는것
			check[s.charAt(i)-'a']=i; // 그떄 그 값을  index로 바꿔준다.
		}
	}
	
	for(int i=0;i<26;i++) {
	System.out.print(check[i] + " ");
	}	
	System.out.println();
}
}
