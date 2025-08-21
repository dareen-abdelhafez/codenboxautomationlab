import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();

	@BeforeTest

	public void SetUp() {
		driver.get("https://codenboxautomationlab.com/practice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test(priority = 1, enabled = false)
	public void RadioButton() {

		WebElement ContainerRadioButton = driver.findElement(By.xpath("//div[@id='radio-btn-example']//fieldset"));
		int RandomButton = rand.nextInt(3);
		ContainerRadioButton.findElements(By.tagName("input")).get(RandomButton).click();

	}

	@Test(priority = 2, enabled = false)
	public void Dynamic_Drop_Down() throws InterruptedException {

		String[] Countries = { "Jor", "Syr", "ira", "unit" };

		int RandomIndex = rand.nextInt(Countries.length);

		WebElement CountryInput = driver.findElement(By.id("autocomplete"));
		CountryInput.sendKeys(Countries[RandomIndex]);
		Thread.sleep(1000);
		CountryInput.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 3, enabled = false)

	public void Static_Drop_Down() throws InterruptedException {

		WebElement Select = driver.findElement(By.id("dropdown-class-example"));

		Select Randomchoice = new Select(Select);
		int Options = Select.findElements(By.tagName("option")).size();
		int RandomOptions = rand.nextInt(1, Options);
		Randomchoice.selectByIndex(RandomOptions);

	}

	@Test(priority = 4, enabled = false)

	public void checkbox() {

		WebElement CheckBox = driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset"));
		List<WebElement> CheckBoxContainer = CheckBox.findElements(By.tagName("input"));

		for (int i = 0; i < CheckBoxContainer.size(); i++) {
			CheckBoxContainer.get(i).click();

		}

	}

	@Test(priority = 5, enabled = false)
	public void openwindow() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700)");

		WebElement OpenWindow = driver.findElement(By.id("openwindow"));
		OpenWindow.click();
		System.out.println(driver.getTitle());
		Set<String> Handles = driver.getWindowHandles();
		List<String> AllTabs = new ArrayList<>(Handles);

		driver.switchTo().window(AllTabs.get(1));
		driver.findElement(By.xpath("//*[@id=\"menu-item-9680\"]/a")).click();
		driver.switchTo().window(AllTabs.get(0));
		System.out.println(driver.getTitle());

	}

	@Test(priority = 6, enabled = false)
	public void opentab() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,750)");

		WebElement OpenWindow = driver.findElement(By.id("opentab"));
		OpenWindow.click();
		System.out.println(driver.getTitle());
		Set<String> Handles = driver.getWindowHandles();
		List<String> AllTabs = new ArrayList<>(Handles);

		driver.switchTo().window(AllTabs.get(1));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.switchTo().window(AllTabs.get(0));

	}

	@Test(priority = 7, enabled = false)
	public void alertandconfirm() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,850)");
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("dareen");
		Thread.sleep(2000);
		WebElement alert = driver.findElement(By.id("alertbtn"));
		alert.click();
		driver.switchTo().alert().accept();

	}

	@Test(priority = 8, enabled = false)
	public void TheTable() {
		WebElement TheTable = driver.findElement(By.id("product"));
		List<WebElement> AllData = TheTable.findElements(By.tagName("tr"));

		for (int i = 0; i < AllData.size(); i++) {

			System.out.println(AllData.get(i).getText());

		}

	}

	@Test(priority = 9,enabled=false)
	public void HideAndShow() throws InterruptedException {

		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1400)");
		
		
		WebElement TheElementNeedToHide = driver.findElement(By.id("displayed-text"));
		WebElement TheButtonnToHide=driver.findElement(By.id("hide-textbox"));
		TheButtonnToHide.click();
		
		System.out.println(TheElementNeedToHide.isDisplayed());
		
		
		
		WebElement ShowButton=driver.findElement(By.id("show-textbox"));
		ShowButton.click();
		System.out.println(TheElementNeedToHide.isDisplayed());
		
		
	
	
		

	}

	@Test(priority =10,enabled=false)
	public void EnableAndDisable() {
		
		driver.findElement(By.id("disabled-button")).click();
		
		
		System.out.println(driver.findElement(By.id("enabled-example-input")).isEnabled());
		
		driver.findElement(By.id("enabled-button")).click();
		
		System.out.println(driver.findElement(By.id("enabled-button")).isEnabled());
		
		
	}
	@Test(priority =11)
	public void TopAndRelod() throws InterruptedException {

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1900)");
		
		
		Thread.sleep(4000);
		WebElement TheHover=driver.findElement(By.id("mousehover"));
		Actions action=new Actions(driver);
		action.moveToElement(TheHover).build().perform();
//		driver.findElement(By.linkText("Top")).click();
		driver.findElement(By.linkText("Reload")).click();
		
		
	
		
		
		
		
	}
	
	
	
	
}
