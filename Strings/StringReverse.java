package Numbers;
public class StringReverse {
	public static void main(String[] args) {
		System.out.println("chandan : "+reverse("chandan"));
	}
	
	public static String reverse(String str) {
		if (str.isEmpty()) {
            return str; // Base case: empty string
        }
		char ch = str.charAt(0);	
        return reverse(str.substring(1)) + ch; 		
	}
}