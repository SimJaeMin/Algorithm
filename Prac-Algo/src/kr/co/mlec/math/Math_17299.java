package kr.co.mlec.math;

import java.util.Scanner;
import java.util.Stack;

public class Math_17299 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int f[] = new int[1000001]; //각 숫자가 몇번들어갔는지
		int a[] = new int[1000001]; //수열
		int a1[] = new int[1000001]; //수열의 오등큰수를 저장하기위한 배열
		
		for(int i=1;i<=n;i++) {
			int n1=sc.nextInt();
			a[i]=n1; // 수열에 저장하고
			f[n1]++; // 그 수가 나온 인덱스를 증가해서 몇번 나왔는지 확인
		}
		
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> s1 = new Stack<Integer>();
		s.push(a[1]); // 값용 
		s1.push(1); //인덱스용 
		
		//인덱스랑 값을 나눈 이유는
		//값을 넣어야 지금 나온값이 이전에 나온 값들보다 큰건지 작은건지 알수 있고
		//큰건지 작은건지를 판단하면 그 인덱스에 저장을해줘야하기때문에 나눠줌
		for(int i=2;i<=n;i++) {
			
			while(!s.isEmpty() && f[s.peek()] < f[a[i]]) { // 값을 저장한 배열에서 값을 꺼내고 그 떄 나온값이 지금 비교하는것보다 적게 나왔다면
				a1[s1.peek()]=a[i]; // 오등큰수를 구한거기 때문에 저장
				s.pop();// 그 다음값을 비교해주기위해
				s1.pop(); // 그 당므 인덱스
			}
			s.push(a[i]);
			s1.push(i);
		}
			
		while(!s1.isEmpty()) {
			a1[s1.pop()]=-1; // 스택에 남아있는 인덱스는 오등큰수가 없는 값들임
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			sb.append(a1[i]+ " ");
		}
		System.out.println(sb);
	}
}
