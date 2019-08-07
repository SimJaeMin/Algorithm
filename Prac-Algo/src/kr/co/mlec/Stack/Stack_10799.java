package kr.co.mlec.Stack;

import java.util.Scanner;
import java.util.Stack;

//문제명 : 쇠막대기
//문제번호 : 10799
public class Stack_10799 {
	public static void main(String[] args) {
	
	
	// ( 가 나오면 stack 의 사이즈를 증가 시키고 push, 
	// ) 가 나오면 가장 마지막에 나온 ( 인덱스와 비교해서 인접하면 stack의  pop을 하나해주고 stackd의 사이즈 만큼 증가
	// ) 가 나왔는데 인접한게 아니면 막대기가 끝나는 것이고 그러면 앞 부분이 짤려있으니까 +1 을 해준다.
	Stack<Integer> s = new Stack<Integer>(); // ( 가 나오면 푸쉬 ) 가 나오면 pop을 해준다.
	// integer로 해준이유는 마지막 ( index를 확인하기위해서이다
	int jud=0; // 마지막 ( 를 저장하기위해
	char a; //막대기를 하나씩 읽기위해
	int sum=0 ; //최종 막대기 수를 저장하기위해
	Scanner sc= new Scanner(System.in);
	String stick=sc.next(); //막대기 입력
	int size=stick.length(); //막대기의 사이즈를 구한다
	
	for( int i=0;i<size;i++) {
		a=stick.charAt(i); // 첫번째 원소부터 읽어보기 시작해서
		
		if(a=='(') {
			s.push(i); // ( 면 push 를해주고 
		}else {
			jud=s.pop(); // ) 면 pop을 해준후 
			if(jud+1==i) { // 인접한 () 인지 판단한후 
				sum=sum+s.size(); // 인접하다면 size 만큼
			}else { // 인접하지 않다면 +1 (끝나는 막대기니까 남은거 처리)
				sum=sum+1;
			}
		}
	}
	System.out.println(sum);
	}
}
