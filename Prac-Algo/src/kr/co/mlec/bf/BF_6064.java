package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_6064 {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t>0) {
			int m= sc.nextInt(); // x가 갈수있는 최대 수 
			int n= sc.nextInt(); // y가 갈수있는 최대 수
			int x= sc.nextInt(); // 찾고싶은 값 x
			int y= sc.nextInt(); // 찾고싶은 값 y
			int num=0; // 만약에 찾는 값이 없으면 
			x= x-1; // -1 해주는 이유는 모듈러 연산으로 찾을건데 x가 12, n이 12이면 0이나와서 0값을 해결하기위해
			y= y-1;
			if(m<=n) {
				for(int i=x,j=1 ; j<=n; j++, i=i+m) { // x의 최대값이 작으면 x값 기준으로 y값을 찾을려고한다.
						//맨 처음 시작(1~m일 때 한바퀴도 안돈 맨 처음 x) x를 초기값 i로 놓고
						// j=1 몇번 반복해야할지 정할때 모듈러 연산이니까 최대 n 번 안에 찾아야된다. n을찾는거니까
						// j는 +1 , i는 m 만큼 더해줘서 그 다음번때의 n을 찾는다
						if(y== (i%n) ) { //n을 찾는 과정 처음 i에 n으로 나누어주면 나온 값이 y이면 그값, 그 이후로는 어차피 x값은 고정이니까
							// 계속해서 x의 주기인 m을 더해주고 그 값을 n으로 나누었을떄의 값이랑 비교해준다.
							System.out.println(i+1); // 0 떼문에 -1을 해주었으니까 +1을 해준상태로 출력
							num=1;
							break;

						}
				}
			}else {
				for(int i=y , j=1 ; j<=m ; j++, i=i+n) {
					if(x== (i%m)) {
						System.out.println(i+1);
						num=1;
						break;
					}
				}
			}
			
			if(num==0) {
				System.out.println(-1);
			}
			t--;
		}
		
		
	}
}
