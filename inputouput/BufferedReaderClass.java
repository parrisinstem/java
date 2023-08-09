package inputouput;
// Java Program for taking user
// input using BufferedReader Class
import java.io.*;

public class BufferedReaderClass {

	// Main Method
	public static void main(String[] args)
		throws IOException
	{
		// Creating BufferedReader Object
		// InputStreamReader converts bytes to
		// stream of character
		BufferedReader bfn = new BufferedReader(
			new InputStreamReader(System.in));

		// String reading internally
		//String str = bfn.readLine();

		// Integer reading internally
		// Read the whole line and then parse it to an integer
		//int it = Integer.parseInt(bfn.readLine());

		// Printing String
		//System.out.println("Entered String : " + str);

		// Printing Integer
		//System.out.println("Entered Integer : " + it);

		String name;
        try {
            System.out.println("Enter your name");
            name = bfn.readLine(); // taking string input
            System.out.println("Name=" + name);
        }
        catch (Exception e) {
        }
	}
}
