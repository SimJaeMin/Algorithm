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

        int n = sc.nextInt(); // q�� ��üũ��

        int m = sc.nextInt(); //����������� ����������

        StringBuilder sb = new StringBuilder(); // ���ڿ��� �̾��ֱ����� 

        sb.append('<'); // ���۹��ڿ�����

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i=1; i<=n; i++) {

            queue.offer(i); //�����ͻ���

        }

        for (int i=0; i<n-1; i++) { //n-1 �� ���ִ� ������ ������ ���� �ٸ����·� ���ڿ��� �̾�����ϴϱ�

            for (int j=0; j<m-1; j++) { // m-1 �� ���ִ� ������ m-1 ���� ���� ���� �տ� m��° ���ߵɰ������ϱ�

                queue.offer(queue.poll());

            }

            sb.append(queue.poll() + ", ");

        }

        sb.append(queue.poll() + ">");

        System.out.println(sb);

    }

}