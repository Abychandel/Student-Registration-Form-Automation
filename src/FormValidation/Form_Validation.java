package FormValidation;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Form_Validation {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	 	driver.manage().deleteAllCookies();
	 	driver.manage().window().maximize();
	 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 	driver.get("https://demoqa.com/");
	 	Thread.sleep(1000); 
	 	
	 	JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,500)");
	 	Thread.sleep(1000);
	 	
	 	driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div")).click();
	 	Thread.sleep(1000);
	 	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[2]/div/ul/li")).click();
	 	
	 	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	 	js1.executeScript("window.scrollBy(0,200)");
	 	
	 	Thread.sleep(1000);
	 	
	 	driver.findElement(By.id("firstName")).sendKeys("John");
	 	driver.findElement(By.id("lastName")).sendKeys("Doe");
	 	Thread.sleep(1000);
	 	driver.findElement(By.id("userEmail")).sendKeys("abhaysinghchndl@gmail.com");
	 	Thread.sleep(1000);
	 	
	 	WebElement maleRadio = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        maleRadio.click();
        System.out.println("✅ Male radio button selected.");

        Thread.sleep(1000);

        // Select Female radio button
        WebElement femaleRadio = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        femaleRadio.click();
        System.out.println("✅ Female radio button selected.");

        Thread.sleep(1000);

        // Select Other radio button
        WebElement otherRadio = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        otherRadio.click();
        System.out.println("✅ Other radio button selected.");

        Thread.sleep(1000);
        
        WebElement maleRadio1 = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        maleRadio1.click(); 
        
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        Thread.sleep(2000);
        
        JavascriptExecutor js11 = (JavascriptExecutor) driver;
	 	js11.executeScript("window.scrollBy(0,300)");
	 	Thread.sleep(2000);
	 	
	 	 // Click on Date of Birth field to open the calendar
	 	driver.findElement(By.id("dateOfBirthInput")).click();
	 	
	    // --- Select Month ---
	 	WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
	 	Select month = new Select(monthDropdown);
        month.selectByVisibleText("September");
     
        // --- Select Year ---
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("2026"); // year

        // --- Select Day ---
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='10' and not(contains(@class,'outside-month'))]")).click();

        Thread.sleep(2000);
        
        
     // First click the container to activate the input
        WebElement subjectBox = driver.findElement(By.id("subjectsContainer"));
        subjectBox.click();

        // Now locate the input inside it
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement subjectInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='subjectsContainer']//input")
        ));

        // Type subject and select
        subjectInput.sendKeys("Maths");
        subjectInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
        WebElement readingRadio = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        readingRadio.click();
        System.out.println("✅ Reading radio button selected.");

        Thread.sleep(1000);
        
        WebElement uploadInput = driver.findElement(By.id("uploadPicture"));
        uploadInput.sendKeys("D:\\EclipseWork\\\\download.jpg");
        
        driver.findElement(By.id("currentAddress")).sendKeys("Testing Address");
        
        JavascriptExecutor js111 = (JavascriptExecutor) driver;
	 	js111.executeScript("window.scrollBy(0,200)");
	 	
        
        Thread.sleep(1000);
        
        WebElement stateDropdown = driver.findElement(By.xpath("//div[text()='Select State']"));
        stateDropdown.click();

        // Wait and select "NCR"
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        WebElement stateOption = wait1.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'NCR')]"))
        );
        stateOption.click();

        Thread.sleep(1000);

        // --- Select City ---
        WebElement cityDropdown = driver.findElement(By.xpath("//div[text()='Select City']"));
        cityDropdown.click();

        // Wait and select "Gurgaon"
        WebDriverWait wait11 = new WebDriverWait(driver, 10);
        WebElement cityOption = wait11.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Gurgaon')]"))
        );
        cityOption.click();

        Thread.sleep(1000);

        // --- Submit ---
        driver.findElement(By.id("submit")).click();
        driver.close();
	}
	
}





