import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Common helper class to handle textbox operation in a form.
public class TextboxHelper {
	String xpath;
	WebDriver driver;
	public TextboxHelper(String xpath, WebDriver driver)
	{
		this.xpath = xpath;
		this.driver=driver;
	}
	
	//Utility method to set text in textbox. 
	public void setText(String textBoxData)
	{
	this.driver.findElement(By.xpath(xpath)).sendKeys(textBoxData);
	}
	
	//Utility method to compare the text value with an expected result.
	public void verifyString(String expectedTextBoxValue)
	{
	this.driver.findElement(By.xpath(xpath)).getAttribute("value");
	//Assert here Check if the textBoxData value is equal to expectedTextBoxValue
	
	}
}
