package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BF_1748 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		long count=0; // 총합
		int a=1; // 자릿수 1 ~ 9 => 1자리 , 10 ~ 99 => 2자리 ..... 
		
		for(int i=1; i <= num ; i = i * 10 ) {
			int end= i * 10 - 1 ; //각 자리의 마지막 숫자, 9 , 99 , 999 , 9999 ......
			if( end > num ) { //마지막 숫자가 입력받은값보다 크다면 입력된 값이 마지막 값이된다.
				end = num;
			}
			count = count + (long)(end - i + 1) * a; // ( 9 - 1 + 1 ) ==> 양쪽다 => =< 니까 +1을 해줘야함 그래야 갯수가맞음
			// 10 <= x <= 99 의 갯수는  = > 99 - 10 + 1임
			a++;
		}
		System.out.println(count);
	}
}
