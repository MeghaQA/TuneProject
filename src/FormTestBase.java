import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class FormTestBase {
	String url;
	WebDriver driver;
	ButtonHelper button;
	HashMap<String, TextboxHelper> textBoxes;	
	
	//FormTestBase method will initialize form controls.
	//The long term goal of this class is to read the list of controls from csv file.
	//and make this class work with multiple forms.
	//Any specific implementation for edge case can be derived from this form.
	public FormTestBase(String url,WebDriver driver)
	{
		this.url = url;
		this.driver = driver;
		this.textBoxes = new HashMap<String, TextboxHelper>();
		this.textBoxes.put("COMPANY_NAME", new TextboxHelper(CSSConstants.COMPANY_NAME, this.driver));
		this.textBoxes.put("ADDRESS",new TextboxHelper(CSSConstants.ADDRESS,this.driver));
		this.textBoxes.put("CITY",new TextboxHelper(CSSConstants.CITY,this.driver));
		this.textBoxes.put("ZIPCODE",new TextboxHelper(CSSConstants.ZIPCODE,this.driver));
		this.textBoxes.put("EMAIL",new TextboxHelper(CSSConstants.EMAIL,this.driver));
		this.textBoxes.put("PASSWORD",new TextboxHelper(CSSConstants.PASSWORD,this.driver));
		this.textBoxes.put("VERIFY_PASSWORD",new TextboxHelper(CSSConstants.VERIFY_PASSWORD,this.driver));
		this.button  = new ButtonHelper(CSSConstants.SUBMIT,this.driver);
		
	}	 
	
	/*{Objective:This Test case will verify that error message will display if user submits the form 
	 * with empty email field.}
	 * @testSteps:
	 * 1.Load the url
	 * 2.Fill company name,Address,City,Zipcode,Password,Verify password field.Leave the email field empty.
	 * 3.Click on "Accept Terms & Continue" button.
	 * @assertion:Fail if form does not display error message box.
	 */
	public void TestCaseToVerifyErrorWhenEmailNotProvided()
	{		
		this.driver.get(this.url);
		this.driver.manage().window().maximize();
		this.textBoxes.get("COMPANY_NAME").setText("Tune");
		this.textBoxes.get("ADDRESS").setText("Pike and 4th Ave");
		this.textBoxes.get("CITY").setText("Seattle");
		this.textBoxes.get("ZIPCODE").setText("98101");
		this.textBoxes.get("PASSWORD").setText("aaabbbCCC!1");
		this.textBoxes.get("VERIFY_PASSWORD").setText("aaabbbCCC!1");
		this.button.clickFormButton();
		boolean result = driver.getPageSource().contains("Email address cannot be empty"); 
		Assert.assertTrue(result, "Email address not found");
		System.out.println("Testcase TestCaseToVerifyErrorWhenEmailNotProvided() Pass");	
				
	}	
	
	/*{Objective:This Test case will verify that no error message will display if user submits the form 
	 * with valid email field.}
	 * @testSteps:
	 * 1.Load the url.
	 * 2.Fill company name,Address,City,Zipcode,email,Password,Verify password field.Leave the email field empty.
	 * 3.Click on "Accept Terms & Continue" button.
	 * @assertion:Fail if form display error message box.
	 */
	
	public void TestCaseToVerifyErrorNotDisplayWhenEmailProvided()
	{		
		this.driver.get(this.url);
		this.driver.manage().window().maximize();
		this.textBoxes.get("COMPANY_NAME").setText("Tune");
		this.textBoxes.get("ADDRESS").setText("Pike and 4th Ave");
		this.textBoxes.get("CITY").setText("Seattle");
		this.textBoxes.get("ZIPCODE").setText("98101");
		UUID idOne = UUID.randomUUID();		
		this.textBoxes.get("EMAIL").setText(idOne.toString()+"@yahoo.com");
		this.textBoxes.get("PASSWORD").setText("aaabbbCCC!1");
		this.textBoxes.get("VERIFY_PASSWORD").setText("aaabbbCCC!1");
		this.button.clickFormButton();
		boolean result = driver.getPageSource().contains("Email address cannot be empty");
		Assert.assertFalse(result, "Email address not found");
		System.out.println("Testcase TestCaseToVerifyErrorNotDisplayWhenEmailProvided() Pass");
				
	}
	
}
