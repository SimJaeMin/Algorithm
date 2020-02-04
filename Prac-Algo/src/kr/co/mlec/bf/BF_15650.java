package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_15650 {
	//NM (1) 과 같지만 수열이 오름 차순인거만 출력해줘야한다.
	static int a[];
	static boolean check[];
	
	public static void go(int n , int m ,int len , int num ) { // num은 오름차순이 되는 수열만 만들어야하기 때문에
															   // 현재 index - 1 의 값을 넘겨주어서 그 값보다 큰 값만 체크 하고 값을 지정할 수 있게 해주기 위해 선언
		if(m==len) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) { // 1 부터 n 까지 
			
			if(check[i]) {
				continue;
			}
						
			if(num<i) { //오름차순을 만들려면 num ( 현재 index -1 의 값 )보다 큰 값만 다음 값으로 지정해야하기 때문에 비교해준다.
				check[i]=true;
				a[len]=i;
				go(n,m, len+1,i);
				check[i]=false;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		check = new boolean[n+1];
		a= new int[m];
		
		go(n,m,0,0);
		
		
	}
}
