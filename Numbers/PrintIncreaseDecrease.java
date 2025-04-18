package Numbers;
public class PrintIncreaseDecrease {
	public static void main(String [] args) {
		//printIncreaseDecrease(5);
		printIncreaseDecrease(5, 1);
	}
	
	public static void printDecreaseIncrease(int n) {
		if(n==0) return;
		System.out.println(n);
		printDecreaseIncrease(n-1);
		System.out.println(n);
	}

	public static void printIncreaseDecrease(int n, int start) {
		if(n==start) return;
		System.out.println(start);
		printIncreaseDecrease(n, start+1);
		System.out.println(start);
	}
}