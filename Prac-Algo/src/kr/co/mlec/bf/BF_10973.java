package kr.co.mlec.bf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class aa {
	int x;
	int y;
	
}
public class BF_10973 {
	static int a[];
	public static boolean go(int n) {
		aa aa = new aa(); //index와 값을 저장해주기위해
		aa.x=0; 
		for(int i=n ; i>1; i--) { //뒤에서부터 조사시작해서 이전인덱스가 처음으로 더 작은 값이 나올 떄까지
			
			if(a[i] >  a[i-1]) { // 이전 인덱스가 크면 넘김
				
				if(i==2) { // 근데 그게 마지막까지가면 이전꺼는 없는거임 1,2,3,4,5,6 같은거 이전 보다 현재가 계속큼 
					return false; // 이전이 없으니까 false 리턴
				}else {
					continue;
				}
			}else {
				int temp=a[i-1]; // 이전이 더 큰값이 나오면 그때 이전값을 저장
				
				for(int j=i ; j<=n;j++) { //이전 다음부터 조사 시작해서
					if(aa.x < a[j] && a[j] < a[i-1]) { // 이전 꺼 보다는 작은데 그 중 가장 큰 값을 찾아냄
						aa.x=a[j]; // 값
						aa.y=j; // 인덱스
					}
				}
				
				a[i-1]=aa.x; // 위치교환
				a[aa.y]=temp; // 위치교환
				
				for(int z=i;z<=n;z++) { // 인덱스 부터 다시 내림차순으로 정렬
					for(int zz=z+1;zz<=n;zz++) {
						if(a[z]<a[zz]) {
							int temp1=a[z];
							a[z]=a[zz];
							a[zz]=temp1;
						}
					}
				}
				
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i]=sc.nextInt();
		}
		
		if(go(n)) {
			for(int i=1;i<=n;i++) {
				System.out.print(a[i] + " ");
			}
			return;
		}
		System.out.println(-1);
	}
}
