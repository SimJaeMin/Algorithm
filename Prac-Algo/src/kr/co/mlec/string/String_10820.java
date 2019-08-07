package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//문자열 분석
//10820
public class String_10820 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int []check= new int[4];
		
			while(sc.hasNextLine()) {
			String s= sc.nextLine(); // 문자열을 입력받는다.
			int size=s.length(); // 문자열의 사이즈 만큼 반복
			for(int j=0;j<size;j++) {
				char a=s.charAt(j); // 첫번째 원소부터 하나식 뽑은다음
				if(a==32) { //아스키 코그닶을 이용해서 대,소,숫자, 공백을 구분한다.
					check[0]++;
				}else if(a>=65 && a<97) {
					check[1]++;
				}else if(a>=97) {
					check[2]++;
				}else if(a>=48 && a<58) {
					check[3]++;
				}
			}
			System.out.println(check[2]+" "+ check[1]+" "+check[3]+ " "+ check[0]);
			check[0]=0;
			check[1]=0;
			check[2]=0;
			check[3]=0;
			}
		}	
	}