package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//������ : ���� �� ������� �κ� ����
public class DP_11054 {
	public static void main(String[] args) throws Exception {
		//�����ߴٰ� �����ϴ� �κ� ������ ���� �� �� ã����ȴ�.
		//�׷��� ���� ����ٰ� �����ϱ� �����ϴ� �κп��� �� ������ �Ǵ� ���� 2�� üũ �Ǳ� ������ ��ü���� -1 �� ������Ѵ�.
		//���� ���� �� �����ϴ� �κ� ������ ã�� �� �κп��� �ٽ� ���� �� �����ϴ� �κ� ������ ã���� �ȴ�.
		//dp�� 2�� ������ 1���� ���� �� ����, �ٸ� �� ���� ���� �� ���Ҹ� �ؼ� 2���� �����ְ� -1�� �ϸ�ȴ�.
		//�׷��� ���⼭ ���� �Է¹��� ������ ����� ���� �� �����ϴ� ������ ���ؼ� �ΰ��� �����ٶ��� ���� �ε������ƴ� �ݴ�� �Ǿ�����
		//�׷��� ���⼭�� ����� Ǫ�°ͺ��ٴ� ���� �����ϴ� �� ������ num �κк��� �ݴ�� Ǫ�� ����� �� �����Ű���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		int dp1[] = new int[num+1]; //���� �� �����ϴ� �κ� ���� ����
		int dp2[]= new int[num+1]; //���� �� �����ϴ� �κ� ���� ����
		List<Integer> a=new ArrayList<Integer>();
		
		String s[]=br.readLine().split(" ");
		for(int i=1;i<=num;i++) {
			a.add(Integer.parseInt(s[i-1]));
			dp1[i]=1; //�����ϱ� 1�� �ʱ�ȭ
			dp2[i]=1;
		}
		
		for(int i=0;i<num;i++) { //���� �� �����ϴ� �κм��� ���
			for(int j=0;j<i;j++) {
				if(a.get(i)>a.get(j)) {
					if(dp1[i+1]<dp1[j+1]+1) {
						dp1[i+1]=dp1[j+1]+1;
					}
				}
			}
		}
		Collections.reverse(a); // ���� �� �����ϴ� �κм����� Ǯ������ reverse ���
		
		for(int i=0;i<num;i++) { // ���� �� �����ϴ� �κм��� ���
			for(int j=0;j<i;j++) {
				if(a.get(i)>a.get(j)) {
					if(dp2[i+1]<dp2[j+1]+1) {
						dp2[i+1]=dp2[j+1]+1;
					}
				}
			}
		}

		
		
		for(int i=1;i<=num;i++) { // ���� ������� ������ �������⶧���� �����ٶ� �ݴ��ʺ��� ���������
			dp1[i]=dp1[i]+dp2[num+1-i];
		}
		int max=dp1[1];
		for(int i=2;i<=num;i++) {
			if(max<dp1[i]) {
				max=dp1[i];
			}
		}
		
	
		System.out.println(max-1);
	}
}
