import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
	    int [] list={1, 2, 3, 5, 7, 10, 14, 17, 77, 188};
	    int searchValue;
	    System.out.println("Enter search value: ");
	    Scanner input = new Scanner(System.in);
	    searchValue = input.nextInt();
	    System.out.println("With recursion ");
	    System.out.println( bsearchr(list,0,list.length-1, searchValue));
	    System.out.println("W/O recursion ");
	    System.out.println( bsearch(list, list.length, searchValue));
	}
	// Searches an ordered array of integers using recursion
	public static int bsearchr(int [] data, // input: array
	             int first,        // input: lower bound
	             int last,        // input: upper bound
	             int value         // input: value to find
	        )// output: index if found,  otherwise return –1

	{  
	   int middle = (first + last) / 2;//0 + 7 = 7 -->>  7/2 = 3
	   System.out.println("first : " + first  + " last : " + last + " middle : "+ middle);
	   System.out.println(" middle value : "+ data[middle]);
	   if (data[middle] == value) {
	      return middle;
	   } else if (first >= last) {
	      return -1;
	   } else if (value < data[middle]) {
	      return bsearchr(data, first, middle-1, value);
	   } else {
	      return bsearchr(data, middle+1, last, value);
	   }
	}
	
	public static int bsearch(int data[], // input: array
            int size,    // input: array size
            int value    // input: value to find
           ){            // output: if found,return index;
						 // otherwise, return -1

		int first, last, middle;
		   first = 0;
		   last = size - 1;
		   
		while (true) {
          middle = (first + last) / 2;
          System.out.println("first : " + first  + " last : " + last + " middle : "+ middle);
          System.out.println(" middle value : "+ data[middle]);
	
          if (data[middle] == value) {
               return middle;
          } else if (first >= last) {
               return -1;
          } else if (value < data[middle]) {
 			last = middle - 1;
          } else {
 			first = middle + 1;
          }
     }
} 

	


}
