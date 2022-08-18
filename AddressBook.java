/**
 * Class that creates the address book.
 * @author Yves Semana Gisubizo
 * @version 1.0
 * 
 */

import java.io.*;
import java.util.*;

public class AddressBook {

  public static final int MAX = 10000;  // The maximum number of entries
  private AddressBookEntry[] table;     // An array of entries
  private int size;                     // The actual number of entries
  private boolean sorted;               // Whether the entries are sorted

  public AddressBook(String filename) {
    try {
      table = new AddressBookEntry[MAX];
      Scanner scanner = new Scanner(new File(filename));
      scanner.useDelimiter(",");
      int i = 0;
      while (scanner.hasNext()) {       // Read entries of the data file
	String first = scanner.next();
	String last = scanner.next();
	String street = scanner.next();
	String city = scanner.next();
	String state = scanner.next();
	String zip = scanner.next();
	String phone = scanner.next();
	String email = scanner.nextLine().substring(1);
        table[i] = new AddressBookEntry(first, last, street, city, state, 
					zip, phone, email);
        i++;
      }
      size = i;
      sorted = false;
    } catch (FileNotFoundException e) {
      System.out.println("The file " + filename + " is not found.");
    }
  }

  public boolean isSorted() { return sorted; }

  public int getSize() { return size; }

  public AddressBookEntry getEntry(int i) { return table[i]; }
    
  public void search(String last) {
       boolean found = false;
    if (sorted) {
        int low = 0; 
        int high = size - 1; 
        while (low <= high) { 
            int mid = low + (high - low) / 2; 
    
            // Checking if string last is at mid 
            if (last.compareTo(table[mid].getLast()) == 0) 
              {  found = true;
                 for (int i = 0; i < size; i++){ 
                   if (last.compareTo(table[i].getLast()) == 0)    
                   System.out.println("Sequential search making " + (i+1) + " queries...\n\n" 
                   + table[i] + "\n\n");
                 }
                }  
            // If string last exists after the current last name to ignore left half 
            if (last.compareTo(table[mid].getLast())  > 0) 
                low = mid + 1; 
  
            // If string last exists before the current last name to ignore right half 
            else
                high = mid - 1; 
            
        } 
        if (found == false)    
             System.out.println("Sequential search making " + (size) + " queries...\n\n" 
             + "Not Found.\n\n");
    }
    else {
      for(int i = 0; i < size; i++)
        if (last.equals(table[i].getLast()))
         {   found = true;
             System.out.println("Sequential search making " + (i+1) + " queries...\n\n" 
            + table[i] + "\n\n");
            }
            
      if (found == false)    
             System.out.println("Sequential search making " + (size) + " queries...\n\n" 
             + "Not Found.\n\n");
    }
  }
  
  //Using selection sort to sort the AddressBookEntry reference array 
  public void sort() {
     for (int i = 0; i < size; i++) {
       int lowindex = i;
      for (int j = i + 1; j < size; j++){
       if (table[lowindex].getName().compareTo(table[j].getName()) > 0) //comparing the names from the AddressBookEntry table array object
         lowindex = j;
        }
        swap(i, lowindex);
     }
     sorted = true;
  }
  
  public void swap(int i, int j) { 
    AddressBookEntry temp = table[j];
    table[j] = table[i];
    table[i] = temp;
  }
}
