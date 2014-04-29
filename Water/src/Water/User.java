package Water;

/**
 * This is a user class. We do not know exactly what we will use this for yet.
 * Right now it just holds a footprint. To be expanded.
 * 
 * @author Sand
 * 
 */
public class User {

	private String username;
	private FootPrint userFootPrint;

	public User() {
		userFootPrint = new FootPrint();
	}

	public void setUserName(String setUserName) {
		username = setUserName;
	}

	public String getUserName() {
		return username;
	}

	public FootPrint getFootPrint() {
		return userFootPrint;
	}
}
