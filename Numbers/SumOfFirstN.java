package Numbers;
public class SumOfFirstN {
	public static void main(String[] args) {
		System.out.println(sum(5));
	}
	
	public static int sum(int n) {
		if(n<=1) return n;
		return sum(n-1) + n;
	}
}