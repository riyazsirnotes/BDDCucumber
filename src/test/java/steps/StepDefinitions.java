package steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {

	WebDriver driver;

	// before hooks

	@Before
	public void setUp() {

		System.out.println("This is Before hook");

	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Given("user starts {string} browser")
	public void user_starts_browser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	@Given("user launch app using url {string}")
	public void user_launch_app_using_url(String url) {

		driver.get(url);

		driver.manage().window().maximize();

	}

	@When("user enters username {string} using xpath {string}")
	public void user_enters_username_using_xpath(String text, String xpath) {

		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user enters password {string} using xpath {string}")
	public void user_enters_password_using_xpath(String text, String xpath) {

		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user clicks button using xpath {string}")
	public void user_clicks_button_using_xpath(String xpath) {

		driver.findElement(By.xpath(xpath)).click();
	}

	@Then("user validates title to be {string}")
	public void user_validates_title_to_be(String expTitle) {

		Assert.assertEquals(driver.getTitle(), expTitle);
	}

	@When("user clicks on link using xpath {string}")
	public void user_clicks_on_link_using_xpath(String xpath) {

		driver.findElement(By.xpath(xpath)).click();
	}

	@When("user enters text {string} using xpath {string}")
	public void user_enters_text_using_xpath(String text, String xpath) {

		driver.findElement(By.xpath(xpath)).clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user clicks checkbox using xpath {string}")
	public void user_clicks_checkbox_using_xpath(String xpath) {

		driver.findElement(By.xpath(xpath)).click();
	}

	@When("user enters details in registration form")
	public void user_enters_details_in_registration_form(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		// List<String> listOfValues=dataTable.asList();

		List<List<String>> listOfValues = dataTable.asLists();

		System.out.println("size is " + listOfValues.size());

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(listOfValues.get(0).get(0));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(listOfValues.get(0).get(1));
		driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(listOfValues.get(0).get(2));
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(listOfValues.get(0).get(3));
		driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(listOfValues.get(0).get(4));
		driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(listOfValues.get(0).get(5));

	}

	@When("user enters details in registration form using headers")
	public void user_enters_details_in_registration_form_using_headers(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		
		List<Map<String, String>>  dataMap=dataTable.asMaps();
		
		System.out.println(dataMap.size());
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(dataMap.get(0).get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataMap.get(0).get("password"));
		driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(dataMap.get(0).get("confirm password"));
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(dataMap.get(0).get("full name"));
		driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(dataMap.get(0).get("email id"));
		driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(dataMap.get(0).get("captcha"));
		
	}

}
