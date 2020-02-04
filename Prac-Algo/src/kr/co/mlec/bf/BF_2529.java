package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BF_2529 {
	static String s1[];
	static int a[];
	static boolean open[];
	static long max=-1;
	static long min=-1;
	static int maxS[];
	static int minS[];
	public static long mul(int i, int j) {
		long x=a[i];
		for(int q=0;q<j;q++) {
			x=x *10;
		}
		return x;
	}
	public static boolean check(int len) {
		String s=s1[len-2]; //숫자 2개를 가져와서
		int first=a[len-2];
		int second=a[len-1];
		
		if(s.equals("<")){ //부등호의 참 여부를 판단한다.
			if(first<second) {
				return true;
			}else {
				return false;
			}
		}else {
			if(first>second) {
				return true;
			}else {
				return false;
			}
			
		}
		
	}

	public static void go(int index, int n, int len) {
		if( index >= 2 && !(check(index)) ) { //숫자가 2개 이상 들어올때부터 부등호와 숫자의 관계가 참인지 아닌지 판단해서
			return;			//참이 아니라면 더 이상 재귀호출을 하지 않는다. 1<2 계속 2<1 이러면 계속 할필요가없다
		}
		
		if(index==n+1) { //index 3 숫자가 부등호보다 한개 더 선택된 상황이라면 이제 최소 최대를 비교해줘야함

			long sum=0;
			for(int i=0,j=n;i<=n;i++, j--) {
				long a=mul(i,j); // 배열에 저장해서 0 번째 자리는 10의 n승이니까 이걸 이용해서 넘겨주고
				sum= sum+a; // 숫자로 만들어준다.
				
			}
			if(max<sum) { //숫자가 max보다 크면 max를 교체해주고 
				max=sum;
				for(int i=0;i<=n;i++) {
					maxS[i]=a[i]; // 출력을 위해 그때의 배열을 저장해준다.
				}
			}
			if(min>sum || min==-1) { // -1 경우 최대 정수를 모르니까  일단 -1로 시작해서 처음만 비교한다
				min=sum; // 숫자가 커진다 싶으면 long 을 생각해보자 !!!!!!!!!!!!!!!!
				for(int i=0;i<=n;i++) {
					minS[i]=a[i];
				}
			}
			return; // 숫자가 부등호보다 1개 더많으면 그 다음에는 필요없으니까 재귀를 끝내준다.
		}
		
		for(int i=0;i<=9;i++) { // 모든 순열을 돌기위해
			if(open[i]) { // 이미 방문했던 숫자라면 다음 숫자로
				continue;
			}
			open[i]=true; // 처음 방문하면 방문체크
			a[len]=i; // 그때의 index를 저장
			go(index+1,n,len+1); // index와 len을 증가시키고
			open[i]=false; // 재귀가 끝나면 다시 방문안한상태로 바꿔줘야하니까 false를 해준다.
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		s1 = br.readLine().split(" ");
		a = new int[n + 1]; // 부등호가 n개라면 숫자는 n+1개 필요함
		open = new boolean[10]; //방문 했던거 체크
		maxS= new int[n+1];// 부등호가 n개라면 숫자는 n+1개 필요함
		minS= new int[n+1];// 부등호가 n개라면 숫자는 n+1개 필요함
		
		go(0, n, 0); // 
		
		for(int i=0;i<=n;i++) {
			System.out.print(maxS[i]);
		}
		System.out.println();
		for(int i=0;i<=n;i++) {
			System.out.print(minS[i]);
		}
	}
}
