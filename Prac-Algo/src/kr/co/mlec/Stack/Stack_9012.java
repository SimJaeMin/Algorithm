package kr.co.mlec.Stack;

import java.util.Scanner;
import java.util.Stack;

//문제명 : 괄호
//문제번호 :9012
public class Stack_9012 {
	public static void main(String[] args) {
		int num=0; // ( 의 개수를 알기위해
		Scanner sc = new Scanner(System.in); //몇번 반복 할지를 입력받기 위해선언
		int cnt = sc.nextInt();
		String ps; // 괄호문자열을 입력받기위해 선언
		for (int i = 0; i < cnt; i++) { //몇번 반복 할것인가
			ps = sc.next(); // 괄호문자열 입력받고
			int size = ps.length(); //괄호문자열의 크기만큼 하기위해
			num=0; //한번 끝나면 num을 다시 0으로 초기화
			for (int j = 0; j < size; j++) {
				char a = ps.charAt(j); // 첫번째 원소부터 찾아서
	
				if(a=='(') { // ( 가 나오면 num을 증가
					num=num+1;
					
				}else {
					num=num-1; // ) 가나오면 num 감소
				}
				
				if(num<0) { // num 이 마이너스가 된다는 것은 ) 의 수가 앞에나온 ( 수보다 많거나, 첫번째로 나온것이기에 ps가아님
					System.out.println("NO");
					break;
				}
			}
			
			if(num==0) { // num 이 0이 라는것은 (와 )가 숫자의 수가 같다는 것이기에 yes
				System.out.println("YES");
			}else if(num>0){ //0보다 크다는 것은 ) 의 수가 (보다 부족하기에 NO
				System.out.println("NO"); 
			}
		}

	}
}
