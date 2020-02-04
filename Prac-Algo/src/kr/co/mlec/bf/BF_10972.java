package kr.co.mlec.bf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

  class te {
	  int x;
	  int y;
}

public class BF_10972 {
	static int a[];

	public static boolean go(int n) {
		te min = new te(); // 수와 index를 동시에 저장하기위해
		min.x=n+1; // 최소값을 구해야하니까 최대값은 n+1 부터 시작
		for(int i=n;i>1;i--) { // 뒤에서 부터 하나씩 구하는데
			
			if(a[i] <a[i-1]) { // 뒤에께 크면 넘김 그런데 그게 
				if(i==2) { // 마지막 가지가면 다음꺼는 없는거니까 false를 리턴
					return false; // 리턴
				}else {
					continue; // 아닐 때는 계속 비교
				}
			}else { // 처음으로 이전 인덱스가 더 작은게 나오면
				int temp=a[i-1]; // 그 때 인덱스는 i- 1 임 왼쪽거니까
								 //그 수를 저장하고
				for(int j=i;j<=n;j++) {  // 처음으로 이전 인덱스보다 작게 나온 다음 수부터 조사를해서 그중 
					if(min.x>a[j] && a[j] > temp) { // 가장 작은값 인데 이전 인덱스보단 큰 값을 골라
						min.x=a[j]; // 갑을저장하고
						min.y=j; // 값의 index를 저장
					}	
				}
				a[i-1]=min.x; // 위치바꾸고
				a[min.y]=temp; //위치바꾸고 
				Arrays.sort(a,i,n+1); // 그 뒤에는 ??? 뒤의 새로운 수열의 시작이니까 오름차순으로 바꿔준다.
				return true;
			}
	}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		if (go(n)) {
			for(int i=1;i<=n;i++) {
				System.out.print(a[i] + " ");
			}
			return; // 끝나면 끝
		}
		System.out.println(-1); // 안끝나면 없느거니까 -1 
	}
}