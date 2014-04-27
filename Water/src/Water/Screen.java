package Water;

public interface Screen {

	public void init();
	public User passOnUser();
	public void receiveUser(User currentUser);
	public void drawBackground();
}
