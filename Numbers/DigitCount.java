package Numbers;
public class DigitCount {
	public static void main(String[] args) {
		//System.out.println(count(123456789, 0));
		System.out.println(sumOfDigit(123456789, 0));
	}

	public static int count(int n, int count){
		if(n<=0) {
			return count;
		}
		return count(n/10, count+1);
	}
	
	public static int sumOfDigit(int n, int sum) {
		if(n<=0) return sum;
		System.out.println(sum);
		return sumOfDigit(n/10, sum+n%10);
	}
}