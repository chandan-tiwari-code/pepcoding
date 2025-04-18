package Numbers;
public class NumberPalindrome {
	public static void main(String[] args) {
		//System.out.println(palindrome(12321));
		int n=1221;
		int rev=palindromeRecursion(n,0);;
		palindromeRecursion(n,rev);
		System.out.println(rev);
		System.out.println(n==rev);
	}
	
	public static boolean palindrome(int n) {
		int og = n;
		int reversed=0;
		while(n>0) {
			int reminder=n%10;
			reversed=reversed*10+reminder;
			System.out.println(reversed);
			n/=10;
		}
		System.out.println(reversed);
		return  og==reversed;
	}
	
	//reversing number using recursion
	public static int palindromeRecursion(int n, int rev) {
		if(n<=0){
			System.out.println(rev);
			return rev; //finally we're returning reversed num only
		}
		return palindromeRecursion(n/10, rev*10+n%10);	
	}
}