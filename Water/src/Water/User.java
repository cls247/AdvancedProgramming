package Water;

public class User {

	private String username;
	private FootPrint userFootPrint;
	
	public User()
	{
		userFootPrint=new FootPrint();
	}
	public void setUserName (String setUserName)
	{
		username=setUserName;
	}
	public String getUserName ()
	{
		return username;
	}

}
