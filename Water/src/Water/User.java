package Water;

/**
 * This is the class that holds the information for the user,
 *  like the footprint.
 *
 * 
 */
public class User {

	private FootPrint userFootPrint;

	/**
	 * User()
	 * 
	 * constructor that initializes the userFootPrint
	 */
	public User() {
		userFootPrint = new FootPrint();
	}


	/**
	 * getFootPrint()
	 * 
	 * @return userFootPrint
	 */
	public FootPrint getFootPrint() {
		return userFootPrint;
	}
}
