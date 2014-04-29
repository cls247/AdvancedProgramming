package Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Water.FootPrint;
import Water.InteractivePage;
import Water.User;

//tests the receiveUser and passOnUser methods of the InteractivePage class
public class receiveAndPassOnUserTest {

	@Test
	public void test() {

		// create a new user and get its associated footprint
		User testUser = new User();
		FootPrint testFootPrint = testUser.getFootPrint();

		// set the footprint's numberOfLoadsOfClothes equal to 99
		testFootPrint.setNumberOfLoadsOfClothes(99);

		// create a new interactive page and add the user
		InteractivePage testPage = new InteractivePage();
		testPage.receiveUser(testUser);

		// retrieve the user from the interactive page and check that
		// numberOfLoadsOfClothes still equals 99
		User resultUser = testPage.passOnUser();
		int resultNumberOfLoadsOfClothes = resultUser.getFootPrint()
				.getNumberOfLoadsOfClothes();

		assertTrue(resultNumberOfLoadsOfClothes == 99);
	}

}
