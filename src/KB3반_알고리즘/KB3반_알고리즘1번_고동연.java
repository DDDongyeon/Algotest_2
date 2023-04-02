package KB3반_알고리즘;

import java.util.Scanner;

public class KB3반_알고리즘1번_고동연 {
	static int n,m;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		parent=new int[n+1];
		for (int i = 0; i <=n; i++) {
			parent[i]=i;
		}
		for (int i = 0; i < m; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			union(a,b);
		}
		int count=0;
		for (int i = 1; i <= n; i++) {
			if(parent[i]==parent[1]) {
				count++;
			}
		}
		
		System.out.println(count-1);
	}
	public static void union(int a, int b) {
		a=find(a);
		b=find(b);
		if(a!=b) {
			parent[b]=a;
		}
	}
	public static int find(int a) {
		if(a==parent[a]) return a;
		return parent[a]=find(parent[a]);
	}

}
