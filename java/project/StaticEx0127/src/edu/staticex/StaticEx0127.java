package edu.staticex;

public class StaticEx0127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3, b = 5, res = 0;
		
		res = sum(a, b);
		System.out.printf("%d + %d = %d\n", a, b, res);
	}

	public static int sum(int pa, int pb) {
		return pa + pb;
	}
}
