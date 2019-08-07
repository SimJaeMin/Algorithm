package kr.co.mlec.Stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//문제명 : 에디터
//문제번호 1406
public class Stack_1406 {
	public static void main(String[] args) throws IOException {
		//초기에 입력받을 수 있는 문자열 길이 100,000
		//명령어 입력받는 횟수 500,000
		//합쳐서 600,000 인데 배열로 문제를 풀게되면 
		// (문제의 크기 N ) * (한 문제당 걸리는 최대 크기 N) 배열은 삽입 삭제시 시간이 N만큼 걸리기때문
		// O(N의 제곱) 이 되는데 ;시간제한 때매 배열을 못쓰고 STACK 을 2개로 써서 해야한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> left = new Stack<Character>(); //커서를 기준으로 왼쪽
		Stack<Character> right = new Stack<Character>(); //커서를 기준으로 오른족
		String init = br.readLine(); //초기 문자열입력
		int cnt=Integer.parseInt(br.readLine());

		int size=init.length();
		
		for(int i=0; i < size ; i++) { // 초기에 커서는 제일 오른쪽에 있으니
			left.push(init.charAt(i)); // 초기 데이터는 왼쪽 Stack에 
		}
		
		for(int i=0;i<cnt;i++) { // 카운트 만큼 입력을 받고
			String[] line=br.readLine().split(" ");
			if(line[0].charAt(0)=='L') { //커서가 왼쪽으로 가니까
				if(!left.empty()) // 왼쪽 stack이 있으면
				right.push(left.pop()); //하나를 꺼내서 오른쪽으로
			}
				else if(line[0].charAt(0)=='D') { //커서가 오른쪽으로 가니까
					if(!right.empty()) { //right stack 이 있으면
						left.push(right.pop()); //하나를 꺼내서 왼쪽으로
					}
				}else if(line[0].charAt(0)=='B') { //커서 왼쪽에 있는걸 삭제
					if(!left.empty()) { // left stack 이있으면
						left.pop(); //하나를그냥 꺼낸다
					}
				}else if(line[0].charAt(0)=='P') {// 삽입이면
					char add=line[1].charAt(0); //공백하나 다음 삽입할 문자를 입력하니까 2번째
					left.push(add); // 왼쪽에 추가하니까 left
				}
				
			}
		size=left.size();
		for(int i=0;i<size;i++) { //출력하기 위해서
			right.push(left.pop()); //왼쪽에 있는거는 순서가 반대로임 이걸 다시 뒤집기 위해서 오른쪽으로 다 옮긴다.
		}
		StringBuilder sb=new StringBuilder(); //String을 효율적으로 쓰기위해
		while(!right.empty()) {
			sb.append(right.pop()); // append를 이용해 이어준다.
		}
		System.out.println(sb);
	}
}
