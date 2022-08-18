/**
 *  Class that defines an entry of an address book.
 * @author Yves Semana Gisubizo
 * @version 1.0
 */
public class AddressBookEntry {

  private String first;                 // First name
  private String last;                  // Last name
  private String name;                 // Last name + first name
  private String street;                // Street
  private String city;                  // City
  private String state;                 // State
  private String zip;                   // Zip code
  private String phone;                 // Phone number
  private String email;                 // E-mail address

  /**
   * A constructor to instantiate an entry.
   *
   * @param f first name
   * @param l last name
   * @param s street
   * @param c city
   * @param t state
   * @param z zip code
   * @param p phone number
   * @param e e-mail address
   */
  public AddressBookEntry(String f, String l, String s, String c, String t,
			  String z, String p, String e) {
    first = f;
    last = l;
    name = l + f;
    street = s;
    city = c;
    state = t;
    zip = z.length() < 5 ? "0" + z : z;
    phone = p;
    email = e;
  } // AddressBookEntry

  /**
   * The accessor for the field last.
   *
   * @return the value of last
   */
  public String getLast() { return last; }

  /**
   * The accessor for the field name.
   *
   * @return the value of name
   */
  public String getName() { return name; }

  /**
   * This method returns the entire entry as a single string.
   *
   * @return the entry as a String object 
   */
  public String toString() {
    return first + " " + last + "\n" 
      + street + ", " + city + ", " + state + " " + zip + "\n"
      + phone + "\n"
      + email;
  } // toString()

}
