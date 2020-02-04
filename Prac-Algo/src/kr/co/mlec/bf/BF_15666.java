package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class BF_15666 {
	static int check[] = new int[10001];
	static ArrayList<Integer> a;
	static int aa[];

	public static void go(int n, int m, int len, int temp) {

		if (len == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(aa[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (temp <= a.get(i)) {
				check[a.get(i)]--;
				aa[len] = a.get(i);
				go(n, m, len + 1, a.get(i));
				check[a.get(i)]++;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(s[i]));
			check[Integer.parseInt(s[i])]++;
		}

		a = new ArrayList<Integer>(set);

		aa = new int[m];
		go(a.size(), m, 0, 0);
	}
}
