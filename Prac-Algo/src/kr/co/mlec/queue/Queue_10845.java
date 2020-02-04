package kr.co.mlec.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Queue_10845 {
	public static void main(String[] args) throws Exception {
		Vector<Integer> q = new Vector<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			String s[] = br.readLine().split(" ");

			if (s[0].equals("push")) {
				q.add(Integer.parseInt(s[1]));
			} else if (s[0].equals("front")) {
				if (q.size() > 0) {
					System.out.println(q.get(0));
				} else {
					System.out.println(-1);
				}
			} else if (s[0].equals("back")) {
				if (q.size() > 0) {
					System.out.println(q.get(q.size() - 1));
				} else {
					System.out.println(-1);
				}
			} else if (s[0].equals("size")) {
				System.out.println(q.size());
			} else if (s[0].equals("empty")) {
				if (q.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (s[0].equals("pop")) {
				if (q.size() > 0) {
					System.out.println(q.firstElement());
					q.remove(0);
				} else {
					System.out.println(-1);
				}
			}
		}
	}
}
