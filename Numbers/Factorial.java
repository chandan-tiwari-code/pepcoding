package Numbers;
public class Factorial {
	public static void main(String[] args) {
		System.out.println(factorial(6));
	}
	
	public static int factorial(int n) {
		if(n==1) return 1;
		return factorial(n-1) * n;
	}
}