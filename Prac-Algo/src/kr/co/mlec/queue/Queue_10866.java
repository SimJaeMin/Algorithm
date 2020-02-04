package kr.co.mlec.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Queue_10866 {
	public static void main(String[] args) throws Exception {
		Vector<Integer> frontQ = new Vector<Integer>();
		Vector<Integer> backQ = new Vector<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String s[] = br.readLine().split(" ");

			if (s[0].equals("push_back")) {
				backQ.add(Integer.parseInt(s[1]));
			} else if (s[0].equals("push_front")) {
				frontQ.add(0, Integer.parseInt(s[1]));
			} else if (s[0].equals("front")) {
				if (frontQ.size() == 0 && backQ.size() == 0) {
					System.out.println(-1);
				}else {

				if (frontQ.size() > 0) {
					System.out.println(frontQ.get(0));
				} else {
					System.out.println(backQ.get(0));
				}
				}
			} else if (s[0].equals("back")) {
				if (frontQ.size() == 0 && backQ.size() == 0) {
					System.out.println(-1);
				}else {
				if (backQ.size() > 0) {
					System.out.println(backQ.get(backQ.size() - 1));
				} else {
					System.out.println(frontQ.get(frontQ.size() - 1));
				}
				}
			} else if (s[0].equals("size")) {
				System.out.println(backQ.size() + frontQ.size());
			} else if (s[0].equals("empty")) {
				if (frontQ.size() == 0 && backQ.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (s[0].equals("pop_front")) {
				if (frontQ.size() == 0 && backQ.size() == 0) {
					System.out.println(-1);
				} else {

					if (frontQ.size() > 0) {
						System.out.println(frontQ.get(0));
						frontQ.remove(0);
					} else {
						System.out.println(backQ.get(0));
						backQ.remove(0);
					}
				}
			} else if (s[0].equals("pop_back")) {
				if (frontQ.size() == 0 && backQ.size() == 0) {
					System.out.println(-1);
				} else {

					if (backQ.size() > 0) {
						System.out.println(backQ.get(backQ.size()-1));
						backQ.remove(backQ.size()-1);
					} else {
						System.out.println(frontQ.get(frontQ.size()-1));
						frontQ.remove(frontQ.size()-1);
					}
				}
			}

		}
	}
}
