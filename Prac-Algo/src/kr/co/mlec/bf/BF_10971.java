package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_10971 {
	static int a[][];
	static boolean check[];
	static int min = 0;

	public static void go(int n, int start1, int start, int sum , int index) { // n 몇번 이동할지 결정 index와 비교해서 같으면 모든 여행지를 방문함
			if(n == index) { // 그때의 최소값을 구해줌
				if(sum<min || min == 0 ) {
					min=sum;
				}
				return;
			}
			// start1 은 맨 처음 시작한 여행지는 아직 방문상태가 아니고 마지막에 방문해야함
			// 그래서 맨 처음 시작한 여행지를 저장하고 있기위해 선언
			
			//start 는 그 다음 번째
			//예를 들어 1번쨰에서 2번째 여행지로 갔을때 start는 2가 되고 2에서 다른 여행지(1,3,4) 를 갈수있는지 ( 0 인지 아닌지 판단하기위해 넘겨줌)
			for(int j=0;j<n;j++) {
				if(check[j] == true || a[start][j] == 0) { // 방문했거나 , 방문하지 못하는 곳이라면 다음 장소
					continue;
				} 
				
				if(j==start1) { // 만약 첫번째 시작 장소를 갈려고하는데 
					if(index+1!=n) { //그게 마지막이 아니라면 방문 못한다.
						continue;
					}
				}
				
				check[j]=true; //방문한곳은 true로 체크
				go(n,start1,j,sum+a[start][j],index+1); // j를 넘겨주는건 다음 방문지 선택용
				check[j]=false;
			}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		a = new int[n][n];
		check = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) { // 1번부터 시작할 수도 있고 2번부터 시작 3번부터 시작할 수도 있어서 for 문을 사용
			go(n,i, i, 0, 0); 
		}
		System.out.println(min);
	}
}
