package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BF_1107 {
	static boolean n[]; // 번호번튼 0~9

	static boolean check(int num) { // num 은 가볼려는채널
		int temp;
		if (num == 0) { // 처음 0으로 가면
			if (n[num]==true) { // ture 가되면 고장난거니까 갈수 없는채널임
				return false; // false 리턴
			} else { // ture가 아니면 갈수있는 채널임
				return true; // ture 리턴
			}
		}

		while (num > 0) { // 채널의 번호 다 검사해봐야하니까
			temp = num % 10; // 한자리씩 검사
			num = num / 10;
			if (n[temp]==true) { // 그 자리가 true면 고장난거니까 하나라도 고장나면 false 리턴
				return false;
			}
		}
		return true; // 위에 다 통과하면 true 리턴
	}
	// 먼저 채널로 이동한다음 그 다음 +, - 중 하나만 연속해서 눌러야 최소를 구할 수 있음
	// 이유는 중복이 없어야되니까
	// 브루트포스 -> 한번씩 다해보자임
	// 그래서 맨처음에 +나 -로만 가는경우(최악) 모든 번호가 고장나서 이경우를 기준으로 삼고시작
	// 1채널부터 10000000까지 가서 그 후 +,- 를 중 하나로만 가고싶은채널로가는데 그때 최소값을구하면된다.
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int changeNum = sc.nextInt(); // 바꿀 채널번호
		int errCount = sc.nextInt(); // 고장난 번호 갯수
		int min; // 최소값
		
		if (errCount > 0) { // 고장난 번호 갯수가 1개 이상이면
			n = new boolean[10];
			for(int i=0;i<errCount;i++) {
				n[sc.nextInt()]=true;
			}
		}else {
			n= new boolean[10]; //없으면 그냥 생성만해주기
		}

		
		if (changeNum == 100) { // 만약 100으로 갈려고하면
			System.out.println(0); // 원래 100이니까 움직일필요 x
			return;
		}
		min = changeNum - 100; // 모든 번호가 고장났을때 +,-로만 가는경우
		if (min < 0) { // 0 보다 작으면 다시 양수로 해주기위해
			min = -min;
		}

		for (int i = 0; i <= 1000000; i++) { // 0번 채널부터 1000000까지 한번씩 채널로 간 다음 거기서 +,-를 연속으로 누르는 경우를 다 해본다
			int count = 0; // +,- 제외 리모컨 번호를 누르는 갯수
			
			if (check(i)) { // 일단 채널이 갈수있는지 확인
				int temp = i; // 몇개의 번호를 눌를지
			
				if (temp == 0) { // 0 채널로 가면 0 한번이니까 count는 1
					count++;
				} else {
					while (temp > 0) { // 0이 아니면 10으로 나누어서 몇자리 수인지 파악하고 그 수만큼 cout 증가 (번호누르는 갯수임)
						count++;
						temp = temp / 10;
					}
				}

				if (i < changeNum) { // i가 갈려는 채널보다 작으면
					int a = changeNum - i + count; // 빼주고 + 채널로 가기위해 누른 숫자 더해주기
					if (min > a) { // 그 때 그 수가 min 보다 작으면 최소값이되는거임
						min = a;
					}
				} else if (i == changeNum) { // 같을때는 count만 비교
					if (min > count) {
						min = count;
						break;
					}
				} else {
					int a = i - changeNum + count; // i가 크면 i에서 뺴주기
					if (min > a) {
						min = a;
					}
				}

			}
		}
		System.out.println(min);

	}
}
