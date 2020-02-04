package kr.co.mlec.Stack;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Stack_1874 {
	static Vector<Integer> v;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int last = 1; // 넣기시작해야할번호
		v = new Vector<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder(); //출력할 때 시간초과 날수도있어서

		for (int i = 0; i < n; i++) { // 총 n자리수의 수열을 입력받음
			int num = sc.nextInt(); // 수열의 n번째 자리수
			if (last <= num) { //last는 초기 1 , 만약 이 수보다 입력받은 n번째 자리수가 크면  
				for (int a = last; a <= num; a++) { // 그만큼 push를 해준다.
					stack.push(a); 
					sb.append("+\n");
				}
				stack.pop(); // push 해주고 마지막꺼는 수열을 만들려면 pop 을해야되니까 하나 해준다.
				sb.append("-\n");
				last=num+1; //다음수, 이전까지는 입력받아서 이거보다 작은값이 들어오면 pop을 해야됨
			} else {
				int c = stack.pop(); // 만약에 기존에 입력받은거보다 작은게 들어옴 , 그게 그 다음 수열의 자리가 되는거니까 딱 한번만 pop을 해주면됨
				if (c == num) { //pop 해준게 만약 입력받은 수랑 같으면 수열을 이어나갈수있음
					sb.append("-\n");
				} else {
					System.out.println("NO"); //다르면 바로 no
					return;
				}
			}
		}


		System.out.println(sb);
	}
}
