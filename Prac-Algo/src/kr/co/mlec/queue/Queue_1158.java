package kr.co.mlec.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_1158 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // q의 전체크기

        int m = sc.nextInt(); //몇번간격으로 넣을것인지

        StringBuilder sb = new StringBuilder(); // 문자열을 이어주기위해 

        sb.append('<'); // 시작문자열지정

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i=1; i<=n; i++) {

            queue.offer(i); //데이터삽입

        }

        for (int i=0; i<n-1; i++) { //n-1 번 해주는 이유는 마지막 꺼는 다른형태로 문자열을 이어줘야하니까

            for (int j=0; j<m-1; j++) { // m-1 번 해주는 이유는 m-1 번쨰 빼면 제일 앞에 m번째 빼야될게있으니까

                queue.offer(queue.poll());

            }

            sb.append(queue.poll() + ", ");

        }

        sb.append(queue.poll() + ">");

        System.out.println(sb);

    }

}