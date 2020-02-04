package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class BF_15663 {
	static ArrayList<Integer> a;
	static int check[] = new int[10001];
	static int aa[];
	
	public static void go(int n, int m , int len) {
		if(len==m) {
			for(int i=0;i<m;i++) {
				System.out.print(aa[i] + " " );
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(check[a.get(i)]>0) { // 0보다 큰 걸로 비교한 이유는 이미 사용한 데이터인지 아닌지 비교하기 위해 
				check[a.get(i)]--; // 마이너스 해주면 1개 있는 데이터면 0이 되고 2개였으면 1 이 되니까 중복및 사용된데이터 둘다 판단 가능
				aa[len]=a.get(i);
				go(n,m,len+1);
				check[a.get(i)]++;
			}
		}

			
		}
		
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n= Integer.parseInt(s[0]);
		int m= Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		aa = new int[m];
		Set<Integer> set = new TreeSet<Integer>(); // 중복된 데이터를 없애기 위해 TreeSet 을 사용 TreeSet은 자동으로 오름차순으로 정렬된다.
		for(int i=0;i<n;i++) {
			set.add(Integer.parseInt(s[i])); // 데이터를 Set에 넣으면서 중복을 제거해주고
			check[Integer.parseInt(s[i])]++; // 같은 값이 몇개 있는지 체크해주기 위해 int형으로 
		}
		a=new ArrayList<Integer>(set); // 중복을 제거한 set을 바탕으로 ArrayList를 만든다.

		go(a.size(),m,0); // 재귀시작
	}
}
