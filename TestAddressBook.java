/**
 *  Class for testing the functions associated with the address book.
 * 
 * @author Yves Semana Gisubizo
 * @version 1.0
 * 
 */

public class TestAddressBook {

  public static void main(String args[]) {
    if (args.length > 0) {
      AddressBook ab = new AddressBook(args[0]);
      
      //Testing the search before sorting
      System.out.println("Before sort searching.....");
      System.out.println("Searching for 'Wilson':");
      ab.search("Wilson");
      //System.out.println(ab.search("Wilson"));
      
      System.out.println("\nSearching for 'Yoon':");
      ab.search("Yoon");
      //System.out.println(ab.search("Yoon"));       

          //Testing my sorting method
      //Printing first and last entries before sorting 
      System.out.println("\n------ Before sorting: ----- \nFirst entry is: \n\n" + ab.getEntry(0));
      System.out.println();
      System.out.println("Last entry is: \n\n" + ab.getEntry(ab.getSize()-1));
      System.out.println();
      
      //Printing first and last entries after sorting
      ab.sort();
      System.out.println("----- After sorting: ----- \nFirst entry is: \n\n" + ab.getEntry(0));
      System.out.println();
      System.out.println("Last entry is: \n\n" + ab.getEntry(ab.getSize()-1));
      System.out.println();
      
      //Testing the search after sorting
      System.out.println("After sort searching.....");
      System.out.println("Searching for 'Wilson':");
      ab.search("Wilson");
      //System.out.println(ab.search("Wilson"));
      
    }
    else {
      System.out.println("Filename missing");
    }
  }

}
