import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();

	int Randomid;
	Connection con;
	Statement stmt;
	ResultSet rs;
	String FirstName;
	String LastName;
	String phone;
	String CustomerName;

	@BeforeTest

	public void SetUp() throws SQLException {

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "123456");
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

	@Test(priority = 9, enabled = false)
	public void HideAndShow() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1400)");

		WebElement TheElementNeedToHide = driver.findElement(By.id("displayed-text"));
		WebElement TheButtonnToHide = driver.findElement(By.id("hide-textbox"));
		TheButtonnToHide.click();

		System.out.println(TheElementNeedToHide.isDisplayed());

		WebElement ShowButton = driver.findElement(By.id("show-textbox"));
		ShowButton.click();
		System.out.println(TheElementNeedToHide.isDisplayed());

	}

	@Test(priority = 10, enabled = false)
	public void EnableAndDisable() {

		driver.findElement(By.id("disabled-button")).click();

		System.out.println(driver.findElement(By.id("enabled-example-input")).isEnabled());

		driver.findElement(By.id("enabled-button")).click();

		System.out.println(driver.findElement(By.id("enabled-button")).isEnabled());

	}

	@Test(priority = 11, enabled = false)
	public void TopAndRelod() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1900)");

		Thread.sleep(4000);
		WebElement TheHover = driver.findElement(By.id("mousehover"));
		Actions action = new Actions(driver);
		action.moveToElement(TheHover).build().perform();
//		driver.findElement(By.linkText("Top")).click();
		driver.findElement(By.linkText("Reload")).click();

	}

	@Test(priority = 1, enabled = true)
	public void AddData() throws SQLException {

		Randomid = rand.nextInt(5010, 6010);
		String QueryToAdd = "INSERT INTO customers (" + "    customerNumber," + "    customerName,"
				+ "    contactLastName," + "    contactFirstName," + "    phone," + "    addressLine1,"
				+ "    addressLine2," + "    city," + "    state," + "    postalCode," + "    country,"
				+ "    salesRepEmployeeNumber," + "    creditLimit" + ")" + "VALUES (" + Randomid + ","
				+ "    'Global Models Amman'," + "    'Al-Mansour'," + "    'faisal'," + "    '+962 6 555-1245',"
				+ "    '123 Rainbow St.'," + "    NULL," + "    'Amman'," + "    NULL," + "    '11118',"
				+ "    'Jordan'," + "    1370," + "    75000.00" + ");";

		stmt = con.createStatement();
		int RowInserted = stmt.executeUpdate(QueryToAdd);
		System.out.println(RowInserted);

	}

	@Test(priority = 2)
	public void UpdataData() throws SQLException {

		String QueryToUpdate = "UPDATE customers\r\n" + "SET contactFirstName = 'dareen',\r\n"
				+ "    contactLastName = 'abdelhafez'\r\n" + "WHERE customerNumber =" + Randomid;

		stmt = con.createStatement();
		int RowInserted = stmt.executeUpdate(QueryToUpdate);
		System.out.println(RowInserted);

	}

	@Test(priority = 3, enabled = true)
	public void Calaender() throws InterruptedException, SQLException {

		WebElement Calender = driver.findElement(By.linkText("Booking Calendar"));
		Calender.click();

		Set<String> Handles = driver.getWindowHandles();
		List<String> AllTabs = new ArrayList<>(Handles);

		driver.switchTo().window(AllTabs.get(1));

		WebElement BookAppoitment = driver.findElement(By.linkText("23"));
		Thread.sleep(2000);
		BookAppoitment.click();
		Thread.sleep(3000);
		// int randomnum=rand.nextInt(144,147);
		// to read randomly
		// String QueryToRead="select * from customers where customerNumber="+randomnum;
		String QueryToRead = "select * from customers where customerNumber=" + Randomid;

		stmt = con.createStatement();
		rs = stmt.executeQuery(QueryToRead);

		while (rs.next()) {

			FirstName = rs.getString("contactFirstName");
			LastName = rs.getString("contactLastName");
			phone = rs.getString("phone");
			CustomerName = rs.getString("customerName");

		}
		int Random = rand.nextInt(6000);
		String Email = FirstName + LastName + Random + "@gmail.com";

		WebElement FirstNameInput = driver.findElement(By.id("name1"));
		WebElement LastNameInput = driver.findElement(By.id("secondname1"));
		WebElement EmailInput = driver.findElement(By.id("email1"));
		WebElement Phoneinput = driver.findElement(By.id("phone1"));
		WebElement Details = driver.findElement(By.id("details1"));

		FirstNameInput.sendKeys(FirstName);
		LastNameInput.sendKeys(LastName);
		EmailInput.sendKeys(Email);
		Phoneinput.sendKeys(phone);
		Details.sendKeys(CustomerName);

	}

	@Test(priority = 4)
	public void DeleteData() throws SQLException {
		System.out.println(Randomid);

		String QueryToDelete = "DELETE FROM customers\r\n" + "WHERE customerNumber =" + Randomid;
		stmt = con.createStatement();
		int RowInserted = stmt.executeUpdate(QueryToDelete);
		System.out.println(RowInserted);

	}

	@Test(priority = 5,invocationCount=1)
	public void TakeAScreenShot() throws InterruptedException, IOException {

		Date Timestamp = new Date();
		Thread.sleep(2000);
		String newtimestamp = Timestamp.toString().replace(":", "-");

		TakesScreenshot ts = (TakesScreenshot) driver;
		JavascriptExecutor js=(JavascriptExecutor) driver;

		Thread.sleep(2000);
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./ScreenShot_Folder/" + newtimestamp + ".jpg"));
		
		
		

		Date Timestamp2 = new Date();
		Thread.sleep(2000);
		String newtimestamp2 = Timestamp2.toString().replace(":", "-");
		
		js.executeScript("window.scrollTo(0,800)");
		File file2 = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file2, new File("./ScreenShot_Folder/" + newtimestamp2 + ".jpg"));

	}
}
