import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Example {
	public static void main(String[] args){
		File file = new File("/home/oracle/workspace/LinkedListScannerTokenizerFileExample/src/customers.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("error, file not found");
		}
		scan.useDelimiter("\\t|\\n");
		// Printing the delimiter used
		System.out.println("The delimiter is "+scan.delimiter());
		
		//create a linkedList for our customers
		LinkedList<Customer> customers = new LinkedList<Customer>();
		
		
		//create a printWriter to write to the file
		PrintWriter writer=null;
		try {
			writer = new PrintWriter(new File("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		//skip the first line which contains headers
		scan.nextLine();
		//for (int i=0;i<1;i++){
		while (scan.hasNext()){
			Customer c = new Customer();
			c.setFullName(scan.next());
			c.setSalutation(scan.next());
			c.setFirstName(scan.next());
			c.setLastName(scan.next());
			c.setAddress(scan.next());
			scan.next();
			scan.next();
			scan.next();
			c.setEmail(scan.next());
			c.setPosition(scan.next());
			c.setCompany(scan.next());
			//scan.nextLine();
			System.out.println(c.getFullName());
			

			//add customer to linkedList of customers
			customers.add(c);
			
			//write customer and email address only to file if customer
			writer.print(c.getFullName());
			writer.println(c.getEmail());
			
		}
		
		//retrieving from the linkedList
		for (Customer cust: customers){
		//	System.out.println(cust.getFullName());
		}
		//to get a particular 
		
		
		// closing the scanner stream
		scan.close();
		//close the print writer
		writer.close();
		
	}

}
