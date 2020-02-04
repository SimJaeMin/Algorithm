package kr.co.mlec.bf;

import java.util.Scanner;
import java.util.Vector;

public class BF_14888 {
	static Vector<Integer> v;
	static Vector<Integer> v1;
	static boolean check[];
	static int min, max;
	static int count = 0;
	static int num[];

	public static void bf(int n, int len, int vsize, int sum) {

		if (len == n) { // 만약 len과 n이 같다면 모든 연산자를 삽입한 경우니까 그때의 값 min, max와 비교
			if (count == 0) {
				min = sum;
				max = sum;
				count = 1;
			} else {

				if (min > sum) {
					min = sum;
				}

				if (max < sum) {
					max = sum;
				}
			}
			return;
		}

		for (int i = 0; i < vsize; i++) { // 모든 연사자를 사용하기위해

			if (check[i] == true) { //한번 사용한 연산자는 그 순열에 다시 사용을 못하게 하기위해
				continue;
			}
			check[i] = true; //한번 사용한 연산자 체크

			if (v.get(i) == 0) { // 만약 그 연산자가 + 라면
				bf(n, len + 1, vsize, sum + num[len]);
			} else if (v.get(i) == 1) { //-라면
				bf(n, len + 1, vsize, sum - num[len]);

			} else if (v.get(i) == 2) {//* 라면
				bf(n, len + 1, vsize, sum * num[len]);

			} else { // /라면
				bf(n, len + 1, vsize, sum / num[len]);
			}
			check[i] = false; //한번의 순열에서 끝까지갔다가 리턴해서 오면 그거는 이제 다음 순열에서는 사용가능해저야되니까 사용안한 false로 바궈줌
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 입력 받을 숫자 , 숫자의 순서는 바꿀수 없다.
		num = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt(); // 숫자입력
		}

		v = new Vector<Integer>(); //순열을 사용하기위해 입력된 연산자를 1자로 편다.

		for (int i = 0; i < 4; i++) { // +,-,*,/ 가 각각 몇개씩인지
			int n1 = sc.nextInt(); // 몇개인지 입력
			for (int j = 0; j < n1; j++) {
				v.add(i); // 그 수만큼 + 는 0 , - 는 1 ... 이렇게 갯수를 입력한다.
			}
		}
		check = new boolean[v.size()]; // 한번 사용한 연산자는 사용할수 없으니 사용했다고 체크해주기 위한 배열
		bf(n, 1, v.size(), num[0]);//n len이 1부터가는이유는 첫번째 수를 처음에 넘겨주니까 그리고 v.size() 만큼 순열을 돌면 모든 경우의수를 다 할 수 있음
		System.out.println(max);
		System.out.println(min);
	}
}
