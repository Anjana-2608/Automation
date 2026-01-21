package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import junit.framework.Assert;
import pages.RegisterPage;
import utils.Utilities;

public class RegisterTest extends BaseTest {
	
	@Test
	public void verifyRegisteringWithMandatoryFields() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.openRegisterPage();
		registerPage.clickRegisterlink();
		registerPage.enterFirstName("Anjana");
		registerPage.enterLastName("Kesharwani");
		registerPage.enterEmail(Utilities.generateNewEmail());
		registerPage.enterTelephone("9876543210");
		registerPage.enterPassword("Anjana@123");
		registerPage.agreeToPolicy();
		registerPage.clickContinue();
		
		Assert.assertTrue(registerPage.isLogoutDisplay());
		
		Assert.assertEquals(
				registerPage.getSuccessHeading(),
				"Your Account Has Been Created!"
				);
		
		String content = registerPage.getContentText();
		
		Assert.assertTrue(content.contains("Congratulations! Your new account has been successfully created!"));
		Assert.assertTrue(content.contains("You can now take advantage of member privileges"));
		Assert.assertTrue(content.contains("If you have ANY questions"));
		Assert.assertTrue(content.contains("contact us"));
		
		registerPage.clickContinueAfterRegister();
		
		Assert.assertTrue(registerPage.isEditInfoDisplay());
	}

}
