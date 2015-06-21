/*
ID: aiswary1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {
  public static void main (String [] args) throws IOException {
	  beads obj = new beads ();
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
    StringTokenizer st1 = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int numBeads = Integer.parseInt(st.nextToken());    // first integer
    String beads = st1.nextToken();
    
    out.println( obj.count(beads + beads));
  
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
  
  public int count( String str) {
	  int total = 0;
	  int pos = 0;
	  for (int i = 1; i < str.length(); i++ ) {
		  char firstLeft = str.charAt(i-1);
		  char firstRight = str.charAt(i);
		  int maxLeft = 0;
	      int maxRight = 0;
		  int left = i - 1;
		  int right = i;
		  if (firstLeft == 'w' && left - 1 >= 0 ) firstLeft = str.charAt(left - 1);
		  if (firstRight == 'w' && right + 1 < str.length()) firstRight = str.charAt(right + 1);
		  //System.out.println( firstLeft + " " + firstRight );
		  while (left >= 0 && (str.charAt(left) == firstLeft || str.charAt(left) == 'w')){
			  left--;
			  maxLeft++;
		  }
		  while (right < str.length() && (str.charAt(right) == firstRight || str.charAt(right) == 'w')) {
			  right++;
			  maxRight++;
		  }
		  if (maxRight + maxLeft > str.length() / 2)
			  total = str.length() / 2;
		  else if (maxRight + maxLeft > total) {
			  pos = i;
			  total = maxRight + maxLeft;
		  }
	  }
	  //System.out.println(pos);
	  return total;
  }
}
