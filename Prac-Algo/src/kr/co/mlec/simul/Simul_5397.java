package kr.co.mlec.simul;

import java.util.Scanner;
import java.util.Stack;

public class Simul_5397 {
	//커서를 기준으로 왼쪽, 오른쪽으로 나누어서 해결하기
	//커서를 <로 갈려면 왼쪽 스택이 사이즈가 0보다 커야되고 만약 크다면 왼쪽 스택의 탑을 오른쪽 스택에 넣어준다.
	// >는 반대로
	//-는 커서의 왼쪽걸 하나 지워주는건데 이때도 사이즈 체크해주기
	// 마지막 출력은 제일 먼저들어온거는 왼쪽 첫번째니까 이걸 역순으로 바꿔주기위해 다 오른쪽으로 넘겨주고 오른쪽걸 pop() 해주기
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			StringBuilder sb = new StringBuilder();
			String s = sc.next();
			Stack<Character> left = new Stack<Character>();
			Stack<Character> right = new Stack<Character>();
			for (int i1 = 0; i1 < s.length(); i1++) {
				char c = s.charAt(i1);

				if (c == '<') {
					if (left.size() > 0)
						right.add(left.pop());
				} else if (c == '>') {
					if (right.size() > 0)
						left.add(right.pop());
				} else if (c == '-') {
					if (left.size() > 0)
						left.pop();
				} else {
					left.add(c);
				}
			}

			while (!left.isEmpty()) {
				right.add(left.pop());
			}

			while (!right.isEmpty()) {
				sb.append(right.pop()); //출력이 조금 많다 싶으면 이걸 써야될듯
			}
			System.out.println(sb);
		}
	}
}
