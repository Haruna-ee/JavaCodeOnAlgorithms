
public class ProblemSolving {

	public static void main(String[] args) {
	
		//print a message for n times
		//loop: 
		String msg = "Hello!";
		int times = 6;
		System.out.println("W/O recursion ");
		print(msg, times);
		System.out.println("With recursion ");
		printRecursive(msg, times);     
		
		String word = "madam";
		System.out.println(word);
		System.out.println(word.charAt(0) + " " + word.charAt( word.length() -1));
		System.out.println(word.charAt(1) + " " + word.charAt( word.length() - 2));
		System.out.println(word.charAt(2) + " " + word.charAt( word.length() - 3));
		
		//word = "rotator";
		word = "rotation";
		System.out.println(word);
		System.out.println(word.charAt(0) + " " + word.charAt( word.length() -1));
		System.out.println(word.charAt(1) + " " + word.charAt( word.length() - 2));
		System.out.println(word.charAt(2) + " " + word.charAt( word.length() - 3));
		System.out.println(word.charAt(3) + " " + word.charAt( word.length() - 4));
		
		//for loop
		int i, begin, end, middle;
		begin = 0;
		end = word.length() - 1;
		middle =  (begin + end)/2;
		
		for (i = begin; i <= middle; i ++) {
			System.out.println("begin " + begin + " end " + end + " ");
			System.out.println(word.charAt(begin) + " " + word.charAt( end));
			if (word.charAt(begin) == word.charAt( end)) {
				begin ++;
				end --;
			} else {
				break;
			}
		}
		if (i == middle+1) {//check if enough iterations ..
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a Palindrome");
		}
		//recursion		
		System.out.println();
		word = "rotator";
		System.out.println(isPalindrome(word));
		
		//reverse the string and compare
		//use reversed array algorithm
		word = "abc";
		//System.out.println(reverseString(word));
	    /*if (word.equals( reverseString(word))) {
	    	
	    	System.out.println("Palindrome");
	    } else {
	    	System.out.println("Not a Palindrome");
	    }*/
		System.out.println(word  +  (isPalindromeReverseStr(word)? " -- Palindrome": "-- Not a Palindrome"));
		System.out.println("radar" + (isPalindromeReverseStr("radar")? " -- Palindrome": "-- Not a Palindrome"));
		System.out.println("mam" + (isPalindromeReverseStr("mam")? " -- Palindrome": "-- Not a Palindrome"));
	}
	public static boolean isPalindromeReverseStr(String str) {
		return str.equals( reverseString(str));
	}
	public static String reverseString(String s) {
		int n = s.length();
		String anotherS = "";
		for (int i = n - 1; i >= 0; i -- ) {
			anotherS  = anotherS  + s.charAt(i);
		}
		return anotherS;
	}
	
	public static boolean isPalindrome(String s) {
	  System.out.println("String : " + s);
	  if (s.length() <= 1) {// Base case
	    return true;
	  } else if (s.charAt(0) != s.charAt( s.length() - 1) ) {// Base case
	    return false;
	  } else {
	    return isPalindrome( s.substring(1, s.length( )- 1) );
	  }
	}


	public static void print(String message, int times) {
		for (int i = 0; i < times; i ++ ) {
			System.out.println(message);
		}
			
	}
		
		public static void printRecursive(String message, int times) 
		{
		  if (times >= 1) {
			System.out.println("Times left : " + times);
		 	System.out.println( message );
		 	printRecursive(message, times - 1);
		  } 
		  // The base case is times == 0

		}

		

}
