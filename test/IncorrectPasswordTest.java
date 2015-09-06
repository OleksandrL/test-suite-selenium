import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.junit.Test;

public class IncorrectPasswordTest {
	 WebDriver driver = LoginTests.driver;
	 java.lang.String baseUrl = LoginTests.baseUrl;
	 StringBuffer verificationErrors = new StringBuffer();
	 
	@Test
	public void incorrectPassword() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("user_login")).clear();
	    driver.findElement(By.id("user_login")).sendKeys("admin");
	    driver.findElement(By.id("user_pass")).clear();
	    driver.findElement(By.id("user_pass")).sendKeys("demo");
	    driver.findElement(By.id("wp-submit")).click();
	 // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains
	    		  ("ERROR: The password you entered for the username admin is incorrect."));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	}
}
