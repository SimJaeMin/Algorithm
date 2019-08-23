package kr.co.mlec.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//������ ���� �� �����ϴ� �κм���
public class DP_11053 {
	public static void main(String[] args) throws Exception{
		//���� A�� �־������� ���� �� �����ϴ� �κ� ������ ���� ���ϴ� ������
		//DP[i] = i��° �������� ���� �� �����ϴ� �κ� ������ ��
		//DP[i] = max ( dp[1 ~ i-1]) + �ڱ��ڽ� (1) 
		//�� 1 :�����ϴ� �κ� ������ �Ǳ����ؼ��� A[i]�� A[1 ~ i-1 ] ���� ������ ���� ���� ū ���¿����Ѵ�.
		//������ ���Һ��� Ŀ�� �����ϴ� �κм����� �̾ �� �ֱ� �����̴�.
		//�� 2 : j< i i�� j���� ū �ε����� ������ �־��Ѵ�. 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num= Integer.parseInt(br.readLine());
		String []s = br.readLine().split(" ");
		int a[]=new int[num+1];
		int dp[] = new int[num+1];
		
		for(int i=1;i<=num;i++) {
			a[i]=Integer.parseInt(s[i-1]);
			dp[i]=1; // ��� ���� �� �����ϴ� �κм����� �ڱ��ڽ��� ������ ���� 1�� �ʱⰪ
		}
		
		//dp[i]= i��° �ε������� ���� �� �����ϴ� �κ� ������ ��
		for(int i=1;i<=num;i++) {
			for(int j=1;j<i;j++) { //�� 2�� �����ϱ� ���� j�� i���� �տ� �־����
				if(a[i]>a[j]) { //�� 1�� �����ϱ����� a[i]�� a[j]���� Ŀ�� �����ϴ� �κм���
					if(dp[i]<=dp[j])	//�����ϴ� �κм����� ������ �� ������ 
					dp[i]=dp[j]+1; //�ű�� �ڱ��ڽ��� ���� �ϳ��� �߰�
				}	
			}
		}
		int max=dp[1];
		for(int i=2;i<=num;i++) {
			if(max<dp[i]) {
				max=dp[i];
			}
		}
		
		System.out.println(max);
	}
}
