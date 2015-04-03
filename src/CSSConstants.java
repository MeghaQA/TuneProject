import org.openqa.selenium.By;

//This class will contain xpath for all the controls on the page.
public class CSSConstants {
	//url
	static final String URL = "https://platform.mobileapptracking.com/#!/advertiser" ;
	
	//TEXTBOX
	 static final String COMPANY_NAME = "//form[@id='signupForm']/ol[1]/li[1]/label/div/input" ;
	 static final String ADDRESS = "//form[@id='signupForm']/ol[1]/li[4]/label/div/input";
	 static final String CITY = "//form[@id='signupForm']/ol[1]/li[6]/label/div/input";
	 static final String ZIPCODE = "//form[@id='signupForm']/ol[1]/li[8]/label/div/input";
	 static final String EMAIL = "//form[@id='signupForm']/ol[3]/li[1]/label/div/input";
	 static final String PASSWORD = "//form[@id='signupForm']/ol[3]/li[2]/label/div/input";
	 static final String VERIFY_PASSWORD="//input[@id='password_again']";
	 
	 //BUTTON
	 static final String SUBMIT = "//input[@id='submit']";
}
