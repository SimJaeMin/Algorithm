package kr.co.mlec.math;

import java.util.Scanner;

//문제명 팩토리얼 0의 개수
public class Math_1676 {
	public static void main(String[] args) {
		//팩토리얼 에서 0의 개수를 얻을려면 2와 5가 몇개 나오는지가 중요
		//2*5 =10 이 되기 때문 2보다 5가 적게나오기때문에 5의 개수를 알아야함
		//소인수 분해 했을때 2와 5의 갯수임
		//5보다 작을시에는 0이없음
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int cnt=0;
		for(int i=5;i<=num;i=i*5) {
			cnt=cnt+num/i;
		}
		System.out.println(cnt);
	}
}
