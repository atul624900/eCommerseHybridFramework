package comPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	public WebDriver driver;
	public int a = 5;
	protected Properties prop;

	public BaseClass() throws IOException {

		prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\PropertiesPackage\\config.properties");
		FileInputStream str = new FileInputStream(propFile);
		prop.load(str);

	}

	public WebDriver setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\atulk\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		this.driver = driver;
		return driver;
		// Register register1 = new Register(driver);

	}

}
