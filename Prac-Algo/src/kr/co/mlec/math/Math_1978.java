package kr.co.mlec.math;

import java.util.Scanner;

//소수 찾기
public class Math_1978 {
	//소수를 찾을 때 n/2 까지 찾는 이유는 n의 약수는 2보다 작을수 없으니까 작거나 같기때문
	//n을 만들 수있는 수중 가장 큰 수가 ?*? =n 할 때 2로 할때 다음 수가 가장 커지기 때문에 n/2까지 만보면됨
	//
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		
		int arr[] =new int[num];
		
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		int cnt=0;
		for(int i=0;i<num;i++) {
			if(arr[i]<2) {
				continue;
			}
			for(int j=2;j*j<=arr[i];j++) {
				if(arr[i]%j==0) {
					break;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
