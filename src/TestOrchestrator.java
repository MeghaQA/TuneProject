import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//This class is responsible for Orchestrating test cases.
public class TestOrchestrator {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();		
		FormTestBase testcase1 = new FormTestBase(CSSConstants.URL,driver);
		testcase1.TestCaseToVerifyErrorWhenEmailNotProvided();
		driver.close();
		driver = new FirefoxDriver();
		FormTestBase testcase2 = new FormTestBase(CSSConstants.URL,driver);
		testcase2.TestCaseToVerifyErrorNotDisplayWhenEmailProvided();
		driver.close();
	}
}
