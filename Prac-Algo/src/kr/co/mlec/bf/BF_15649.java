package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_15649 {
	static boolean check[] = new boolean[10];
	static int a[];

	
	//재귀가 중요하다
	//하나의 상황에서 그 때 상황에서 모든 경우를 진행할수있음
	
	public static void go(int n, int m, int len) { //재귀함수 , 지속적으로 다음 수를 찾을 수있다. dfs 할때 다음 위치를 찾은 것처럼

		if (len == m) { // 길이가 입력받은 m자리 와 같아진다면 출력

				for (int j = 0; j < m; j++) {
					System.out.print(a[j] + " ");
				}
				System.out.println();
			return; // 출력하고 그 떄의 함수는 끝나는 거니까 return 
		}

		for (int i = 1; i <= n; i++) { //수열을 만들 때 1 부터 시작  , 1부터 n 까지 갈 수 있고
			if (check[i]) { // 중복이 안되니까 만약에 방문한 숫자면 넘어가주고 
				continue;
			}
			check[i] = true; // 방문이 안되서 이제 하는 거면 true로 만들고 주고
			a[len] = i; // 그 때 의 수를 len ( index ) 에 맞게 저장 해준다.
			go(n, m, len + 1); // 그리고 m 자리 수의 수열을 구하는거니까 그 다음 수를 구하기 위해 재귀함수를 돌리는데
							   // index 가 다음 껄 가르켜야 하니까 +1을 해준 수를 넘겨준다.
			check[i] = false; // 하나의 수열을 찾으면 다음 거를 위해 true 였던 걸 false 로 다시 바꿔준다.

		}

		return;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new int[m];
	
		go(n, m, 0);
	}
}
