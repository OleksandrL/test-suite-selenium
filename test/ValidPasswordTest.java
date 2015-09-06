import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.junit.Test;

public class ValidPasswordTest {

	WebDriver driver = LoginTests.driver;
    java.lang.String baseUrl = LoginTests.baseUrl;
    StringBuffer verificationErrors = new StringBuffer();
    
	@Test
	public void validPassword() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("user_login")).clear();
	    driver.findElement(By.id("user_login")).sendKeys("admin");
	    driver.findElement(By.id("user_pass")).clear();
	    driver.findElement(By.id("user_pass")).sendKeys("demo123");
	    driver.findElement(By.id("wp-submit")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Howdy, admin[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("//li[@id='menu-posts']/a")).click();
	    driver.findElement(By.cssSelector("a.add-new-h2")).click();
	    driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys("Selenium Demo Post");
	    driver.findElement(By.id("publish")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Post published[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	}
}

