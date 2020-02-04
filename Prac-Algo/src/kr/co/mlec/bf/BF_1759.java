package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BF_1759 {
	static char data[];
	static char a[];

	public static boolean check(int size) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < size; i++) {
			if (a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o' || a[i] == 'u') {
				y++;
			} else {
				x++;
			}
		}
		if (x >= 2 && y >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void go(int n, int m, int index, int len) {
		if (len == m) {
			if (check(m)) {
				for (int i = 0; i < m; i++) {
					System.out.print(a[i]);
				}
				System.out.println();
				return;
			}else {
				return;
			}
		}

		if (index >= n)
			return;

		a[len] = data[index];
		go(n, m, index + 1, len + 1);
		
		go(n, m, index + 1, len);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s= sc.nextLine();
		int l = Integer.parseInt(s.split(" ")[0]);
		int c = Integer.parseInt(s.split(" ")[1]);

		data = new char[c];
		s=sc.nextLine();
		for (int i = 0; i < c; i++) {
			data[i] = s.split(" ")[i].charAt(0);
		}

		a = new char[l];
		Arrays.sort(data);

	
		go(c, l, 0, 0);

	}
}
