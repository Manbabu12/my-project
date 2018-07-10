
//import required resousces


public class IndexPage
{
	

    String existingUserEmail = "mflsqe@naic.org";
    String existingUserPassword = "mflsqe1234";
	
	
	
	public void openURL(WebDriver driver)
	{
		driver.get("http://automationpractice.com/index.php");
	}
	
	public void signInTest(WebDriver driver, String email)
	{
		WebDriver wait = new WebDriverWait(driver, 10, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
		driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();
	}
	
	public void addDetails(WebDriver driver, String name,String surname,String password)
	{
		WebDriver wait = new WebDriverWait(driver, 10, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(name);
        driver.findElement(By.id("customer_lastname")).sendKeys(surname);
        driver.findElement(By.id("passwd")).sendKeys("Qwerty");   
		Select select = new Select(driver.findElement(By.id("days")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("months")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("years")));
        select.selectByValue("2000");
        driver.findElement(By.id("company")).sendKeys("Company");
        driver.findElement(By.id("address1")).sendKeys("Qwerty, 123");
        driver.findElement(By.id("address2")).sendKeys("zxcvb");
        driver.findElement(By.id("city")).sendKeys("Qwerty");
		select = new Select(driver.findElement(By.id("id_state")));
        select.selectByVisibleText("Colorado");
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("other")).sendKeys("Qwerty");
        driver.findElement(By.id("phone")).sendKeys("12345123123");
        driver.findElement(By.id("phone_mobile")).sendKeys("12345123123");
        driver.findElement(By.id("alias")).sendKeys("hf");
        driver.findElement(By.id("submitAccount")).click();
       
	}
	
	public void loginTest()
	{		
		WebDriver wait = new WebDriverWait(driver, 10, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
        driver.findElement(By.id("email")).sendKeys(existingUserEmail);
        driver.findElement(By.id("passwd")).sendKeys(existingUserPassword);
        driver.findElement(By.id("SubmitLogin")).click();
	}
	
	public void checkout()
	{
		WebDriver wait = new WebDriverWait(driver, 10, 50);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed to checkout"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed to checkout"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
        driver.findElement(By.name("processCarrier")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button"))).click();
		
	}
	
	public String getPageHeading()
	{
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		return heading.getText();
	}
	
	public String getUsername()
	{
        return driver.findElement(By.className("account")).getText();
	}
	
	public String getInfoAccount()
	{
        return driver.findElement(By.className("info-account")).getText());
	}
	
	public static WebElement getLogoutLink(Webdriver driver)
	{
        return driver.findElement(By.className("logout"));
	}
	
	public String getMyaccount()
	{
        return driver.getCurrentUrl();
	}
	
	public static WebElement getlistByClass(Webdriver driver)
	{	
		return driver.findElement(By.xpath("//li[@class='step_done step_done_last four']"));
    
	}
	
	public static WebElement getlistByClassAndId(Webdriver driver)
	{
		
		return driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']"));
    
	}
	
	public String getMessage(Webdriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText();
	}
}