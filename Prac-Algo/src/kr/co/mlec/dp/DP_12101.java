package kr.co.mlec.dp;

import java.util.Scanner;
import java.util.Vector;

public class DP_12101 {
	static Vector<Integer> v;
	static int count=0;
	public static void go(int n, int k,int len,int sum) {
		if(sum==n) {
			count++;
			
			if(count==k) {
				for(int i=0;i<v.size()-1;i++) {
					System.out.print(v.get(i) + "+");
				}
				System.out.println(v.get(v.size()-1));
				System.exit(0);
			}else {
				if(v.size()>0) {
					v.remove(v.size()-1);
				}else {
					System.out.println(-1);
					System.exit(0);
				}
				return;
			}
		}else if(sum>n) {
			if(v.size()>0) {
				v.remove(v.size()-1);
			}else {
				System.out.println(-1);
				System.exit(0);
			}			return;
		}
		
		for(int i=1;i<=3;i++) {
			v.add(i);
			go(n,k,len+1,sum+i);
		}
		if(v.size()>0) {
			v.remove(v.size()-1);
		}else {
			System.out.println(-1);
			System.exit(0);
		}
		}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		v	 = new Vector<Integer>();
		go(n,k,0,0);
		System.out.println(-1);

	}
}
