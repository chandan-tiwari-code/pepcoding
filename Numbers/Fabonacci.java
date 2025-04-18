package Numbers;
public class Fabonacci {
	public static void main(String[] args) {
		System.out.println(fabonacci(10) + " ");
	}
	
	public static int fabonacci(int n) {
		if(n<=1) return n;
		return fabonacci(n - 1) + fabonacci(n - 2);
	}
}