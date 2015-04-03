import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Common helper class to handle button operation in a form.
public class ButtonHelper {
	String xpath;
	WebDriver driver;
	ButtonHelper(String xpath,WebDriver driver)
	{
		this.xpath=xpath;
		this.driver=driver;
	}
	//Utility method to click button. 
	public void clickFormButton()	
	{
		try
			{
				this.driver.findElement(By.xpath(xpath)).click();
			}
			catch (Exception e)
			{
				System.out.println("Element not found");
			}
		}
}
