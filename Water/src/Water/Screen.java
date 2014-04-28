package Water;

/**
 * This is a template for all of the screens
 * 
 * @author Sand
 *
 */
public interface Screen {

	//this method will set all the default details of 
	//each of the screen
	public void init();
	
	//this method passes the user out of the screen
	public User passOnUser();
	
	//method sets the current User of the screen
	public void receiveUser(User currentUser);
	
	//this method draws the background image of the screen
	public void drawBackground();
}
