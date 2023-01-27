package edu.forexone;

public class ForExOne0127 {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i <= 10; i++) {
			sum += i;
			if( (i & 1) == 0 ) System.out.printf("sum = %d, i = %d\n", sum, i);
		}
			
		System.out.println(sum);
	}
	
	public static int sumRange(int start, int stop) {
		return ( (stop - start + 1) * (start + stop) ) >> 1;
	}
}
